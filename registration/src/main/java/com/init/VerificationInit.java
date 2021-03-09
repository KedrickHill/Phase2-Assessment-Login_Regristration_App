package com.init;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.verify.Credentials;
import com.verify.VerificationUtil;

/**
 * Servlet implementation class VerificationInit
 */
public class VerificationInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationInit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out = response .getWriter();
			out.println("<html><body>");
			
			SessionFactory factory = VerificationUtil.getSessionFactory();
			Session session = factory.openSession();
			
			out.println("This is the doGet method");
			
			session.close();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out = response.getWriter();
			
			String email = request.getParameter("email");
			String pswd = request.getParameter("pswd");
			
			SessionFactory factory = VerificationUtil.getSessionFactory();
			Session session = factory.openSession();
			
			List<Credentials> creds = session.createQuery("from com.verify.Credentials", Credentials.class).list();
			
			out.println("<html><body>");
		
			Optional<Credentials> user = creds.stream()
					.filter( c -> c.getEmail().equals(email))
					.findFirst();
			
			if (user.isPresent()) {
				Credentials c = user.get();
				if(!c.getPassword().equals(pswd)) {
					out.println("<p style='color: #FF0000'>Invalid Password</p>");
					out.println("<a href='login.jsp'>Retry Login</a>");
				}
				else {
					out.println("<h2>Welcome to the Home Page</h2>");
					out.println("<p>Glad you could make it " + c.getFirstName() + " " + c.getLastName() + "</p><br/>");
					out.println("<a href='/registration'>Sign Out</a>");

				}
//				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/welcome.jsp");
//				reqDispatcher.forward(request, response);
//				response.sendRedirect("/Welcome");
			}
			else {
				out.println("<p style='color: #FF0000'>Invalid Username</p>");
				out.println("<a href='login.jsp'>Retry Login</a>");
			}
			
			 	
				
				out.println("</body></html>");
				session.close();

		} catch (Exception e) {
			throw e;
		}
	}

}
