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
 * Servlet implementation class InsertStudent
 */
@WebServlet("/InsertStudent")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String name=request.getParameter("t1");
	      	int rollno =Integer.parseInt(request.getParameter("t2"));
	      	int pwd=Integer.parseInt(request.getParameter("t3"));
	      	int m1 =Integer.parseInt(request.getParameter("t4"));
	      	int m2 =Integer.parseInt(request.getParameter("t5"));
	      	int m3 =Integer.parseInt(request.getParameter("t6"));
	      	int m4 =Integer.parseInt(request.getParameter("t7"));
	      	int m5 =Integer.parseInt(request.getParameter("t8"));
	      	int m6=Integer.parseInt(request.getParameter("t9"));
	      	
	      	Class.forName("com.mysql.cj.jdbc.Driver");
	      	Connection con=DriverManager.getConnection("jdbc:mysql:"+"//localhost:3306/college","root","tiger");
	      	Statement st=con.createStatement();
	      	int i=st.executeUpdate("insert into student values('"+name+"',"+rollno+","+pwd+","+m1+","+m2+","+m3+","+m4+","+m5+","+m6+")");
	      	if(i>0)
	      		  out.println("Record inserted");
	      	  
	      	  else
	      		  out.println("Record not inserted");
		}
		catch(Exception e) {
			out.println("Exception raised");
		}
	}

}
