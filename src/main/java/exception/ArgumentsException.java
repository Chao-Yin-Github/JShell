package exception;

/**
 * @author yinchao
 * @date 2019/8/12 10:50
 */
public class ArgumentsException extends Exception{
    public ArgumentsException(){
        super();
    }
    public ArgumentsException(String message){
        super(message);
    }
    public ArgumentsException(String message, Throwable cause){
        super(message,cause);
    }
    protected ArgumentsException(Throwable cause){
        super(cause);
    }
}
