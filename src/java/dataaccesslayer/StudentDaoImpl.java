/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.StudentDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *@author Imandeep Singh Sidhu
 * @version 1.0
 */
public class StudentDaoImpl implements StudentDao{

    /**
     * This method defines the meaning of retrieving all students
     * @return List of all students stored in the database
     */
    @Override
    public List<StudentDTO> getAllStudents() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StudentDTO> students = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM student");
            resultSet = preparedStatement.executeQuery();
            students = new ArrayList<>();

            while(resultSet.next()){
                StudentDTO student = new StudentDTO();
                student.setStudentID(resultSet.getInt("StudentID"));
                student.setLastName(resultSet.getString("LastName"));
                student.setFirstName(resultSet.getString("FirstName"));
                student.setEmail(resultSet.getString("Email"));
                student.setPhoneNumber(resultSet.getString("PhoneNumber"));
                students.add(student);
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

        return students;
    }

    /**
     * This method defines the meaning of retrieving a student based on the StudentID.
     * @param studentID the unique StudentID for the student
     * @return a corresponding student
     */
    @Override
    public StudentDTO getStudentByStudentID(Integer studentID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StudentDTO student = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection(); 
            preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE StudentID = ?");
            preparedStatement.setInt(1, studentID.intValue());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                student = new StudentDTO();
                student.setStudentID(resultSet.getInt("StudentID"));
                student.setLastName(resultSet.getString("LastName"));
                student.setFirstName(resultSet.getString("FirstName"));
                student.setEmail(resultSet.getString("Email"));
                student.setPhoneNumber(resultSet.getString("PhoneNumber"));
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

        return student;
    }

    /**
     * This method add a new student
     * @param student the student entity object that will be added
     */
    @Override
    public void addStudent(StudentDTO student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO student (LastName, FirstName, Email, PhoneNumber) VALUES (?,?,?,?)");
            preparedStatement.setString(1,student.getLastName());
            preparedStatement.setString(2,student.getFirstName());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setString(4,student.getPhoneNumber());
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
     * This method updates an existing student
     * @param student the new student information
     */
    @Override
    public void updateStudent(StudentDTO student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE student SET LastName = ?, FirstName = ?, Email = ?, " +
                            "PhoneNumber = ? WHERE StudentID = ?");
            preparedStatement.setString(1, student.getLastName());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getFirstName());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setInt(5,student.getStudentID());
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
