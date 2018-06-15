package org.bookbook.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bookbook.service.IOrderItemService;
import org.bookbook.model.Cart;
import org.bookbook.model.Orders;
import org.bookbook.model.Usertable;
import org.bookbook.service.IOrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.bookbook.model.Orderitem;

public class OrderAction extends ActionSupport {

	protected Orders order;
	protected IOrderService orderService;
	protected IOrderItemService orderitemService;

	public String checkout() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("user").equals(null)) {
			return LOGIN;
		}
		Usertable user = (Usertable) session.get("user");
		Cart cart = (Cart) session.get("cart");

		Map<Integer, Orderitem> map = cart.getItems();
		Set<Integer> keys = map.keySet();
		Set<Orderitem> orderitems = new HashSet<Orderitem>();
		for (Integer key : keys) {
			orderitems.add(map.get(key));
		}
		Integer orderid = orderService.getOrderID();
		Orders orders = new Orders();
		orders.setOrderitems(orderitems);
		Timestamp timestamp = new Timestamp(new Date().getTime());
		orders.setOrderdate(timestamp);
		orders.setUsertable(user);
		orders.setOrderid(orderid);
		orderService.saveOrder(orders);
		order = orders;
		for (Orderitem orderitem : orderitems) {
			orderitem.setOrders(orders);
		}
		orderitemService.saveOrderItem(orderitems);
		session.remove("cart");
		return SUCCESS;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public void setOrderitemService(IOrderItemService orderitemService) {
		this.orderitemService = orderitemService;
	}

}
