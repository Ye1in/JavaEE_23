package org.bookbook.dao.impl;

import java.util.Set;

import org.bookbook.dao.IOrderItemDAO;
import org.bookbook.model.Orderitem;
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

}
