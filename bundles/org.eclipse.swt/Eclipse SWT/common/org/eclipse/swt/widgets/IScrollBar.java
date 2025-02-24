package org.eclipse.swt.widgets;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface IScrollBar extends IWidget {

	void addSelectionListener(SelectionListener listener);

	boolean getEnabled();

	int getIncrement();

	int getMaximum();

	int getMinimum();

	int getPageIncrement();

	Scrollable getParent();

	int getSelection();

	Point getSize();

	int getThumb();

	Rectangle getThumbBounds();

	Rectangle getThumbTrackBounds();

	boolean getVisible();

	boolean isEnabled();

	boolean isVisible();

	void removeSelectionListener(SelectionListener listener);

	void setEnabled(boolean enabled);

	void setIncrement(int value);

	void setMaximum(int value);

	void setMinimum(int value);

	void setPageIncrement(int value);

	void setSelection(int selection);

	void setThumb(int value);

	void setValues(int selection, int minimum, int maximum, int thumb, int increment, int pageIncrement);

	void setVisible(boolean visible);

	@Override
	ScrollBar getWrapper();

}