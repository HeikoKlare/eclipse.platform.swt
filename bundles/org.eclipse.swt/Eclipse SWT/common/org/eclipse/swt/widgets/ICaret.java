package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface ICaret extends IWidget {

	Rectangle getBounds();

	Font getFont();

	Image getImage();

	Point getLocation();

	NativeCanvas getParent();

	Point getSize();

	boolean getVisible();

	boolean isVisible();

	void setBounds(int x, int y, int width, int height);

	void setBounds(Rectangle rect);

	void setFont(Font font);

	void setImage(Image image);

	void setLocation(int x, int y);

	void setLocation(Point location);

	void setSize(int width, int height);

	void setSize(Point size);

	void setVisible(boolean visible);

	@Override
	Caret getWrapper();

}