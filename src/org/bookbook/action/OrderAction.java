package org.bookbook.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.bookbook.model.Orders;
import org.bookbook.service.IOrderService;
import com.opensymphony.xwork2.ActionSupport;
import org.bookbook.model.Orderitem;

public class OrderAction extends ActionSupport {

	protected Orders order;
	protected IOrderService orderService;

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
