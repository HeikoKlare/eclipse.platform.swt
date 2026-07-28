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

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.internal.*;

class ToolBarImageLists {
	private final Display display;

	private final ImageList imageList, disabledImageList, hotImageList;

	private final ImageListsRefresh imageListsRefresh;

	@FunctionalInterface
	interface ImageListsRefresh {
		void execute(ImageList imageList, ImageList hotImageList, ImageList disabledImageList);
	}

	private ToolBarImageLists(Display display, ImageList imageList, ImageList hotImageList, ImageList disabledImageList,
			ImageListsRefresh imageListsRefresh) {
		this.display = display;
		this.imageList = imageList;
		this.hotImageList = hotImageList;
		this.disabledImageList = disabledImageList;
		this.imageListsRefresh = imageListsRefresh;
	}

	static ToolBarImageLists create(Display display, int style, int width, int height, int zoom,
			ImageListsRefresh imageListsRefresh) {
		ImageList imageList = display.getImageListToolBar(style, width, height, zoom);
		ImageList hotImageList = display.getImageListToolBarHot(style, width, height, zoom);
		ImageList disabledImageList = display.getImageListToolBarDisabled(style, width, height, zoom);
		return new ToolBarImageLists(display, imageList, hotImageList, disabledImageList, imageListsRefresh);
	}

	void refreshImageLists() {
		imageListsRefresh.execute(imageList, hotImageList, disabledImageList);
	}

	void clear(int index) {
		imageList.put(index, null);
		hotImageList.put(index, null);
		disabledImageList.put(index, null);
	}

	void clearAndRelease() {
		imageListsRefresh.execute(null, null, null);
		release();
	}

	private void release() {
		display.releaseToolImageList(imageList);
		display.releaseToolHotImageList(hotImageList);
		display.releaseToolDisabledImageList(disabledImageList);
	}

	ToolBarImageLists replace(ToolBarImageLists next) {
		release();
		next.refreshImageLists();
		return next;
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

	int addFrom(ToolBarImageLists imageLists, int index) {
		return this.add(imageLists.imageList.get(index), imageLists.hotImageList.get(index),
				imageLists.disabledImageList.get(index));
	}

	Point getImageSize() {
		return imageList.getImageSize();
	}

}
