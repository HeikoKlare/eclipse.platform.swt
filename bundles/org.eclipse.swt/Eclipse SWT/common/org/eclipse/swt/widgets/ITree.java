package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface ITree extends IComposite {

	void addSelectionListener(SelectionListener listener);

	void addTreeListener(TreeListener listener);

	void clear(int index, boolean all);

	void clearAll(boolean all);

	void deselect(TreeItem item);

	void deselectAll();

	int getGridLineWidth();

	Color getHeaderBackground();

	Color getHeaderForeground();

	int getHeaderHeight();

	boolean getHeaderVisible();

	TreeColumn getColumn(int index);

	int getColumnCount();

	int[] getColumnOrder();

	TreeColumn[] getColumns();

	TreeItem getItem(int index);

	TreeItem getItem(Point point);

	int getItemCount();

	int getItemHeight();

	TreeItem[] getItems();

	boolean getLinesVisible();

	TreeItem getParentItem();

	TreeItem[] getSelection();

	int getSelectionCount();

	TreeColumn getSortColumn();

	int getSortDirection();

	TreeItem getTopItem();

	int indexOf(TreeColumn column);

	int indexOf(TreeItem item);

	void removeAll();

	void removeSelectionListener(SelectionListener listener);

	void removeTreeListener(TreeListener listener);

	void setInsertMark(TreeItem item, boolean before);

	void setItemCount(int count);

	void setLinesVisible(boolean show);

	void select(TreeItem item);

	void selectAll();

	void setColumnOrder(int[] order);

	void setHeaderBackground(Color color);

	void setHeaderForeground(Color color);

	void setHeaderVisible(boolean show);

	void setSelection(TreeItem item);

	void setSelection(TreeItem[] items);

	void setSortColumn(TreeColumn column);

	void setSortDirection(int direction);

	void setTopItem(TreeItem item);

	void showColumn(TreeColumn column);

	void showItem(TreeItem item);

	void showSelection();

	@Override
	Tree getWrapper();

}