package org.bookbook.service;

import java.util.Set;

import org.bookbook.model.Orderitem;

public interface IOrderItemService {

	public void saveOrderitem(Orderitem orderitem);

	public void saveOrderItem(Set<Orderitem> orderitems);

}
