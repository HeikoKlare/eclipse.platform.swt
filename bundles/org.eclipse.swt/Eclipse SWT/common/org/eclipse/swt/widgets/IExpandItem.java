package org.eclipse.swt.widgets;

public interface IExpandItem extends IItem {

	Control getControl();

	boolean getExpanded();

	int getHeaderHeight();

	int getHeight();

	ExpandBar getParent();

	void setControl(Control control);

	void setExpanded(boolean expanded);

	void setHeight(int height);

	@Override
	ExpandItem getWrapper();

}