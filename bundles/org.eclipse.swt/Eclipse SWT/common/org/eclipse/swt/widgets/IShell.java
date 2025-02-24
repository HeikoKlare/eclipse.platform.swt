package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
public interface IShell extends IDecorations {

	void addShellListener(ShellListener listener);

	void close();

	void forceActive();

	int getAlpha();

	boolean getFullScreen();

	int getImeInputMode();

	Point getMaximumSize();

	Point getMinimumSize();

	boolean getModified();

	Shell getShell();

	Shell[] getShells();

	ToolBar getToolBar();

	void open();

	void removeShellListener(ShellListener listener);

	void setActive();

	void setAlpha(int alpha);

	void setFullScreen(boolean fullScreen);

	void setImeInputMode(int mode);

	void setMaximumSize(int width, int height);

	void setMaximumSize(Point size);

	void setMinimumSize(int width, int height);

	void setMinimumSize(Point size);

	void setModified(boolean modified);

	@Override
	Shell getWrapper();

}