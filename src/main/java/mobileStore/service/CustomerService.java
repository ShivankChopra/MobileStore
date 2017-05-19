package mobileStore.service;

import mobileStore.domain.Customer;
import mobileStore.dao.CustomerDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService{
	
	@Autowired
	CustomerDao csdao;
	//////////////////////////////////////////////////////////////
	public void addCustomer(String username ,
			                String fname ,
			                String lname ,
			                String email ,
			                String phone ,
			                String dob ,
			                String password){
		Customer cs = new Customer();
		// add parameters to customer object
		cs.setUsername(username);
		cs.setFname(fname);
		cs.setLname(lname);
		cs.setEmail(email);
		cs.setPhone(phone);
		cs.setDOB(dob);
		cs.setPassword(password);
		// update database with customer
		csdao.addCustomer(cs);
	}
	////////////////////////////////////////////////////////////////
    public Customer getCustomerDetails(String username, String password){
    	return new Customer(csdao.getCustomerDetails(username, password));
    }
    ////////////////////////////////////////////////////////////////
    public void setCstmrSessionAttr(HttpServletRequest request,Customer cs){
    	request.getSession().setAttribute("username" , cs.getUsername());
    	request.getSession().setAttribute("userID" , cs.getId());
    }
}