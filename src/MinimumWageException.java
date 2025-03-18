public class MinimumWageException extends Exception{

    public MinimumWageException(){
        super("Wage provided is below minimum wage");
    }

    public MinimumWageException(String errorMessage){
        super(errorMessage);
    }
}
