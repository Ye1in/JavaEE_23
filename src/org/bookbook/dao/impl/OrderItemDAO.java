package org.bookbook.dao.impl;

import java.util.Set;

import org.bookbook.dao.IOrderItemDAO;
import org.bookbook.model.Orderitem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderItemDAO extends HibernateDaoSupport implements IOrderItemDAO {

	public void saveOrderItem(Orderitem orderitem) {
		this.getHibernateTemplate().save(orderitem);
	}

	public void saveOrderItem(Set<Orderitem> orderitems) {
		for (Orderitem orderitem : orderitems) {
			this.getHibernateTemplate().save(orderitem);
		}
	}

	public int getOrderItemID() {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		Query query = session.createQuery("select count(*) from Orderitem");

		Long result = (Long) query.uniqueResult();
		return result.intValue();
	}

}
