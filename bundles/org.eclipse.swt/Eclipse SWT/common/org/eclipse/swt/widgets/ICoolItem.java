package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public interface ICoolItem extends IItem {

	void addSelectionListener(SelectionListener listener);

	Point computeSize(int wHint, int hHint);

	Rectangle getBounds();

	Control getControl();

	CoolBar getParent();

	void setControl(Control control);

	Point getPreferredSize();

	void setPreferredSize(int width, int height);

	void setPreferredSize(Point size);

	Point getSize();

	void setSize(int width, int height);

	void setSize(Point size);

	Point getMinimumSize();

	void setMinimumSize(int width, int height);

	void setMinimumSize(Point size);

	void removeSelectionListener(SelectionListener listener);

	@Override
	CoolItem getWrapper();

}