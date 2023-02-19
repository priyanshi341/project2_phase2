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


@WebServlet("/click2")
public class AllSubjectDisplayServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//PrintWriter Object
	PrintWriter out=resp.getWriter();

resp.setContentType("text/html");
	         //open session
			SessionFactory factory=HibernateUtil.method();
			Session session=factory.openSession();
			
			Query query=session.createQuery("from SubjectTable");
			List<SubjectTable> list=query.list();
			out.print("<h3>Subjects Data:</h3><br>");
			for(SubjectTable ref:list)
			{
				out.print("<b>Subject Id:</b>"+ref.getSubjectid()+"<br>");
				out.print("<b>Subject Name:</b>"+ref.getSubjectname()+"<br>");
				out.print("<b>Subject Code:</b>"+ref.getSubjectcode()+"<br>");
				out.print("<b>Subject Class:</b>"+ref.getSubjectclass()+"<br><br>");
				
				
			}
		
}
}
