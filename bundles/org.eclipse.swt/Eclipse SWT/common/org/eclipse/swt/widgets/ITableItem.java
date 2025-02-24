package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface ITableItem extends IItem {

	Color getBackground();

	Color getBackground(int index);

	Rectangle getBounds();

	Rectangle getBounds(int index);

	boolean getChecked();

	Font getFont();

	Font getFont(int index);

	Color getForeground();

	Color getForeground(int index);

	boolean getGrayed();

	Image getImage(int index);

	Rectangle getImageBounds(int index);

	int getImageIndent();

	Table getParent();

	String getText(int index);

	Rectangle getTextBounds(int index);

	void setBackground(Color color);

	void setBackground(int index, Color color);

	void setChecked(boolean checked);

	void setFont(Font font);

	void setFont(int index, Font font);

	void setForeground(Color color);

	void setForeground(int index, Color color);

	void setGrayed(boolean grayed);

	void setImage(Image[] images);

	void setImage(int index, Image image);

	@Deprecated
	void setImageIndent(int indent);

	void setText(String[] strings);

	void setText(int index, String string);

	@Override
	TableItem getWrapper();

}