import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBGradeUtil;
import customTools.DBUserUtil;
import model.Gdgrade;
import model.Gduser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class GLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GLoginServlet() {
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
		String useremail = request.getParameter("username");
		String password = request.getParameter("password");
		Gduser user=null;
		HttpSession session = request.getSession();
		
		List<Gdgrade> records =null;
		String nextURL = null ;
		
		if(DBUserUtil.isValidUser(useremail,password))
		{
			user = DBUserUtil.getUserByEmail(useremail);
			session.setAttribute("User", user);
			if(user.getUserrole().equalsIgnoreCase("t"))
			{
				System.out.println("teacherss home");
				nextURL="/TeacherHome.jsp";
				records = DBGradeUtil.gdGrade();
				session.setAttribute("records", records);
			}
			else if(user.getUserrole().equalsIgnoreCase("s"))
			{
				System.out.println("Students home");
				nextURL="/StudentHome.jsp";
				records = DBGradeUtil.gradebookUser(user.getId());
				session.setAttribute("records", records);
			}
		}
		else
		{
			response.getWriter().append("Invalid id/password try again.");
			nextURL="/LoginPage.jsp";
		}
		response.sendRedirect(request.getContextPath()+nextURL);
	}

}
