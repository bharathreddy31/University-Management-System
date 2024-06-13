package p1;
import Grade.printGrade;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RetriveStudent
 */
@WebServlet("/RetriveStudent")
public class RetriveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetriveStudent() {
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
	    	int rollno=Integer.parseInt(request.getParameter("t1"));
			int pwd=Integer.parseInt(request.getParameter("t2"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:"+"//localhost:3306/college","root","tiger");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select *from student where "+"rollno="+rollno+" And password="+pwd+"");
			response.setContentType("text/html");
			while(rs.next())
			{
				
				
				
				
				 
				out.println("<html><body align='center' bgcolor='yellow'>");
				out.println("Student ID is"+rs.getInt(2)+"<br>");
				out.println("Student Name is"+rs.getString(1));
				out.println("<table border='1' align='center'>");
				out.println("<tr><th>subjectname</th><th>Obtained marks</th><th>");
				out.println("<tr>");
				out.println("<td>"+"c language"+"</td>");
				out.println("<td>"+rs.getInt(4)+"</td>");
				out.println("<td>"+printGrade.gradePrint(rs.getInt(4))+"</td>");
				out.println("<tr><tr>");
				out.println("<td>"+"java language"+"</td>");
				out.println("<td>"+rs.getInt(5)+"</td>");
				out.println("<td>"+printGrade.gradePrint(rs.getInt(5))+"</td>");
				out.println("<tr>");
				out.println("<td>"+"python language"+"</td>");
				out.println("<td>"+rs.getInt(6)+"</td>");
				out.println("<td>"+printGrade.gradePrint(rs.getInt(6))+"</td>");
				out.println("<tr>");
				out.println("<td>"+"dbms language"+"</td>");
				out.println("<td>"+rs.getInt(7)+"</td>");
				out.println("<td>"+printGrade.gradePrint(rs.getInt(7))+"</td>");
				out.println("<tr>");
				out.println("<td>"+"c++ language"+"</td>");
				out.println("<td>"+rs.getInt(8)+"</td>");
				out.println("<td>"+printGrade.gradePrint(rs.getInt(8))+"</td>");
				out.println("<tr>");
				out.println("<td>"+"javascipt language"+"</td>");
				out.println("<td>"+rs.getInt(9)+"</td>");
				out.println("<td>"+printGrade.gradePrint(rs.getInt(9))+"</td>");
				out.println("<tr>");
				out.println("</table>");
				if(printGrade.gradePrint(rs.getInt(4))=="Fail" || printGrade.gradePrint(rs.getInt(5))=="Fail" || printGrade.gradePrint(rs.getInt(6))=="Fail" || printGrade.gradePrint(rs.getInt(7))=="Fail" || printGrade.gradePrint(rs.getInt(8))=="Fail" || printGrade.gradePrint(rs.getInt(9))=="Fail" ) {
					out.println("<h1>Your final result is Fail</h1>");
				}
				else {
					int totalMarks=rs.getInt(4)+rs.getInt(5)+rs.getInt(6)+rs.getInt(7)+rs.getInt(8)+rs.getInt(9);
					int avg=totalMarks/6;
					String grade=printGrade.gradePrint(avg);
					
					out.println("<h1>Your final result is Pass</h1>");
					out.println("<h1>Your Overall grade is "+grade+"</h1>");
				}
			    
				out.println("</body></html>");
				
			}
	    }
	    catch(Exception e) {
	    	out.println("Error");
	    }
		
	}

}
