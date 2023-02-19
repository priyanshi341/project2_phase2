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
import org.hibernate.Transaction;

import org.hibernate.query.Query;

@WebServlet("/click1")
public class TeacherDisplayClass extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//PrintWriter Object
	PrintWriter out=resp.getWriter();

resp.setContentType("text/html");
	         //open session
			SessionFactory factory=HibernateUtil.method();
			Session session=factory.openSession();
			
			Query query=session.createQuery("from TeacherTable");
			List<TeacherTable> list=query.list();
			out.print("<h3>Teachers Data:</h3><br>");
			for(TeacherTable ref:list)
			{
				out.print("<b>Teacher Id: </b>"+ref.getTeacherid()+"<br>");
				out.print("<b>Teacher Name: </b>"+ref.getName()+"<br>");
				out.print("<b>Teacher Email: </b>"+ref.getEmail()+"<br>");
				out.print("<b>Teacher Gender: </b>"+ref.getGender()+"<br>");
				out.print("<b>Teacher Mobile No.: </b>"+ref.getMobile()+"<br>");
				out.print("<b>Teacher Date Of Birth: </b>"+ref.getDateofbirth()+"<br>");
				out.print("<b>Teacher Address: </b>"+ref.getAddress()+"<br><br>");
				out.print("<h3>Subjects which are assigned to this teacher are:</h3><br>");
				List<SubjectTable> s=ref.getT();
				for(SubjectTable ref1:s)
				{
					out.print("<b>Subject Id:</b>"+ref1.getSubjectid()+"<br>");
					out.print("<b>Subject Name:</b>"+ref1.getSubjectname()+"<br>");
					out.print("<b>Subject Code:</b>"+ref1.getSubjectcode()+"<br>");
					out.print("<b>Subject Class:</b>"+ref1.getSubjectclass()+"<br><br>");
				}
			}
		
}
}
