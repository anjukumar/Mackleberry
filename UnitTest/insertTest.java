import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import customTools.DBUserUtil;
import customTools.DBUtil;
import model.Gduser;

public class insertTest {

	@Test
	public void test() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
//		DBUserUtil dbUserUtil = new DBUserUtil();
		Gduser user = new Gduser();
		
		user.setUseremail("student3@domain.com");
		user.setPassword("student");
		user.setUsername("student3");
		user.setUserrole("s");
		
		DBUserUtil.insert(user);
	}

}
