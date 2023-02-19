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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		String password=req.getParameter("pass");
		
		
		//writer object
				PrintWriter out=resp.getWriter();
				resp.setContentType("text/html");
				//open session
				SessionFactory factory=HibernateUtil.method();
				Session session=factory.openSession();
				List<AdminTable>l=session.createQuery("from AdminTable").list();
				for(AdminTable ref:l)
				{
					if(ref.getUid().equals(uid))
					{
						if(ref.getPassword().equals(password))
						{
							out.print("<form action='dashboard.html'>");
							out.print("<input type='submit' value='Go To Dashboard'>");
							out.print("</form>");
						}
						else
						{
							out.print("Password is wrong");
						}
					}
					else
					{
						out.print("wrong user id");
					}
				}
	}

}
