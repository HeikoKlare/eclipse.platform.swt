package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface ITabItem extends IItem {

	Control getControl();

	Rectangle getBounds();

	TabFolder getParent();

	String getToolTipText();

	void setControl(Control control);

	void setToolTipText(String string);

	@Override
	TabItem getWrapper();

}