/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.TutorDTO;
import java.util.List;

/**
 * @author Imandeep Singh SIdhu
 * @version 1.0
 */
public interface TutorDao {
    /**
     * This method retrieve all tutors
     * @return a List of all tutors stored in the database
     */
    List<TutorDTO> getAllTutors();

    /**
     * This method retrieve a recipient based on the tutorID
     * @param tutorID 
     * @return a corresponding tutor
     */
    TutorDTO getTutorsByTutorId(Integer tutorID);

    /**
     * This method add a new tutor
     * @param tutor 
     */
    void addTutor(TutorDTO tutor);

    /**
     * This method updates an existing tutor
     * @param tutor 
     */
    void updateTutor(TutorDTO tutor); 
}
