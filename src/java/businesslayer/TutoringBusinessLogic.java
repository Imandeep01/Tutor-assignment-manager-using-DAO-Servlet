/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package businesslayer;
import dataaccesslayer.StudentDaoImpl;
import transferobjects.StudentDTO;
import dataaccesslayer.GradesDaoImpl;
import transferobjects.GradeDTO;
import dataaccesslayer.TutorCourseDaoImpl;
import transferobjects.TutorCourseDTO;
import dataaccesslayer.TutorDaoImpl;
import java.util.ArrayList;
import transferobjects.TutorDTO;
import java.util.List;
import dataaccesslayer.GradesDao;
import dataaccesslayer.StudentDao;
import dataaccesslayer.TutorCourseDao;
import dataaccesslayer.TutorDao;
/**
 * @author Imandeep Singh Sidhu
 * @version 1.0
 */

public class TutoringBusinessLogic {
    private TutorDao tutorDAO =new TutorDaoImpl();
    private StudentDao studentDAO =new StudentDaoImpl();
    private GradesDao gradeDAO=new GradesDaoImpl();
    private TutorCourseDao tutorCourseDAO = new TutorCourseDaoImpl();
   
    
    public int addTutor(String firstName,String lastName,String course){
    List<TutorDTO> tutors = tutorDAO.getAllTutors();
    TutorDTO tutor = null; 
    
        for (int i=0;i<tutors.size();i++ ){
            TutorDTO tutorCheck = tutors.get(i);
            if ((tutorCheck.getFirstName().equals(firstName))&&(tutorCheck.getLastName().equals(lastName)))
                tutor = tutorCheck;
        }

        if (tutor == null)
            return 4;
    
   List<StudentDTO> students = studentDAO.getAllStudents();
   StudentDTO student =null; 
        for (int i=0;i<students.size();i++){
            StudentDTO studentCheck =students.get(i);
            if ((studentCheck.getFirstName().equals(firstName))&&(studentCheck.getLastName().equals(lastName)))
                student=studentCheck;
        }
   if (student == null)
   return 3;
      
   /**
    * Check studentID 
    */ 
   List<GradeDTO> grades = gradeDAO.getAllGrades();
   GradeDTO grade =null;
        for (int i=0;i<grades.size();i++){
            GradeDTO gradeCheck =grades.get(i);
            if ((gradeCheck.getStudent_StudentID().intValue() == student.getStudentID().intValue())&& gradeCheck.getCourse_CourseCode().equals(course))
                grade = gradeCheck;
        }
   if (grade == null)
       return 2;
   /**
    * Validation for grade 
    */
   if ((grade.getGradeCode().equals("A"))||(grade.getGradeCode().equals("A-"))||(grade.getGradeCode().equals("A-"))){
           TutorCourseDTO tutorCourse = new TutorCourseDTO();
           tutorCourse.setCourse_CourseCode(course);
           tutorCourse.setTutor_TutorID(tutor.getTutorID());
           tutorCourseDAO.addTutorCourse(tutorCourse);
           return 1;
    }
   else
   return 2;
    }
    
    /**
     * if conditions are valid, return result
     */
    public List<TutorDTO> getTutorFromCourse(String course){
        List<TutorCourseDTO> courses = tutorCourseDAO.getAllTutorCourse();
        List<Integer> tutorIDList = new ArrayList<>();
        for (TutorCourseDTO element : courses){
            if (element.getCourse_CourseCode().equals(course))
                tutorIDList.add(element.getTutor_TutorID());
        }
        
        List<TutorDTO> result = new ArrayList<>();
        for (Integer id : tutorIDList){
            result.add(tutorDAO.getTutorsByTutorId(id));
        }
        
        return result;
    }
   
}
