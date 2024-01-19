/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.CourseDTO;
import java.util.List;

/**
 * @author Imandeep Singh Sidhu
 */
public interface CourseDao {
    /**
     * This method retrieve all courses
     * @return a List of all courses stored in the database
     */
    List<CourseDTO> getAllCourse();

    /**
     * This method will retrieve a recipient based on the courseID
     * @param courseCode the unique course for the course
     * @return a corresponding course
     */
    CourseDTO getCourseByCourseCode(String courseCode);

    /**
     * This method add a new course
     * @param course 
     */
    void addCourse(CourseDTO course);

    /**
     * This method updates an existing course
     * @param course 
     */
    void updateCourse(CourseDTO course);
}
