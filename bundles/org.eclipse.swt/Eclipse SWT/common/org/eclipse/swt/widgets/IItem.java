package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface IItem extends IWidget {

	Image getImage();

	String getText();

	void setImage(Image image);

	void setText(String string);

	@Override
	Item getWrapper();

}