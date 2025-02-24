package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.*;

public interface ITaskItem extends IItem {

	Image getOverlayImage();

	String getOverlayText();

	TaskBar getParent();

	int getProgress();

	int getProgressState();

	void setMenu(Menu menu);

	void setOverlayImage(Image overlayImage);

	void setOverlayText(String overlayText);

	void setProgress(int progress);

	void setProgressState(int progressState);

	@Override
	TaskItem getWrapper();

}