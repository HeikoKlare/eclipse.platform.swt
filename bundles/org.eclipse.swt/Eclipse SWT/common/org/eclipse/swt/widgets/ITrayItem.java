package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
public interface ITrayItem extends IItem {

	void addSelectionListener(SelectionListener listener);

	void addMenuDetectListener(MenuDetectListener listener);

	Image getHighlightImage();

	Tray getParent();

	ToolTip getToolTip();

	String getToolTipText();

	boolean getVisible();

	void removeSelectionListener(SelectionListener listener);

	void removeMenuDetectListener(MenuDetectListener listener);

	void setHighlightImage(Image image);

	void setToolTip(ToolTip toolTip);

	void setToolTipText(String string);

	void setVisible(boolean visible);

	@Override
	TrayItem getWrapper();

}