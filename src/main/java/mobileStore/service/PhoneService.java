package mobileStore.service;

import mobileStore.domain.Phone;
import mobileStore.dao.PhoneDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PhoneService{
	
	@Autowired
	PhoneDao phnd;
	
	public List<Phone> getAllPhones(){
		List<Phone> phns = new ArrayList<Phone>();
		
		phns.add(phnd.getPhone("Nokia" , "N8"));
		phns.add(phnd.getPhone("Nokia" , "N9"));
		phns.add(phnd.getPhone("Nokia" , "lumia530"));
		phns.add(phnd.getPhone("Nokia" , "3110c"));
		phns.add(phnd.getPhone("Samsung" , "guru"));
		phns.add(phnd.getPhone("Samsung" , "E5"));
		phns.add(phnd.getPhone("samsung" , "galaxyS6"));
				
		return phns;
	}
	//////////////////////////////////////////////////////////////
	public Phone getPhoneById(String id){
		return phnd.getPhoneById(id);
	}
}