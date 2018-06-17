package org.bookbook.service.impl;

import java.util.Set;

import org.bookbook.dao.IOrderItemDAO;
import org.bookbook.model.Orderitem;
import org.bookbook.service.IOrderItemService;

public class OrderItemService implements IOrderItemService {

	private IOrderItemDAO orderitemDAO;

	public void setOrderitemDAO(IOrderItemDAO orderitemDAO) {
		this.orderitemDAO = orderitemDAO;
	}

	public void saveOrderitem(Orderitem orderitem) {
		this.orderitemDAO.saveOrderItem(orderitem);
	}

	public void saveOrderItem(Set<Orderitem> orderitems) {
		this.orderitemDAO.saveOrderItem(orderitems);
	}

	public int getOrderItemID() {
		return this.orderitemDAO.getOrderItemID();
	}
}
