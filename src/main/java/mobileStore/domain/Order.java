package mobileStore.domain;

public class Order{
	
	private String orderId;
	private Cart cart;
	private String orderDate;
	
	public Order(){
		this.orderId = null;
		this.orderDate = null;
	}
	
	public Order(Cart cart){
		this();
		this.cart = cart;
	}
	
	//getters
	public String getOrderId(){
		return this.orderId;
	}
	
	public String getOrderDate(){
		return this.orderDate;
	}
	
	public Cart getCart(){
		return this.cart;
	}
	
	//setters
	public void setOrderId(String var){
		this.orderId = var;
	}
	
	public void setOrderDate(String var){
		this.orderDate = var;
	}
	
	public void setCart(Cart var){
		this.cart = var;
	}
}