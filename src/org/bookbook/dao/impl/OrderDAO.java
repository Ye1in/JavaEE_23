package org.bookbook.dao.impl;

import org.bookbook.dao.IOrderDAO;
import org.bookbook.model.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderDAO extends HibernateDaoSupport implements IOrderDAO {

	public void saveOrder(Orders order) {
		this.getHibernateTemplate().save(order);
	}

	public void updateOrder(Orders order) {
		this.getHibernateTemplate().update(order);
	}

	public int getOrderID() {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		Query query = session.createQuery("select count(*) from Orders");

		Long result = (Long) query.uniqueResult();
		return result.intValue();
	}

}
