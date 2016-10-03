import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import org.junit.Test;

import customTools.DBGradeUtil;
import customTools.DBUtil;
import model.Gdgrade;

public class gradetest {

	@Test
	public void test() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Gdgrade user = new Gdgrade();

		user.setAssignment("Assignment 2");
		user.setAssignmenttype("mid-term");
		user.setGrade("A+");
		user.setSubject("Science");
		
		DBGradeUtil.insert(user);
		
	}

}
