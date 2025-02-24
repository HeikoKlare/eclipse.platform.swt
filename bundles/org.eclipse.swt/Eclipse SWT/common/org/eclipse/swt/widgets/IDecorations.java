package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface IDecorations extends ICanvas {

	Button getDefaultButton();

	Image getImage();

	Image[] getImages();

	boolean getMaximized();

	Menu getMenuBar();

	boolean getMinimized();

	String getText();

	@Override
	boolean isReparentable();

	void setDefaultButton(Button button);

	void setImage(Image image);

	void setImages(Image[] images);

	void setMaximized(boolean maximized);

	void setMenuBar(Menu menu);

	void setMinimized(boolean minimized);

	@Override
	void setOrientation(int orientation);

	void setText(String string);

	@Override
	void setVisible(boolean visible);

	@Override
	Decorations getWrapper();

}