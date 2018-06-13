package org.bookbook.dao;

import org.bookbook.model.Orders;

public interface IOrderDAO {

	public void saveOrder(Orders order);

	public void updateOrder(Orders order);
}
