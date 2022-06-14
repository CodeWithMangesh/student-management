package sampleproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signUp
 */
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		connectDB dc = new connectDB();
		Connection con = dc.conect();
		String uname = request.getParameter("mail");
		String pass = request.getParameter("password");
		
		 
		
		try{
			//Dbconnect dc = new Dbconnect();
			//Connection con = dc.conect();
			String s = "insert into admins values(?,?)";
			PreparedStatement psmt = con.prepareStatement(s);
			psmt.setString(1, uname);
			psmt.setString(2, pass);
			int i = psmt.executeUpdate();
			if(i>0){
				response.sendRedirect("dashboard.jsp");
			}
			else{
				response.sendRedirect("sign-up.html");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
