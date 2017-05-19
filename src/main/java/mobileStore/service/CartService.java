package mobileStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mobileStore.dao.CartDao;
import mobileStore.domain.Cart;
import mobileStore.domain.CartItem;

@Service
public class CartService{
	
	@Autowired
	private CartDao cd ;
	
	public void addCart(String id){
		this.cd.create(id);
	}
	
	public Cart getCart(String id){
		return this.cd.getCart(id);
	}
	
	public void addToCart(String id , CartItem item){
		Cart cart = new Cart(id);
		cart = this.cd.getCart(id);
		cart.addCartItem(item);
		this.cd.updateCart(id, cart);
	}
	
	public void removeFromCart(String id , CartItem item){
		Cart cart = new Cart(id);
		cart = this.cd.getCart(id);
		cart.removeCartItem(item);;
		this.cd.updateCart(id, cart);
	}
	
	public void removeCart(String id){
		this.cd.removeCart(id);
	}
}