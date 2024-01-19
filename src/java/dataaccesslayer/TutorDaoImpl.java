/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
package dataaccesslayer;

import transferobjects.TutorDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author Imandeep Singh SIdhu
 */
public class TutorDaoImpl implements TutorDao{

    /**
     * This method defines the meaning of retrieving all tutors
     * @return a List of all tutors stored in the database
     */
    @Override
    public List<TutorDTO> getAllTutors() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<TutorDTO> tutors = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM tutor");
            resultSet = preparedStatement.executeQuery();
            tutors = new ArrayList<>();

            while(resultSet.next()){
                TutorDTO tutor = new TutorDTO();
                tutor.setTutorID(resultSet.getInt("TutorID"));
                tutor.setLastName(resultSet.getString("LastName"));
                tutor.setFirstName(resultSet.getString("FirstName"));
            
                tutors.add(tutor);
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

        return tutors;
    }

    /**
     * This method defines the meaning of retrieving a tutor based on the TutorID.
     * @param tutorID 
     * @return a corresponding tutor
     */
    @Override
    public TutorDTO getTutorsByTutorId(Integer tutorID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        TutorDTO tutor = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM tutor WHERE TutorID = ?");
            preparedStatement.setInt(1, tutorID.intValue());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                tutor = new TutorDTO();
                tutor.setTutorID(resultSet.getInt("TutorID"));
                tutor.setLastName(resultSet.getString("LastName"));
                tutor.setFirstName(resultSet.getString("FirstName"));
               
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

        return tutor;
    }

    /**
     * This method add a new tutor
     * @param tutor 
     */
    @Override
    public void addTutor(TutorDTO tutor) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO tutor (LastName, FirstName, Email, PhoneNumber, Status) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,tutor.getLastName());
            preparedStatement.setString(2,tutor.getFirstName());
           
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
     * This method updates an existing tutor
     * @param tutor
     */
    @Override
    public void updateTutor(TutorDTO tutor) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            DataSource dataSource = new DataSource();
            connection = dataSource.createConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE tutor SET LastName = ?, FirstName = ?, Email = ?,PhoneNumber = ? " +
                            "Status = ? WHERE TutorID = ?");
            preparedStatement.setString(1, tutor.getLastName());
            preparedStatement.setString(2, tutor.getFirstName());
           
            preparedStatement.setInt(6,tutor.getTutorID());
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
