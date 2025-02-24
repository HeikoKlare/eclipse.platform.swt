package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface ITable extends IComposite {

	void addSelectionListener(SelectionListener listener);

	void clear(int index);

	void clear(int start, int end);

	void clear(int[] indices);

	void clearAll();

	void deselect(int[] indices);

	void deselect(int index);

	void deselect(int start, int end);

	void deselectAll();

	TableColumn getColumn(int index);

	int getColumnCount();

	int[] getColumnOrder();

	TableColumn[] getColumns();

	int getGridLineWidth();

	Color getHeaderBackground();

	Color getHeaderForeground();

	int getHeaderHeight();

	boolean getHeaderVisible();

	TableItem getItem(int index);

	TableItem getItem(Point point);

	int getItemCount();

	int getItemHeight();

	TableItem[] getItems();

	boolean getLinesVisible();

	TableItem[] getSelection();

	int getSelectionCount();

	int getSelectionIndex();

	int[] getSelectionIndices();

	TableColumn getSortColumn();

	int getSortDirection();

	int getTopIndex();

	int indexOf(TableColumn column);

	int indexOf(TableItem item);

	boolean isSelected(int index);

	void remove(int[] indices);

	void remove(int index);

	void remove(int start, int end);

	void removeAll();

	void removeSelectionListener(SelectionListener listener);

	void select(int[] indices);

	void select(int index);

	void select(int start, int end);

	void selectAll();

	void setColumnOrder(int[] order);

	void setHeaderBackground(Color color);

	void setHeaderForeground(Color color);

	void setHeaderVisible(boolean show);

	void setItemCount(int count);

	void setLinesVisible(boolean show);

	void setSelection(int[] indices);

	void setSelection(TableItem item);

	void setSelection(TableItem[] items);

	void setSelection(int index);

	void setSelection(int start, int end);

	void setSortColumn(TableColumn column);

	void setSortDirection(int direction);

	void setTopIndex(int index);

	void showColumn(TableColumn column);

	void showItem(TableItem item);

	void showSelection();

	@Override
	Table getWrapper();

}