/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.GradeDTO;
import java.util.List;

/**
 * @author Imandeep Singh Sidhu
 * @version 1.0
 */
public interface GradesDao {
    /**
     * This method retrieve all grades
     * @return a List of all grades stored in the database
     */
    List<GradeDTO> getAllGrades();

    /**
     * This method gets recipient based on the gradeID
     * @param student_StudentID 
     * @return a corresponding grade
     */
    GradeDTO getGradeByStudent_StudentID(Integer student_StudentID);

    /**
     * This method adds  new grade
     * @param grade 
     */
    void addGrade(GradeDTO grade);

    /**
     * This method updates an existing grade
     * @param grade 
     */
    void updateGrade(GradeDTO grade);

    
}
