package org.bookbook.dao.impl;

import org.bookbook.dao.IOrderItemDAO;
import org.bookbook.model.Orderitem;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderItemDAO extends HibernateDaoSupport implements IOrderItemDAO {

	public void saveOrderItem(Orderitem orderitem) {
		this.getHibernateTemplate().save(orderitem);
	}

}
