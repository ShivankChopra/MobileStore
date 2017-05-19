package mobileStore.dao;

import mobileStore.domain.Cart;
import java.util.Map;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class CartDao{
	
	private Map<String , Cart> listOfCarts = new HashMap<String , Cart>();
	
	///////////////////////////////////////////////////////////////////
	public void create(String id){
		if(listOfCarts.containsKey(id)){
			System.out.println("Cart for this user already exists");
		}// if
		else{
			Cart cart = new Cart(id);
			this.listOfCarts.put(id, cart);
		}// else
	}
	///////////////////////////////////////////////////////////////////
	public Cart getCart(String id){
		if(!this.listOfCarts.keySet().contains(id)){
			System.out.println("following cart with id " + id + " does not exists");
		}
		return this.listOfCarts.get(id);
	}
	///////////////////////////////////////////////////////////////////
	public void updateCart(String id ,Cart cart){
		if(listOfCarts.keySet().contains(id)){
			this.listOfCarts.put(id, cart);
		}
		else{
			System.out.println("Cart for user id " + id + " does not exists. ");
		}
	}
	////////////////////////////////////////////////////////////////////
	public void removeCart(String id){
		if(listOfCarts.keySet().contains(id)){
			this.listOfCarts.remove(id);
		}
		else{
			System.out.println("Cart for user id " + id + " does not exists. ");
		}
	}
	
}// end class