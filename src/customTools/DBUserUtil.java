package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Gduser;
/**
 * @author djw
 * DbUser class contains helper methods for working with Bhusers
 *
 */
public class DBUserUtil {
	/**
	 * Gets a Bhuser from the database
	 * @param userID - primary key from database. Must be type long
	 * @return Bhuser
	 */
	public static Gduser getUser(long userID)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Gduser user = em.find(Gduser.class, userID);
		return user; 
	}

	public static void insert(Gduser gdUser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(gdUser); 
			trans.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	/**
	 * Updates the data in a Gduser
	 * Pass the method a Gduser with all the values set to your liking and 
	 * this method will update the database with these values.
	 * This method doesn't actually return anything but the good feeling
	 * that your update has been completed. If it can't be completed then 
	 * it won't tell you. Sounds like something needs to be added in the future. Hmmm.
	 * @param bhUser
	 */

	public static void update(Gduser gdUser) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(gdUser); //updating
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	/**
	 * Removes a Gduser from the database.
	 * Not sure why you'd want to delete a Gduser from the database but this
	 * method will do it for you. This method does not explicitly remove the user's
	 * posts but most likely you've set up the database with cascading deletes which
	 * will take care of that.Gives no feedback.
	 * @param bhUser that you never want to see again
	 */

	public static void delete(Gduser gdUser) {
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(gdUser));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	/**
	 * Gets a user given their email address.
	 * You've got the email when they log in but you really need the 
	 * user and all its related information This method will find the user
	 * matching that email. The database should ensure that you can't have two users
	 * with the same email. Otherwise there's no telling what you'd get.
	 * @param email
	 * @return Gduser with that unique email address
	 */
	
	public static Gduser getUserByEmail(String email)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Gduser u "
				+ "where u.useremail = :useremail";
		TypedQuery<Gduser> q = em.createQuery(qString, Gduser.class);
		q.setParameter("useremail", email);
		Gduser user = null;
		try {
			user = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return user;
	}

	/**
	 * Is this user valid? This method has the answer for you.
	 * Checks the database and counts the number of users with this
	 * username and password. If it returns 0 then either the username
	 * or password don't exist in the database. If it returns 1 then you have found 
	 * the user with that username and password. If it returns >1 then you need to 
	 * fix your database first.
	 * @param user of type Gduser
	 * @return true or false indicating the user exists or doesn't
	 */
	public static boolean isValidUser(String email, String password)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select count(g.id) from Gduser g "
				+ "where g.useremail = :useremail and g.password = :userpass";
		TypedQuery<Long> q = em.createQuery(qString,Long.class);
		boolean result = false;
		q.setParameter("useremail", email);
		q.setParameter("userpass", password);

		try{
			long userId = q.getSingleResult();
			if (userId > 0)
			{
				result = true;
			}
		}catch (Exception e){

			result = false;
		}
		finally{
			em.close(); 
		} 
		return result;

	}
}
