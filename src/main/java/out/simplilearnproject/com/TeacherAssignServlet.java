package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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

@WebServlet("/assign")
public class TeacherAssignServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter Object
				PrintWriter out=resp.getWriter();
			
				Long teacherid=Long.parseLong(req.getParameter("teacherid"));
				Long subjectid=Long.parseLong(req.getParameter("subjectid"));
				
				         //open session
						SessionFactory factory=HibernateUtil.method();
						Session session=factory.openSession();
						
						
						Transaction txt=session.beginTransaction();
						
						 SubjectTable newref1=session.get(SubjectTable.class, subjectid);
						 
						 TeacherTable newref=session.get(TeacherTable.class, teacherid);
					
		            
				        newref.getT().add(newref1);
		               newref1.setY(newref);
				       
				        
				        session.update(newref);
				        session.update(newref1);
						txt.commit();
						out.print("done successfully");
						session.close();
						factory.close();
	}

}
