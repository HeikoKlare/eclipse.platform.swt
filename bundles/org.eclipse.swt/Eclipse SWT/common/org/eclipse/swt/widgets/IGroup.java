package org.eclipse.swt.widgets;

public interface IGroup extends IComposite {

	String getText();

	void setText(String string);

	@Override
	Group getWrapper();

}