package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface ITreeItem extends IItem {

	void clear(int index, boolean all);

	void clearAll(boolean all);

	Color getBackground();

	Color getBackground(int index);

	Rectangle getBounds();

	Rectangle getBounds(int index);

	boolean getChecked();

	boolean getExpanded();

	Font getFont();

	Font getFont(int index);

	Color getForeground();

	Color getForeground(int index);

	boolean getGrayed();

	TreeItem getItem(int index);

	int getItemCount();

	TreeItem[] getItems();

	Image getImage(int index);

	Rectangle getImageBounds(int index);

	Tree getParent();

	TreeItem getParentItem();

	String getText(int index);

	Rectangle getTextBounds(int index);

	int indexOf(TreeItem item);

	void removeAll();

	void setBackground(Color color);

	void setBackground(int index, Color color);

	void setChecked(boolean checked);

	void setExpanded(boolean expanded);

	void setFont(Font font);

	void setFont(int index, Font font);

	void setForeground(Color color);

	void setForeground(int index, Color color);

	void setGrayed(boolean grayed);

	void setImage(Image[] images);

	void setImage(int index, Image image);

	void setItemCount(int count);

	void setText(String[] strings);

	void setText(int index, String string);

	@Override
	TreeItem getWrapper();

}