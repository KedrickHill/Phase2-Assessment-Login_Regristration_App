package com.init;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.verify.Credentials;
import com.verify.VerificationUtil;

/**
 * Servlet implementation class RegistrationInit
 */
public class RegistrationInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationInit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			SessionFactory factory = VerificationUtil.getSessionFactory();
			Session session = factory.openSession();
			
			PrintWriter out = response.getWriter();
			
			Credentials user = new Credentials(request.getParameter("firstName"), 
					request.getParameter("lastName"), request.getParameter("email"), 
					request.getParameter("pswd"));
			
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			out.println("<html><body>");
			out.println("New user: " + user.getFirstName() + " " + user.getLastName() + "<br/>" 
						+ "Email: " + user.getEmail() + "<br/>" + "Has Been Registered.");
			out.println("<br/><a href='login.jsp'>Login</a><br/><a href='index.jsp'>Return to Main</a>");
			session.close();
			
		} catch (Exception e) {
			throw e;
		}
		
		
	}

}
