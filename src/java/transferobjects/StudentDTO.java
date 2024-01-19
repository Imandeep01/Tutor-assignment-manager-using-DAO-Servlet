/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package transferobjects;

/**
 *
 * @author Imandeep Singh Sidhu
 */
public class StudentDTO {
    private Integer studentID;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
   public StudentDTO(){
    
    } 


public StudentDTO (int studentID, String lastName, String firstName, String  email
                        , String phoneNumber){
        this.studentID =studentID;
        this.lastName=lastName;
        this.firstName=firstName;
        this.email=email;
        this.phoneNumber=phoneNumber;
        }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}