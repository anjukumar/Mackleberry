package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Gdgrade;


public class DBGradeUtil {
	public static void insert(Gdgrade gdGrade) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(gdGrade); //inserting
			trans.commit(); //saving
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Gdgrade gdGrade) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(gdGrade); //updating
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	

	public static void delete(Gdgrade gdGrade) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(gdGrade));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static List<Gdgrade> gdGrade (){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select b from Gdgrade b ";

		List<Gdgrade> posts = null;
		try{
			TypedQuery<Gdgrade> query = em.createQuery(qString,Gdgrade.class);
			posts = query.getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return posts;
	}

	public static List<Gdgrade> postsofUser(long userid)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Gdgrade> userposts = null;
		String qString = "select b from Gdgrade b where b.USERID = = :userid";

		try{
			TypedQuery<Gdgrade> query = em.createQuery(qString,Gdgrade.class);
			query.setParameter("userid", userid);
			userposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return userposts;    
	}
	
	public static List<Gdgrade> postsofUser(String useremail)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Gdgrade> userposts = null;
		String qString = "select b from Gdgrade b "
				+ "where b.Gdgrade.useremail = :useremail";

		try{
			TypedQuery<Gdgrade> query = em.createQuery(qString,Gdgrade.class);
			query.setParameter("useremail", useremail);
			userposts = query.getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return userposts;    
	}


	
}
