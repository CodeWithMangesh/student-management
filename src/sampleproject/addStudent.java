package sampleproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addStudent
 */
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStudent() {
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
		String uname = request.getParameter("name");
		String branch = request.getParameter("branch");
		String status = request.getParameter("status");
		String bday = request.getParameter("bday");
		String company = request.getParameter("company");
		String cgpa = request.getParameter("cgpa");
		String mail = request.getParameter("email");
		String year = request.getParameter("year");
		String prn = request.getParameter("prn");
		 
		
		try{
			//Dbconnect dc = new Dbconnect();
			//Connection con = dc.conect();
			String s = "insert into studentinfo values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(s);
			psmt.setString(1, uname);
			psmt.setString(2, branch);
			psmt.setString(3, status);
			psmt.setString(4, bday);
			psmt.setString(5, company);
			psmt.setString(6, cgpa);
			psmt.setString(7, mail);
			psmt.setString(8, year);
			psmt.setString(9, prn);
			
			int i = psmt.executeUpdate();
			if(i>0){
				response.sendRedirect("dashboard.jsp");
			}
			else{
				response.sendRedirect("AddStudent.jsp");
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
