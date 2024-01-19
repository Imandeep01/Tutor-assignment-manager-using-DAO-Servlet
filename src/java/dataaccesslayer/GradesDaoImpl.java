/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.GradeDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author Imandeep Singh Sidhu
 */
public class GradesDaoImpl implements GradesDao{

    /**
     * This method defines the meaning of retrieving all grades
     * @return a List of all grades stored in the database
     */
    @Override
    public List<GradeDTO> getAllGrades() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GradeDTO> grades = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM grade");
            resultSet = preparedStatement.executeQuery();
            grades = new ArrayList<>();

            while(resultSet.next()){
                GradeDTO grade = new GradeDTO();
                grade.setStudent_StudentID(resultSet.getInt("student_StudentID"));
                grade.setCourse_CourseCode(resultSet.getString("course_CourseCode"));
                grade.setGradeCode(resultSet.getString("GradeCode"));
                grades.add(grade);
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

        return grades;
    }

    /**
     * This method gets a grade based on the Student_StudentID.
     * @param student_StudentID 
     * @return  grade
     */
    @Override
    public GradeDTO getGradeByStudent_StudentID(Integer student_StudentID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        GradeDTO grade = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM grade WHERE student_StudentID = ?");
            preparedStatement.setInt(1, student_StudentID.intValue());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                grade = new GradeDTO();
                grade.setStudent_StudentID(resultSet.getInt("student_StudentID"));
                grade.setCourse_CourseCode(resultSet.getString("course_CourseCode"));
                grade.setGradeCode(resultSet.getString("GradeCode"));
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

        return grade;
    }

    /**
     * This method add a new grade
     * @param grade 
     */
    @Override
    public void addGrade(GradeDTO grade) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO grade (course_CourseCode, GradeCode) VALUES (?,?)");
            preparedStatement.setString(1,grade.getCourse_CourseCode());
            preparedStatement.setString(2,grade.getGradeCode());
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
     * This method updates an existing grade
     * @param grade 
     */
    @Override
    public void updateGrade(GradeDTO grade) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE grades SET course_CourseCode = ?, GradeCode = ?, " +
                            " WHERE student_StudentID = ?");
            preparedStatement.setString(1, grade.getCourse_CourseCode());
            preparedStatement.setString(2, grade.getGradeCode());
            preparedStatement.setInt(3,grade.getStudent_StudentID());
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
