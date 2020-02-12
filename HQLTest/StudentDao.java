package HQLTest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

import beans.Student;

public class StudentDao {
      public static void main(String[] args) {
		//try {
			Configuration cfg = new Configuration().configure("resources/oracle.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			//String hql =" delete Student where id =1";
			String hql = "from Student";
			Query q = session.createQuery(hql);
		       Object o = q.uniqueResult();
		       Student st = (Student)o;
			System.out.println(st.getId()+"  "+st.getName());
			System.out.println("number of rows affected=");
			tx.commit();
//		}catch(HibernateException e) {
//			e.printStackTrace();
//		}
	}
}
