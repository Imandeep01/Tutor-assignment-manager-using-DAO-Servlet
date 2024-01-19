/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.CourseDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Imandeep Singh Sidhu
 * @version 1.0
 */

public class CourseDaoImpl implements CourseDao{

    /**
     * This method retrieving all Courses
     * @return a List of all course stored in the database
     */
    @Override
    public List<CourseDTO> getAllCourse() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CourseDTO> courses = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM course");
            resultSet = preparedStatement.executeQuery();
            courses = new ArrayList<>();

            while(resultSet.next()){
                CourseDTO course =new CourseDTO();
                course.setCourseCode(resultSet.getString("CourseCode"));
                course.setCourseName(resultSet.getString("CourseName"));
                course.setCourseDescription(resultSet.getString("CourseDescription"));
                
                courses.add(course);
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

        return courses;
    }

    /**
     * This method defines the meaning of retrieving a course based on the CourseCode.
     * @param courseCode
     */
    @Override
    public CourseDTO getCourseByCourseCode(String courseCode) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CourseDTO course = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE CourseCode = ?");
            preparedStatement.setString(1, courseCode);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                course = new CourseDTO();
                course.setCourseCode(resultSet.getString("CourseCode"));
                course.setCourseName(resultSet.getString("CourseName"));
                course.setCourseDescription(resultSet.getString("CourseDescription"));
                
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

        return course;
    }

    /**
     * This method add a new course
     * @param course
     */
    @Override
    public void addCourse(CourseDTO course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO course (CourseName,CourseDescription) VALUES (?,?)");
            preparedStatement.setString(1,course.getCourseName());
            preparedStatement.setString(2,course.getCourseDescription());
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
     * This method updates an existing course
     * @param course 
     */
    @Override
    public void updateCourse(CourseDTO course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE course SET CourseName = ?, CourseDescription = ?,  " +
                            "WHERE CourseCode = ?");
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setString(2, course.getCourseDescription());
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
