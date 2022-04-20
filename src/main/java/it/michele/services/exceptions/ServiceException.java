package it.michele.services.exceptions;

@SuppressWarnings("serial")
public class ServiceException extends Exception
{
	private Integer code;
	public ServiceException()
	{
		super();
	}

	public ServiceException(Integer code, String message)
	{
		super(message);
		this.code=code;
	} 
	public ServiceException(String message)
	{
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause)
	{
		super(cause);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
}