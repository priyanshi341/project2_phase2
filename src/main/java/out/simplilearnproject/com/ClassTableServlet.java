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

@WebServlet("/classtable")
public class ClassTableServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		String classtype=req.getParameter("cl");
		ClassesTable ref=new ClassesTable(classtype);
		
		//open session
		SessionFactory factory=HibernateUtil.method();
		Session session=factory.openSession();
		
		Transaction txt=session.beginTransaction();
		session.save(ref);
		txt.commit();
		out.print("successfully added class data");
		session.close();
		factory.close();
	}

}
