/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.StudentDTO;
import java.util.List;

/**
 * @author Imandeep Singh Sidhu
 * @version 1.0
 */
public interface StudentDao {
    /**
     * This method gets every student from database
     * @return a List of students stored in the database
     */
    List<StudentDTO> getAllStudents();

    /**
     * This method gets a recipient according to the studentID
     * @param studentID 
     * @return a student
     */
    StudentDTO getStudentByStudentID(Integer studentID);

    /**
     * This method add a new student
     * @param student
     */
    void addStudent(StudentDTO student);

    /**
     * This method updates an existing student
     * @param student 
     */
    void updateStudent(StudentDTO student);

 
}
