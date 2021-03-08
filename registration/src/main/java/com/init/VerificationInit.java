package com.init;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
			
			out.println("<html><body> Checking Credentails...");
		
			Optional<Credentials> user = creds.stream()
					.filter( c -> c.getEmail().equals(email))
					.findFirst();
			
			if (user.isPresent()) {
				Credentials c = user.get();
				if(!c.getPassword().equals(pswd)) {
					request.setAttribute("errorMessage", "Invalid Password");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				else {
					request.setAttribute("name", c.getFirstName() + c.getLastName());
					request.getRequestDispatcher("/Welcome").forward(request, response);

				}
//				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/welcome.jsp");
//				reqDispatcher.forward(request, response);
//				response.sendRedirect("/Welcome");
			}
			else {
				request.setAttribute("errorMessage", "Not a Valid Email");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
			
				
				out.println("</body></html>");
				session.close();

		} catch (Exception e) {
			throw e;
		}
	}

}
