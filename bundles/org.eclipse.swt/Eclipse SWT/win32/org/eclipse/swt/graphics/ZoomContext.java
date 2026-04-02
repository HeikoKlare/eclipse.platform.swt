/*******************************************************************************
 * Copyright (c) 2026 Yatta Solutions and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Yatta Solutions - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.graphics;

/**
 * ZoomContext holds information about zoom details used to create and cache
 * image handles.
 * <p>
 * <b>IMPORTANT:</b> This class is <em>not</em> part of the public API for SWT.
 * It is marked package-private and intended only for internal use within the
 * SWT win32 implementation. It is not available on all platforms.
 * </p>
 *
 * @param targetZoom zoom value the OS handle will be created, cached and served
 *   for; it is usually an auto-scaled zoom
 * @param nativeZoom native zoom that can be used as context for the creation of
 *   the handle, e.g. as font zoom for drawing on the image with a GC
 */
record ZoomContext(int targetZoom, int nativeZoom) {

	ZoomContext(int targetZoom) {
		this(targetZoom, targetZoom);
	}
}
