package mobileStore.domain;

public class CartItem{
	
	private Phone phone;
	private int quantity;
	private long totalPrice;
	
	public CartItem(Phone ph){
		this.phone = ph;
		this.quantity = 1;
		this.totalPrice = ph.getPrice();
	}
	
	// updating total price
	private void updateTotalPrice(){
		this.totalPrice = this.phone.getPrice() * this.quantity ;
	}
	
	// getters
	public Phone getPhone(){
		return this.phone;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public long getTotalPrice(){
		return this.totalPrice;
	}
	
	//setters
	public void setPhone(Phone var){
		this.phone = var;
		this.updateTotalPrice();
	}
	
	public void setQuantity(int var){
		this.quantity = var;
		this.updateTotalPrice();
	}
	
	public void setTotalPrice(long var){
		this.totalPrice = var;
	}

}