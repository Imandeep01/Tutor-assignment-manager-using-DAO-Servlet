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
public class TutorDTO {
    private Integer tutorID;
    private String lastName;
    private String firstName;
    private String  email;
    private String phoneNumber;
    private String status;
    private Integer experienceID;
    
    
    /**
     *  Constructs an TutorDTO object.
    */

    public TutorDTO(){
    
    }
    
    /**
     * Constructs a TutorDTO object with the specified values for its attributes.
     *@param tutorID the ID of the tutor
     *@param lastName the last name of the tutor
     *@param firstName the first name of the tutor
     *@param email the email address of the tutor
     *@param phoneNumber the phone number of the tutor
     *@param status the status of the tutor
     *@param experienceID the ID of the experience of the tutor
     */
    
    public TutorDTO (int tutorID, String lastName, String firstName, String  email
                        , String phoneNumber, String status,int experienceID){
        this.tutorID =tutorID;
        this.lastName=lastName;
        this.firstName=firstName;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.status= status;
        this.experienceID=experienceID;
    }
/**
 * Returns the ID of the tutor.
 * @return the ID of the tutor
 */
    public Integer getTutorID() {
        return tutorID;
    }
/**
 * Sets the ID of the tutor.
 * @param tutorID
 */
    public void setTutorID(Integer tutorID) {
        this.tutorID = tutorID;
    }
/**
 * Returns the Lastname of tutor.
 * @return lastName
 */
    public String getLastName() {
        return lastName;
    }
/**
 * Sets the Lastname of the tutor.
 * @param lastName
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * Returns the firstname of the tutor.
 * @return firstName
 */
    public String getFirstName() {
        return firstName;
    }
/**
 * Sets the FirstName of the tutor.
 * @param firstName
 */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
}

