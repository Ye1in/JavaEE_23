package org.bookbook.service.impl;

import org.bookbook.dao.IOrderDAO;
import org.bookbook.model.Orders;
import org.bookbook.service.IOrderService;

public class OrderService implements IOrderService {

	private IOrderDAO orderDAO;

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public void saveOrder(Orders order) {
		this.orderDAO.saveOrder(order);
	}

	public void updateOrder(Orders order) {
		this.orderDAO.updateOrder(order);
	}

	public int getOrderID() {
		return orderDAO.getOrderID();
	}

}
