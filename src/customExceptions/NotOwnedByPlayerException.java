package customExceptions;

public class NotOwnedByPlayerException extends Exception{
	public NotOwnedByPlayerException(String s)
	{
		super(s);
	}
}
