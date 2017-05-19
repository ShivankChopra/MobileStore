package mobileStore.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import mobileStore.domain.Phone;
import mobileStore.domain.CartItem;
import mobileStore.service.CartService;
import mobileStore.service.PhoneService;
import mobileStore.service.OrderService;

@Controller
public class restController{
	
	@Autowired
	CartService cs ;
	
	@Autowired
	PhoneService ps ;
	
	@Autowired
	OrderService os ;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(method = RequestMethod.GET , value = "/addCart/{customerId}" )
	public @ResponseBody String addCart(@PathVariable("customerId") String id){
		cs.addCart(id);
		return "cart with id " + id + " was added.";
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(method = RequestMethod.GET , value = "/addToCart/{customerId}/{phoneId}" )
	public  @ResponseBody String addToCart(@PathVariable("customerId") String Id ,
			              @PathVariable("phoneId") String phoneId ){
		Phone p = new Phone();
		p = ps.getPhoneById(phoneId);
	    CartItem item = new CartItem(p);
	    cs.addToCart(Id, item);
	    return p.getCompany() + p.getModel() + " was added to" + Id ;
    }
	
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(method = RequestMethod.GET , value = "/removeFromCart/{customerId}/{phoneId}" )
    public  @ResponseBody String removeFromCart(@PathVariable("customerId") String Id ,
                                           @PathVariable("phoneId") String phoneId ){
                   Phone p = new Phone();
                   p = ps.getPhoneById(phoneId);
                   CartItem item = new CartItem(p);
                   cs.removeFromCart(Id, item);
                   return p.getCompany() + p.getModel() + " was removed from " + Id ;
    }
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(method = RequestMethod.GET , value = "/getCart/{userId}")
	public @ResponseBody String getCart(@PathVariable("userId") String cstmrId){
		Gson gson =  new Gson();
		return gson.toJson(cs.getCart(cstmrId));
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(method = RequestMethod.GET , value = "/saveOrder/{userId}")
	public @ResponseBody String saveOrder(@PathVariable("userId") String cstmrId){
		Gson gson =  new Gson();
		return gson.toJson(os.saveOrder(cs.getCart(cstmrId)));
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(method = RequestMethod.GET , value = "/getPreviousOrders/{userId}")
	public @ResponseBody String getPreviousOrders(@PathVariable("userId") String cstmrId){
		Gson gson =  new Gson();
		return gson.toJson(os.getPreviousOrders(cstmrId));
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(method = RequestMethod.GET , value = "/removecart/{userId}")
    public @ResponseBody void removecart(@PathVariable("userId") String cstmrId){
        cs.removeCart(cstmrId);
    }
	
}