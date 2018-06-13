package org.bookbook.service;

import org.bookbook.model.Orders;

public interface IOrderService {

	public void saveOrder(Orders order);
	public void updateOrder(Orders order);
}
