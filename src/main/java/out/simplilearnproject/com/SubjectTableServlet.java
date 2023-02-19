package out.simplilearnproject.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/subject")
public class SubjectTableServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter Object
				PrintWriter out=resp.getWriter();
			
				String subjectname=req.getParameter("subjectname");
				String subjectcode=req.getParameter("subjectcode");
				String subjectclass=req.getParameter("subjectclass");
				SubjectTable ref=new SubjectTable(subjectname,subjectcode,subjectclass);
				         //open session
						SessionFactory factory=HibernateUtil.method();
						Session session=factory.openSession();
						
						Transaction txt=session.beginTransaction();
						session.save(ref);
						txt.commit();
						out.print("successfully added Subject data");
						session.close();
						factory.close();
	}

}
