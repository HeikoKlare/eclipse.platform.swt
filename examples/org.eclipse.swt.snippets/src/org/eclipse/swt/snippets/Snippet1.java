/*******************************************************************************
 * Copyright (c) 2000, 2012 IBM Corporation and others.
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
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
/*
 * example snippet: Hello World
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.widgets.*;

public class Snippet1 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell(display);
	shell.setText("Snippet");
	shell.setLayout(new GridLayout());
	Combo combo = new Combo(shell, SWT.DROP_DOWN);
	combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	combo.add("first");
	combo.add("second");
	combo.select(0);
	System.out.println(combo.getSelectionIndex());
	combo.addMouseListener(MouseListener.mouseDownAdapter(e -> System.out.println(combo.getSelectionIndex())));
	Text text = new Text(shell, SWT.NONE);
	text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}
