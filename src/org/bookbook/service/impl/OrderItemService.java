package org.bookbook.service.impl;

import org.bookbook.dao.IOrderItemDAO;
import org.bookbook.model.Orderitem;
import org.bookbook.service.IOderItemService;

public class OrderItemService implements IOderItemService {

	private IOrderItemDAO orderitemDAO;

	public void setOrderitemDAO(IOrderItemDAO orderitemDAO) {
		this.orderitemDAO = orderitemDAO;
	}

	public void saveOrderitem(Orderitem orderitem) {
		this.orderitemDAO.saveOrderItem(orderitem);
	}

}
