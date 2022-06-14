package sampleproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mail = request.getParameter("email");
		String pass = request.getParameter("password");
		try{
			connectDB dc = new connectDB();
			Connection con = dc.conect();
			String s = "select * from admins where email=? and password=?";
		PreparedStatement psmt = con.prepareStatement(s);
		psmt.setString(1, mail);
		psmt.setString(2, pass);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()){
			response.sendRedirect("dashboard.jsp");
		}
		else{
			response.sendRedirect("index.html");
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
