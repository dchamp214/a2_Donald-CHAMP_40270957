public class MinimumWageException extends Exception{

    // Default constructor
    public MinimumWageException(){
        super("Wage provided is below minimum wage");
    }

    // Parameterized constructor
    public MinimumWageException(String errorMessage){
        super(errorMessage);
    }

    // Method tests wage if it is below the legal minimum throwing an exception if so
    public static void testWage(double wage) throws MinimumWageException {
        if(wage < 15.75){
            throw new MinimumWageException();
        }
    }
}
