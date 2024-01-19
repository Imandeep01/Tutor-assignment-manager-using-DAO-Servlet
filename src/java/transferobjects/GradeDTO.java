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
public class GradeDTO {
    private Integer student_StudentID;
    private String course_CourseCode;
    private String gradeCode;
    public GradeDTO() {
        
    }

    public GradeDTO(Integer student_StudentID, String course_CourseCode, String gradeCode) {
        this.student_StudentID = student_StudentID;
        this.course_CourseCode = course_CourseCode;
        this.gradeCode = gradeCode;
    }

    public Integer getStudent_StudentID() {
        return student_StudentID;
    }

    public void setStudent_StudentID(Integer student_StudentID) {
        this.student_StudentID = student_StudentID;
    }

    public String getCourse_CourseCode() {
        return course_CourseCode;
    }

    public void setCourse_CourseCode(String course_CourseCode) {
        this.course_CourseCode = course_CourseCode;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }
   
}
