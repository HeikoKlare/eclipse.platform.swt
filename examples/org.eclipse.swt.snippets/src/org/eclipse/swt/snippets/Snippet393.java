/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet393 {

	public static void main(String[] args) {
		final Display display = new Display();

		final Shell shell = new Shell(display);
		final FillLayout fillLayout = new FillLayout();
		fillLayout.marginWidth = fillLayout.marginHeight = 20;
		shell.setLayout(fillLayout);

		final ScrolledComposite sc = new ScrolledComposite(shell, SWT.H_SCROLL | SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);

		final Label label = new Label(sc, SWT.WRAP);
		label.setText("This is a longer line, but not very long.\nanother line");
		sc.setContent(label);

		sc.addControlListener(ControlListener.controlResizedAdapter(e -> {
			final Rectangle.OfFloat r = Rectangle.OfFloat.from(sc.getClientArea());
			Point size = r.getBottomRight();
			size.y = SWT.DEFAULT;
			final Point.OfFloat size1 = Point.OfFloat.from(label.computeSize(size, true));
			Point.OfFloat size2 = new Point.OfFloat(size1.getX(), size1.getY(), RoundingMode.DOWN);
			sc.setMinSize(size2.x, size2.y);
		}));

		shell.setSize(300, 100);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
	}
}
