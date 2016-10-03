

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBGradeUtil;
import model.Gdgrade;


@WebServlet("/AddNewServlet")
public class AddNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		long userid = Integer.parseInt(request.getParameter("userid"));
		String assignment = request.getParameter("assignment");
		String assignmenttype = request.getParameter("assignmenttype");
		String grade = request.getParameter("grade");
		String subject = request.getParameter("subject");
		List<Gdgrade> records =null;
		Gdgrade addnew = new Gdgrade();
		
		addnew.setUserid(userid);
		addnew.setAssignment(assignment);
		addnew.setAssignmenttype(assignmenttype);
		addnew.setGrade(grade);
		addnew.setSubject(subject);
		
		
		HttpSession session = request.getSession();
		records = DBGradeUtil.gdGrade();
		session.setAttribute("records", records);
		
		
//		System.out.println("Printing the table");
//		HttpSession session = request.getSession();
//		List<Gdgrade> records = DBGradeUtil.gdGrade();
//		session.setAttribute("records", records);

		System.out.println("Add new grade details");
		DBGradeUtil.insert(addnew);
		
		String nextURL = "/TeacherHome.jsp";
		response.sendRedirect(request.getContextPath()+nextURL);
		
	}

}
