package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.println("driver loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql:"+"//localhost:3306/college","root","tiger");
			out.println("connection established");
			
			
			int rollno=Integer.parseInt(request.getParameter("t1"));
			
			int subno=Integer.parseInt(request.getParameter("t2"));
			
			int newMarks=Integer.parseInt(request.getParameter("t3"));
			
			Statement s=con.createStatement();
			String query="update student set m"+subno+"="+newMarks+" where rollno="+rollno;
			
			s.executeUpdate(query);
			
			
			out.println("marks updated");
			
		}
		catch(Exception e) {
			out.println("Error");
		}
	}

}
