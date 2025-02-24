package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface IIME extends IWidget {

	int getCaretOffset();

	int getCommitCount();

	int getCompositionOffset();

	int[] getRanges();

	TextStyle[] getStyles();

	String getText();

	boolean getWideCaret();

	void setCompositionOffset(int offset);

	@Override
	IME getWrapper();

}