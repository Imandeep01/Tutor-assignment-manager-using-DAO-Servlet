/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.TutorCourseDTO;
import java.util.List;

/**
 * @author Imandeep Singh Sidhu
 * @version 1.0
 */
public interface TutorCourseDao {
    /**
     * This method retrieve all TutorCourse
     */
    List<TutorCourseDTO> getAllTutorCourse();

    /**
     * This method retrieve a recipient based on the TutorID
     * @param tutor_TutorID 
     */
    TutorCourseDTO getTutorCourseByTutor_TutorID(Integer tutor_TutorID);

    /**
     * This method add a new TutorCourse
     * @param tutor_tutor 
     */
    void addTutorCourse(TutorCourseDTO tutor_tutor);

    /**
     * This method updates an existing TutorCourse
     * @param tutor_tutor 
     */
    void updateTutorCourse(TutorCourseDTO tutor_tutor);

 
}
