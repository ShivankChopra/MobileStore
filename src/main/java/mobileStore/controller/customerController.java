package mobileStore.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
 
import mobileStore.domain.Customer;
import mobileStore.service.CustomerService;
import mobileStore.domain.Phone;
import mobileStore.service.PhoneService;

import java.util.List;
import java.util.ArrayList;

@Controller
public class customerController {
 
	@Autowired
	CustomerService cs;
	
	@Autowired
	PhoneService ps;
	
    /////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/welcome")
	public ModelAndView showMessage() {
 
		ModelAndView mv = new ModelAndView("welcome");
		return mv;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/addNewCustomer")
	public ModelAndView addCustomer(@RequestParam(value = "userName") String username ,
			                        @RequestParam(value = "firstName") String Fname ,
			                        @RequestParam(value = "lastName") String Lname ,
			                        @RequestParam(value = "email") String email ,
			                        @RequestParam(value = "phone") String phone ,
			                        @RequestParam(value = "DoB") String dob ,
			                        @RequestParam(value = "password") String password ){
		cs.addCustomer(username, Fname, Lname, email, phone, dob, password);
		ModelAndView mv = new ModelAndView("newAccount");
		mv.addObject("username", username);
		mv.addObject("name", Fname + Lname);
		mv.addObject("email", email);
		mv.addObject("phone", phone);
		mv.addObject("dob", dob);
		return mv;
	}
    /////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(method=RequestMethod.POST , value = "/login")
	public ModelAndView login(@RequestParam(value = "username") String username ,
			                  @RequestParam(value = "password") String password ,
			                  HttpServletRequest request){
		Customer c1 = new Customer();
		try{
		c1 = cs.getCustomerDetails(username, password);
		}
		catch(Exception e){
			ModelAndView mv = new ModelAndView("errorPage");
			return mv;
		}
		
		
		    cs.setCstmrSessionAttr(request, c1);
		    List<Phone> pl = new ArrayList<Phone>();
		    pl = ps.getAllPhones();
		    Customer c = cs.getCustomerDetails(username, password);
		    ModelAndView mv = new ModelAndView("login");
		    mv.addObject("phoneList", pl);
		    mv.addObject("cstmr", c);
		    mv.addObject("cartAdded", "true");
		    return mv;
	 
	}
}// end class mainController