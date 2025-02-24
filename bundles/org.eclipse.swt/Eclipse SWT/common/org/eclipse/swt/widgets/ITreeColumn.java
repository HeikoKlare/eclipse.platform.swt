package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
public interface ITreeColumn extends IItem {

	void addControlListener(ControlListener listener);

	void addSelectionListener(SelectionListener listener);

	int getAlignment();

	boolean getMoveable();

	Tree getParent();

	boolean getResizable();

	String getToolTipText();

	int getWidth();

	void pack();

	void removeControlListener(ControlListener listener);

	void removeSelectionListener(SelectionListener listener);

	void setAlignment(int alignment);

	void setMoveable(boolean moveable);

	void setResizable(boolean resizable);

	void setToolTipText(String string);

	void setWidth(int width);

	@Override
	TreeColumn getWrapper();

}