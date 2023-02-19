package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/assign2")
public class StudentAssignServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter Object
				PrintWriter out=resp.getWriter();
			
				Long studentid=Long.parseLong(req.getParameter("studentid"));
				Long classid=Long.parseLong(req.getParameter("classid"));
				
				         //open session
						SessionFactory factory=HibernateUtil.method();
						Session session=factory.openSession();
						
						
						Transaction txt=session.beginTransaction();
						
						ClassesTable newref=session.get(ClassesTable.class, classid);
						
						StudentTable newref1=session.get(StudentTable.class, studentid);
						 
					newref1.setClasstable(newref);
				       
				        session.update(newref1);
						txt.commit();
						out.print("done successfully");
						session.close();
						factory.close();
	}
}
