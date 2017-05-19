package mobileStore.service;

import mobileStore.domain.Order;
import mobileStore.domain.Cart;
import mobileStore.dao.OrderDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{
	
	@Autowired
	private OrderDao od;
	
	public Order saveOrder(Cart cart){
		Order order = new Order(cart);
		return od.addOrder(order);
	}
	
	public List<Order> getPreviousOrders(String cstmrId){
		return od.getPreviousOrders(cstmrId);
	}
}