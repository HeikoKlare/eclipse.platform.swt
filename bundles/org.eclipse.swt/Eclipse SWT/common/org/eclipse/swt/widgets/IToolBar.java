package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface IToolBar extends IComposite {

	ToolItem getItem(int index);

	ToolItem getItem(Point point);

	int getItemCount();

	ToolItem[] getItems();

	int getRowCount();

	int indexOf(ToolItem item);

	@Override
	ToolBar getWrapper();

}