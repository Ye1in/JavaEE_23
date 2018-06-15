package org.bookbook.action;

import org.bookbook.model.Orderitem;
import org.bookbook.service.IOrderItemService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderItemAction extends ActionSupport {

	protected Orderitem orderitem;
	protected IOrderItemService orderitemService;

	public Orderitem getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(Orderitem orderitem) {
		this.orderitem = orderitem;
	}

	public void setOrderitemService(IOrderItemService orderitemService) {
		this.orderitemService = orderitemService;
	}

}
