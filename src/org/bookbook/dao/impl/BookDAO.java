package org.bookbook.dao.impl;

import java.util.List;



import org.bookbook.dao.IBookDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BookDAO extends HibernateDaoSupport implements IBookDAO {

	public List getNewBook(){
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query query=session.createQuery("from Book b");
		query.setFirstResult(0);
		query.setMaxResults(5);
		List books=query.list();
		session.close();
		return books;
	}


}
