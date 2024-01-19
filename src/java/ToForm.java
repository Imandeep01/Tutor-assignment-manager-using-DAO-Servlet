/**
Student Name:Imandeep Singh Sidhu
Student Number:041059799
Course & Section #: 22S_CST8288_012
Declaration:This is my own original work and is free from�Plagiarism.
*/
import businesslayer.TutoringBusinessLogic;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.TutorDTO;

/**
 * @author Imandeep SIngh Sidhu
 * @version 1.0
 */
@WebServlet(name = "ToForm", urlPatterns = {"/ToForm"})
public class ToForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userID = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String course = request.getParameter("courseCode");
        
        TutorDTO tutor = new TutorDTO();
        tutor.setFirstName(firstName);
        tutor.setLastName(lastName);
        
        
        Properties props = new Properties();

        InputStream in = getClass().getClassLoader().getResourceAsStream("database.properties");
        props.load(in);
        String loginID = props.getProperty("jdbc.username");
        String loginPass = props.getProperty("jdbc.password");
        
        boolean isIDCorrect = userID.equals(loginID) ;
        boolean isPassCorrect = password.equals(loginPass);
        
        TutoringBusinessLogic businessLogic = new TutoringBusinessLogic();
        
        
        if ((isIDCorrect)&&(isPassCorrect)){
            int i = businessLogic.addTutor(firstName,lastName,course);
            
            switch(i){
                case 1:{
                    try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>A Sample Form</title>");  
                    out.println("<style> table, th, td"+
                            "{border:1px solid black;}</style>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Register Course</h1>");
                    out.println("Table of Tutors assigned to " + course);
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<th>Tutor ID</th>");
                    out.println("<th>Last Name</th>");
                    out.println("<th>First Name</th>");
                    out.println("</tr>");
                    
                    List<TutorDTO> tutors = businessLogic.getTutorFromCourse(course);
                    for (TutorDTO element : tutors){
                        out.println("<tr>");
                        out.println("<td>" + element.getTutorID() + "</td>");
                        out.println("<td>" + element.getLastName() + "</td>");
                        out.println("<td>" + element.getFirstName() + "</td>");
                        out.println("</tr>");
                    }        
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                    }
                    break;
                }
                case 2:{
                    try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>A Sample Form</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Register Course</h1>");
                    out.println("<ul>");
                    out.println("<li><p><b>First name:</b>" + firstName + "</p></li>");
                    out.println("<li><p><b>Last name:</b>" + lastName + "</p></li>");
                    out.println("</ul>");
                    out.println("The person does not qualify to tutor this course as the obtained grade is not sufficient");
                    out.println("</body>");
                    out.println("</html>");
                    }
                    break;
                }
                case 3:{
                    try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>A Sample Form</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Register Course</h1>");
                    out.println("<ul>");
                    out.println("<li><p><b>First name:</b>" + firstName + "</p></li>");
                    out.println("<li><p><b>Last name:</b>" + lastName + "</p></li>");
                    out.println("</ul>");
                    out.println("This person is not in this course");
                    out.println("</body>");
                    out.println("</html>");
                    }
                    break;
                }
                
                case 4:{
                    try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>A Sample Form</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Register Course</h1>");
                    out.println("<ul>");
                    out.println("<li><p><b>First name:</b>" + firstName + "</p></li>");
                    out.println("<li><p><b>Last name:</b>" + lastName + "</p></li>");
                    out.println("</ul>");
                    out.println("The person is not registered as a tutor");
                    out.println("</body>");
                    out.println("</html>");
                    }
                    break;
                }
            }
        }
        
        else{
            try (PrintWriter out = response.getWriter()) {            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>A Sample Form</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Check your UserID and Password and Try Again</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
