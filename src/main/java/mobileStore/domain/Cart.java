package mobileStore.domain;

import java.util.Map;
import java.util.HashMap;

public class Cart{
	
	private String id;
	private Map<String,CartItem> cartItems;
	private long grandTotal;
	
	public Cart(){
		cartItems = new HashMap<String , CartItem>();
		grandTotal = 0;
	}
	
	public Cart(String cartId){
		this();
		id = cartId;
	}
	
	//getters
	public String getId(){
		return this.id;
	}
	
	public Map<String , CartItem> getCartItems(){
		return this.cartItems;
	}
	
	public long getGrandTotal(){
		return this.grandTotal;
	}
	
	//setters
	public void setId(String var){
		this.id = var;
	}
	
	public void setCartItems(Map<String , CartItem> var){
		this.cartItems = var;
	}
	
	public void setGrandTotal(long var){
		this.grandTotal = var;
	}
	
	// update grandTotal
	private void updateGrandTotal(){
		this.grandTotal = 0;
		for(CartItem ci : cartItems.values()){
			this.grandTotal += ci.getTotalPrice();
		}// for
	}
	
	public void addCartItem(CartItem item){
		String pdtID = item.getPhone().getId();
		// if item already exists
		if(cartItems.containsKey(pdtID)){
			CartItem existingItem = cartItems.get(pdtID);
			existingItem.setQuantity(existingItem.getQuantity() + 1);
			cartItems.put(pdtID, existingItem);
		}// if
		else{
			cartItems.put(pdtID, item);
		}// else
		
		this.updateGrandTotal();
	}
	
	public void removeCartItem(CartItem item){
		String pdtID = item.getPhone().getId();
		cartItems.remove(pdtID);
		this.updateGrandTotal();
	}
	
}