// Name: Christelle Nieves

public class NegativeDamageException extends Exception 
{
    private static final long serialVersionUID = 1L;
    
    public NegativeDamageException()
    {
        super("Negative damage.");
    }
}