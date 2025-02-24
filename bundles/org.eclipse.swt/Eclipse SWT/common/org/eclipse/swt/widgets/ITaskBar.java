package org.eclipse.swt.widgets;

public interface ITaskBar extends IWidget {

	TaskItem getItem(int index);

	TaskItem getItem(Shell shell);

	int getItemCount();

	TaskItem[] getItems();

	@Override
	TaskBar getWrapper();

}