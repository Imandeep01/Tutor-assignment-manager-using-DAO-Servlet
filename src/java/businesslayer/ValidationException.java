/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package businesslayer;

/**
 * @author Imandeep Singh Sidhu
 * @version 1.0
 */
public class ValidationException extends Exception{
    
    
    public ValidationException(){
        super("Data not in valid format");
    }
    
    public ValidationException(String message){
        super(message);
    }

  
    public ValidationException(String message, Throwable throwable){
        super(message, throwable);
    }

   
    public ValidationException(Throwable throwable){
        super(throwable);
    }
}
