package org.bookbook.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Set;

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

	public String checkout() {
		Map session = ActionContext.getContext().getSession();
		if (session.get("user").equals(null)) {
			return LOGIN;
		}
		Usertable user = (Usertable) session.get("user");
		Cart cart = (Cart) session.get("cart");
		Set<Orderitem> set = null;

		for (Map.Entry<Integer, Orderitem> elem : cart.getItems().entrySet()) {
			set.add(elem.getValue());
		}
		Integer orderid = orderService.getOrderID();
		Orders orders = new Orders();
		orders.setOrderitems(set);
		Timestamp timestamp = new Timestamp(new Date().getTime());
		orders.setOrderdate(timestamp);
		orders.setUsertable(user);
		orders.setOrderid(orderid);
		orderService.saveOrder(orders);
		order = orders;
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

}
