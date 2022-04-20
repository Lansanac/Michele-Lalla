package it.michele.services.exceptions;

@SuppressWarnings("serial")
public class ServiceValidationException extends Exception
{
	private Integer code;
	public ServiceValidationException()
	{
		super();
	}

	public ServiceValidationException(Integer code, String message)
	{
		super(message);
		this.code=code;
	} 
	public ServiceValidationException(String message)
	{
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceValidationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public ServiceValidationException(Throwable cause)
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