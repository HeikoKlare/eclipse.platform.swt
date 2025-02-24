package org.eclipse.swt.widgets;

import org.eclipse.swt.events.*;

public interface IDateTime extends IComposite {

	void addSelectionListener(SelectionListener listener);

	int getDay();

	int getHours();

	int getMinutes();

	int getMonth();

	int getSeconds();

	int getYear();

	void removeSelectionListener(SelectionListener listener);

	void setDate(int year, int month, int day);

	void setDay(int day);

	void setHours(int hours);

	void setMinutes(int minutes);

	void setMonth(int month);

	void setSeconds(int seconds);

	void setTime(int hours, int minutes, int seconds);

	void setYear(int year);

	@Override
	DateTime getWrapper();

}