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

@WebServlet("/student")
public class StudentTableServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter Object
		PrintWriter out=resp.getWriter();
	
		String name=req.getParameter("name");
		String fathername=req.getParameter("fathername");
		String date1=req.getParameter("dateofbirth");
		String date2=req.getParameter("dateofjoining");
		String address=req.getParameter("address");
		LocalDate l=LocalDate.parse(date1);
		LocalDate l1=LocalDate.parse(date2);
		StudentTable ref=new StudentTable(name,fathername,l,l1,address);
		
		         //open session
				SessionFactory factory=HibernateUtil.method();
				Session session=factory.openSession();
				
				Transaction txt=session.beginTransaction();
				session.save(ref);
				txt.commit();
				out.print("successfully added Student data");
				session.close();
				factory.close();
	}

}
