package mobileStore.domain;

public class Phone{
	String id;
	String company;
	String model;
	int price;
	String imgLoc;
	
	//constructor
	public Phone(){
		this.id = null;
		this.company = null;
		this.model = null;
		this.price = 0;
		this.imgLoc = null;
	}
	// copy constructor
	public Phone(Phone p){
		this.id = p.getId();
		this.company = p.getCompany();
		this.model = p.getModel();
		this.price = p.getPrice();
		this.imgLoc = p.getImgLoc();
	}
	
	// getters
	public String getId(){ return this.id; }
	public String getCompany(){ return this.company; }
	public String getModel(){ return this.model; }
	public int getPrice(){ return this.price; }
	public String getImgLoc(){ return this.imgLoc; }
	
	// setters
	public void setId(String id){ this.id = id;	}
	public void setCompany(String var){ this.company = var;	}
	public void setModel(String var){ this.model = var;	}
	public void setPrice(int var){ this.price = var;	}
	public void setImgLoc(String var){ this.imgLoc = var;	}
}