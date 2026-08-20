/*******************************************************************************
 * Copyright (c) 2026 Vector Informatik GmbH and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.swt.widgets;

import java.util.function.*;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.internal.*;
import org.eclipse.swt.internal.win32.*;

/**
 * Owns the normal, hot and disabled image lists of a tool bar as a single unit.
 * The three lists are always created, filled, cleared and released together, so
 * they are of equal image size and the index returned when adding an item's
 * images addresses that item in all three of them.
 */
class ToolBarImageLists {
	private final Display display;

	private final long toolbarHandle;

	private final ImageList imageList, disabledImageList, hotImageList;

	private int zoom;

	private ToolBarImageLists(Display display, long toolbarHandle, ImageList imageList, ImageList hotImageList,
			ImageList disabledImageList, int zoom) {
		this.display = display;
		this.toolbarHandle = toolbarHandle;
		this.imageList = imageList;
		this.hotImageList = hotImageList;
		this.disabledImageList = disabledImageList;
		this.zoom = zoom;
	}

	static ToolBarImageLists create(Display display, long toolbarHandle, int style, int width, int height, int zoom) {
		ImageList imageList = display.getImageListToolBar(style, width, height, zoom);
		ImageList hotImageList = display.getImageListToolBarHot(style, width, height, zoom);
		ImageList disabledImageList = display.getImageListToolBarDisabled(style, width, height, zoom);
		return new ToolBarImageLists(display, toolbarHandle, imageList, hotImageList, disabledImageList, zoom);
	}

	void clear(int index) {
		imageList.put(index, null);
		hotImageList.put(index, null);
		disabledImageList.put(index, null);
	}

	int add(Image image, Image hotImage, Image disabledImage) {
		int index = imageList.add(image);
		hotImageList.add(hotImage);
		disabledImageList.add(disabledImage);
		return index;
	}

	void put(int index, Image image, Image hotImage, Image disabledImage) {
		imageList.put(index, image);
		hotImageList.put(index, hotImage);
		disabledImageList.put(index, disabledImage);
	}

	int moveFrom(ToolBarImageLists source, int index) {
		Image image = source.imageList.get(index);
		Image hotImage = source.hotImageList.get(index);
		Image disabledImage = source.disabledImageList.get(index);
		source.clear(index);
		return add(image, hotImage, disabledImage);
	}

	void attachOrRefresh(int zoom, Consumer<Boolean> beforeAfterHook) {
		this.zoom = zoom;
		long imageListHandle = imageList.getHandle(zoom);
		long hotImageListHandle = hotImageList.getHandle(zoom);
		long disabledImageListHandle = disabledImageList.getHandle(zoom);
		boolean imageListOutdated = isImageListOutdated(toolbarHandle, OS.TB_GETIMAGELIST, imageListHandle);
		boolean hotImageListOutdated = isImageListOutdated(toolbarHandle, OS.TB_GETHOTIMAGELIST, hotImageListHandle);
		boolean disabledImageListOutdated = isImageListOutdated(toolbarHandle, OS.TB_GETDISABLEDIMAGELIST, disabledImageListHandle);
		if (!imageListOutdated && !hotImageListOutdated && !disabledImageListOutdated) {
			return;
		}
		beforeAfterHook.accept(false);
		if (imageListOutdated) {
			OS.SendMessage(toolbarHandle, OS.TB_SETIMAGELIST, 0, imageListHandle);
		}
		if (hotImageListOutdated) {
			OS.SendMessage(toolbarHandle, OS.TB_SETHOTIMAGELIST, 0, hotImageListHandle);
		}
		if (disabledImageListOutdated) {
			OS.SendMessage(toolbarHandle, OS.TB_SETDISABLEDIMAGELIST, 0, disabledImageListHandle);
		}
		beforeAfterHook.accept(true);
	}

	private boolean isImageListOutdated(long handle, int getMessageCode, long expectedHandle) {
		return OS.SendMessage(handle, getMessageCode, 0, 0) != expectedHandle;
	}

	void detachAndRelease() {
		OS.SendMessage(toolbarHandle, OS.TB_SETIMAGELIST, 0, 0);
		OS.SendMessage(toolbarHandle, OS.TB_SETHOTIMAGELIST, 0, 0);
		OS.SendMessage(toolbarHandle, OS.TB_SETDISABLEDIMAGELIST, 0, 0);
		release();
	}

	private void release() {
		display.releaseToolImageList(imageList);
		display.releaseToolHotImageList(hotImageList);
		display.releaseToolDisabledImageList(disabledImageList);
	}

	ToolBarImageLists replaceWithNewStyle(int style, Consumer<ToolBarImageLists> imageTransfer) {
		Point imageSize = imageList.getImageSize();
		ToolBarImageLists newImageLists = create(display, toolbarHandle, style, imageSize.x, imageSize.y, zoom);
		imageTransfer.accept(newImageLists);
		attachOrRefresh(zoom, __ -> {});
		release();
		return newImageLists;
	}

}
