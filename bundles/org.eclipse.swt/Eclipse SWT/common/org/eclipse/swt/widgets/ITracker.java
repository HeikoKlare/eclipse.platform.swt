package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface ITracker extends IWidget {

	void addControlListener(ControlListener listener);

	void addKeyListener(KeyListener listener);

	void close();

	Rectangle[] getRectangles();

	boolean getStippled();

	boolean open();

	void removeControlListener(ControlListener listener);

	void removeKeyListener(KeyListener listener);

	void setCursor(Cursor newCursor);

	void setRectangles(Rectangle[] rectangles);

	void setStippled(boolean stippled);

	@Override
	Tracker getWrapper();

}