package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface ICoolBar extends IComposite {

	CoolItem getItem(int index);

	int getItemCount();

	int[] getItemOrder();

	CoolItem[] getItems();

	Point[] getItemSizes();

	boolean getLocked();

	int[] getWrapIndices();

	int indexOf(CoolItem item);

	void setItemLayout(int[] itemOrder, int[] wrapIndices, Point[] sizes);

	void setLocked(boolean locked);

	void setWrapIndices(int[] indices);

	@Override
	CoolBar getWrapper();

}