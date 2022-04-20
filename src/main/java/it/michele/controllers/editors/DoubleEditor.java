package it.michele.controllers.editors;

import java.beans.PropertyEditorSupport;

public class DoubleEditor extends PropertyEditorSupport
{
	@Override
	public void setAsText(String value) throws IllegalArgumentException
	{
		if(value == null || value.equals(""))
		{
			return;
		}

		String[] sep = {".", ","};

		try
		{
			if(	value.indexOf(sep[0]) > -1 ||
				value.indexOf(".") == 0 || value.indexOf(".") == value.length() - 1 ||
				value.indexOf(",") == 0 || value.indexOf(",") == value.length() - 1)
			{
				throw new NumberFormatException();
			}

			value = value.replace(sep[1], sep[0]);

			this.setValue(new Double(value));
		}
		catch(NumberFormatException nfe)
		{
			throw new IllegalArgumentException("The decimal is incorrect");
		}
	}

	@Override
	public String getAsText()
	{
		String retValue = "";

		if(this.getValue() != null)
		{
			Double decimal = (Double)this.getValue();

			retValue = decimal.toString().replace(".", ",");
		}

		return retValue;
	}
}