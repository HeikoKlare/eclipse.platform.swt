package org.eclipse.swt.widgets;

public interface ITray extends IWidget {

	TrayItem getItem(int index);

	int getItemCount();

	TrayItem[] getItems();

	@Override
	Tray getWrapper();

}