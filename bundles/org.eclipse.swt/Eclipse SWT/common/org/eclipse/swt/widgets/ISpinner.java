package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;

public interface ISpinner extends IComposite {

	void addModifyListener(ModifyListener listener);

	void addSelectionListener(SelectionListener listener);

	void copy();

	void cut();

	int getDigits();

	int getIncrement();

	int getMaximum();

	int getMinimum();

	int getPageIncrement();

	int getSelection();

	String getText();

	int getTextLimit();

	void paste();

	void removeModifyListener(ModifyListener listener);

	void removeSelectionListener(SelectionListener listener);

	void setDigits(int value);

	void setIncrement(int value);

	void setMaximum(int value);

	void setMinimum(int value);

	void setPageIncrement(int value);

	void setSelection(int value);

	void setTextLimit(int limit);

	void setValues(int selection, int minimum, int maximum, int digits, int increment, int pageIncrement);

	@Override
	Spinner getWrapper();

}