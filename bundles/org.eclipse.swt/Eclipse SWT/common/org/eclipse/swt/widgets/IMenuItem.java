package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
public interface IMenuItem extends IItem {

	void addArmListener(ArmListener listener);

	void addHelpListener(HelpListener listener);

	void addSelectionListener(SelectionListener listener);

	int getAccelerator();

	boolean getEnabled();

	int getID();

	Menu getMenu();

	Menu getParent();

	boolean getSelection();

	String getToolTipText();

	boolean isEnabled();

	void removeArmListener(ArmListener listener);

	void removeHelpListener(HelpListener listener);

	void removeSelectionListener(SelectionListener listener);

	void setAccelerator(int accelerator);

	void setEnabled(boolean enabled);

	void setID(int id);

	void setMenu(Menu menu);

	void setSelection(boolean selected);

	void setToolTipText(String toolTip);

	@Override
	MenuItem getWrapper();

}