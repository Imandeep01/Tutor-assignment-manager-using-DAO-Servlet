
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
public class CourseDTO {
    private String courseCode;
    private String courseName;
    private String courseDescription;

    public CourseDTO(){
        
    }
    public CourseDTO(String courseCode,String courseName,String courseDescription){
        this.courseCode=courseCode;
        this.courseName=courseName;
        this.courseDescription=courseDescription;
           }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
}
