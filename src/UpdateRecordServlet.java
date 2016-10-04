

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBGradeUtil;
import model.Gdgrade;

/**
 * Servlet implementation class UpdateGradeServlet
 */
@WebServlet("/UpdateRecordServlet")
public class UpdateRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		long tempid =Long.parseLong(request.getParameter("userid"));
//		System.out.print("The user id that needs to be edited is : "+tempid);
//		
//		model.Gduser gettingUser = customTools.DBUserUtil.getUserByUserID(tempid);		
//		System.out.print("The user is found using User Id " +gettingUser.getId());
//		System.out.print("The user is found using User Id " +gettingUser.getUsername());
	
		long updateuserid = Long.parseLong(request.getParameter("userid"));
		String updateassignment = request.getParameter("assignment");
		String updateassignmenttype = request.getParameter("assignmenttype");
		String updategrade = request.getParameter("grade");
				
		HttpSession session = request.getSession();
		Gdgrade updates = new Gdgrade();
		
		
		updates.setUserid(updateuserid);
		updates.setAssignment(updateassignment);
		updates.setAssignmenttype(updateassignmenttype);
		updates.setGrade(updategrade);
		
		
		System.out.println("Updating details");
		DBGradeUtil.update(updates);
		
		
		String nextURL="/TeacherHome.jsp";
		response.sendRedirect(request.getContextPath()+nextURL);
		System.out.println("Update done");
		}

}
