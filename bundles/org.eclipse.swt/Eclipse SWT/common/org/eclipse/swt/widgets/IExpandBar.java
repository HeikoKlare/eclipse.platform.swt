package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;

public interface IExpandBar extends IComposite {

	void addExpandListener(ExpandListener listener);

	ExpandItem getItem(int index);

	int getItemCount();

	ExpandItem[] getItems();

	int getSpacing();

	int indexOf(ExpandItem item);

	void removeExpandListener(ExpandListener listener);

	void setSpacing(int spacing);

	@Override
	ExpandBar getWrapper();

}