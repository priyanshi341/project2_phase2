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

@WebServlet("/teacher")
public class TeacherTableServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String date=req.getParameter("date");
		String gender=req.getParameter("gender");
		String mobile=req.getParameter("mobile");
		String address=req.getParameter("address");
		LocalDate l=LocalDate.parse(date);
		
		TeacherTable ref=new TeacherTable(name,email,gender,l,address,mobile);
		//open session
				SessionFactory factory=HibernateUtil.method();
				Session session=factory.openSession();
				
				Transaction txt=session.beginTransaction();
				session.save(ref);
				txt.commit();
				out.print("successfully added Teacher data");
				session.close();
				factory.close();
	}

}
