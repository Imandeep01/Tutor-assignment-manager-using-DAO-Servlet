/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.TutorCourseDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Imandeep Singh Sidhu
 *  @version 1.0
 */
public class TutorCourseDaoImpl implements TutorCourseDao{

    /**
     * This method defines the meaning of retrieving all tutorCourse
     * @return a List of all tutorCourses stored in the database
     */
    @Override
    public List<TutorCourseDTO> getAllTutorCourse() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<TutorCourseDTO> tutorCourses = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM tutorcourse");
            resultSet = preparedStatement.executeQuery();
            tutorCourses = new ArrayList<>();

            while(resultSet.next()){
                TutorCourseDTO tutorCourse = new TutorCourseDTO();
                tutorCourse.setTutor_TutorID(resultSet.getInt("tutor_TutorID"));
                tutorCourse.setCourse_CourseCode(resultSet.getString("course_CourseCode"));
                tutorCourses.add(tutorCourse);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{ if(resultSet != null){ resultSet.close(); } }
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(preparedStatement != null){ preparedStatement.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(connection != null){ connection.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
        }

        return tutorCourses;
    }

    /**
     * This method defines the meaning of retrieving a tutorCourse based on the Tutor_TutorID.
     * @param tutor_TutorID
     * @return a corresponding tutorCourse
     */
    @Override
    public TutorCourseDTO getTutorCourseByTutor_TutorID(Integer tutor_TutorID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        TutorCourseDTO tutorCourse = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM tutorcourse WHERE tutor_TutorID = ?");
            preparedStatement.setInt(1, tutor_TutorID.intValue());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                tutorCourse = new TutorCourseDTO();
                tutorCourse.setTutor_TutorID(resultSet.getInt("Tutor_TutorID"));
                tutorCourse.setCourse_CourseCode(resultSet.getString("Course_CourseCode"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{ if(resultSet != null){ resultSet.close(); } }
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(preparedStatement != null){ preparedStatement.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(connection != null){ connection.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
        }

        return tutorCourse;
    }

    /**
     * This method add a new tutorCourse
     * @param tutorCourse 
     */
    @Override
    public void addTutorCourse(TutorCourseDTO tutorCourse) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO tutorcourse (tutor_TutorID, course_CourseCode) VALUES (?,?)");
            preparedStatement.setInt(1,tutorCourse.getTutor_TutorID());
            preparedStatement.setString(2,tutorCourse.getCourse_CourseCode());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{ if(preparedStatement != null){ preparedStatement.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(connection != null){ connection.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }

    /**
     * This method updates an existing tutorCourse
     * @param tutorCourse the new tutorCourse information
     */
    @Override
    public void updateTutorCourse(TutorCourseDTO tutorCourse) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE tutorcourse SET Course_CourseCode = ?" +
                            "WHERE tutor_TutorID = ?");
            preparedStatement.setString(1, tutorCourse.getCourse_CourseCode());
            preparedStatement.setInt(1,tutorCourse.getTutor_TutorID());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{ if(preparedStatement != null){ preparedStatement.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(connection != null){ connection.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
}
