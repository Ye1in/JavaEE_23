package org.bookbook.dao.impl;

import org.bookbook.dao.IOrderDAO;
import org.bookbook.model.Orders;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderDAO extends HibernateDaoSupport implements IOrderDAO {

	public void saveOrder(Orders order) {
		this.getHibernateTemplate().save(order);
	}

	public void updateOrder(Orders order) {
		this.getHibernateTemplate().update(order);
	}

	public int getOrderID() {
		Integer count = (Integer) this.getHibernateTemplate().find(
				"select count(*) from Orders").listIterator().next();
		return count.intValue();
	}

}
