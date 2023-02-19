package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

@WebServlet("/click4")
public class AllStudentDisplayServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//PrintWriter Object
	PrintWriter out=resp.getWriter();

resp.setContentType("text/html");
	         //open session
			SessionFactory factory=HibernateUtil.method();
			Session session=factory.openSession();
			
			Query query=session.createQuery("from StudentTable");
			List<StudentTable>list=query.list();
			out.print("<h3>Students Data:</h3><br>");
			for(StudentTable ref:list)
			{
				out.print("<b>Student Name:</b>"+ref.getStudentid()+"<br>");
				out.print("<b>Student Name: </b>"+ref.getName()+"<br>");
				out.print("<b>Father Name: </b>"+ref.getFathername()+"<br>");
				out.print("<b>Date Of birth: </b>"+ref.getDateofbirth()+"<br>");
				out.print("<b>Date Of joining: </b>"+ref.getDateofjoining()+"<br>");
				out.print("<b>Address: </b>"+ref.getAddress()+"<br>");
				out.print("<h5>Class To Which This Student Is Assigned Is:</h5>"+ref.getClasstable().getClassname()+"<br><br>");
				/*ClassesTable refrence=ref.getClasstable();
				out.print(refrence.getClassname());*/
			}
			
		
}
}
