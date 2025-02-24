package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface ITabFolder extends IComposite {

	void addSelectionListener(SelectionListener listener);

	TabItem getItem(int index);

	TabItem getItem(Point point);

	int getItemCount();

	TabItem[] getItems();

	TabItem[] getSelection();

	int getSelectionIndex();

	int indexOf(TabItem item);

	void removeSelectionListener(SelectionListener listener);

	void setSelection(TabItem item);

	void setSelection(TabItem[] items);

	void setSelection(int index);

	@Override
	TabFolder getWrapper();

}