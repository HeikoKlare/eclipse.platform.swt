package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface IToolTip extends IWidget {

	void addSelectionListener(SelectionListener listener);

	boolean getAutoHide();

	String getMessage();

	NativeShell getParent();

	String getText();

	boolean getVisible();

	boolean isVisible();

	void removeSelectionListener(SelectionListener listener);

	void setAutoHide(boolean autoHide);

	void setLocation(int x, int y);

	void setLocation(Point location);

	void setMessage(String string);

	void setText(String string);

	void setVisible(boolean visible);

	@Override
	ToolTip getWrapper();

}