package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface IMenu extends IWidget {

	void addHelpListener(HelpListener listener);

	void addMenuListener(MenuListener listener);

	MenuItem getDefaultItem();

	boolean getEnabled();

	MenuItem getItem(int index);

	int getItemCount();

	MenuItem[] getItems();

	int getOrientation();

	Decorations getParent();

	MenuItem getParentItem();

	Menu getParentMenu();

	Shell getShell();

	boolean getVisible();

	int indexOf(MenuItem item);

	boolean isEnabled();

	boolean isVisible();

	void removeHelpListener(HelpListener listener);

	void removeMenuListener(MenuListener listener);

	void setDefaultItem(MenuItem item);

	void setEnabled(boolean enabled);

	void setLocation(int x, int y);

	void setLocation(Point location);

	void setOrientation(int orientation);

	void setVisible(boolean visible);

	@Override
	Menu getWrapper();

}