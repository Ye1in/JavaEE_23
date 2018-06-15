package org.bookbook.dao;

import java.util.Set;

import org.bookbook.model.Orderitem;

public interface IOrderItemDAO {

	public void saveOrderItem(Orderitem orderitem);

	public void saveOrderItem(Set<Orderitem> orderitems);

}
