/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package transferobjects;

/**
 * @author Imandeep Singh Sidhu
 */
public class TutorCourseDTO {
    private Integer tutor_TutorID;
    private String course_CourseCode;
    public TutorCourseDTO(){
        
    }
    public TutorCourseDTO(int tutor_TutorID, String course_CourseCode){
        this.tutor_TutorID=tutor_TutorID;
        this.course_CourseCode=course_CourseCode;
   }

    public Integer getTutor_TutorID() {
        return tutor_TutorID;
    }

    public void setTutor_TutorID(Integer tutor_TutorID) {
        this.tutor_TutorID = tutor_TutorID;
    }

    public String getCourse_CourseCode() {
        return course_CourseCode;
    }

    public void setCourse_CourseCode(String course_CourseCode) {
        this.course_CourseCode = course_CourseCode;
    }
    
}
