package it.michele.controllers.editors;

import java.util.*;
import java.text.*;

import java.beans.PropertyEditorSupport;

public class DateEditor extends PropertyEditorSupport
{
	private static String DATE_FORMAT = "dd/MM/yyyy";

	@Override
	public void setAsText(String value) throws IllegalArgumentException
	{
		if(value == null || value.equals(""))
		{
			return;
		}

		/*
		 * Controls the length and format of the date to prevent the parsing of dates as 10/10/201T and performs the conversion.
		 */
		if(value.matches("\\d{2}\\/\\d{2}\\/\\d{4}"))
		{
			try
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

				dateFormat.setLenient(false);

				this.setValue(dateFormat.parse(value));
			}
			catch(Exception e)
			{
				throw new IllegalArgumentException("The date is incorrect" + e.getMessage());
			}
		}
		else
		{
			throw new IllegalArgumentException("The date is incorrect");
		}
	}

	@Override
	public String getAsText()
	{
		String retValue = "";

		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

			if(this.getValue() != null)
			{
				retValue = dateFormat.format((Date)this.getValue());
			}
		}
		catch(Exception e) {}

		return retValue;
	}
}