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


@WebServlet("/click3")
public class AllClassDisplayServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//PrintWriter Object
	PrintWriter out=resp.getWriter();

resp.setContentType("text/html");
	         //open session
			SessionFactory factory=HibernateUtil.method();
			Session session=factory.openSession();
			
			Query query=session.createQuery("from ClassesTable");
			List<ClassesTable> list=query.list();
			out.print("<h3>Classes Data:</h3><br>");
			for(ClassesTable ref:list)
			{
				out.print("<b>Class Id:</b>"+ref.getClassid()+"<br>");
				out.print("<b>Class Name:</b>"+ref.getClassname()+"<br><br>");
			
				
				
			}
		
}
}
