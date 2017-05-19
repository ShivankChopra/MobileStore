package mobileStore.domain ;

public class Customer{
	private String id;
	private String username;
	private String Fname;
	private String Lname;
	private String email;
	private String phone;
	private String DOB;
	private String password;
	
	public Customer(){
		id = new String("null");
		username = new String("null");
		Fname = new String("null");
		Lname = new String("null");
		email = new String("null");
		phone = new String("null");
		DOB = new String("null");
		password = new String("null");
	}
	// copy constructor
	public Customer(Customer cs){
		id = cs.getId();
		username = cs.getUsername();
		Fname = cs.getFname();
		Lname = cs.getLname();
		email = cs.getEmail();
		phone = cs.getPhone();
		DOB = cs.getDOB();
		password = cs.getPassword();
	}
	//getters
	public String getId(){  return this.id; }
	public String getUsername(){  return this.username; }
	public String getFname(){  return this.Fname; }
	public String getLname(){  return this.Lname; }
	public String getEmail(){  return this.email; }
	public String getPhone(){  return this.phone; }
	public String getDOB(){  return this.DOB; }
	public String getPassword(){ return this.password; }
	
	//setters
	public void setId(String id){ this.id = id ; }
	public void setUsername(String name){ this.username = name ; }
	public void setFname(String Fname){ this.Fname = Fname ; }
	public void setLname(String Lname){ this.Lname = Lname ; }
	public void setEmail(String email){ this.email = email ; }
	public void setPhone(String phone){ this.phone = phone ; }
	public void setDOB(String dob){ this.DOB = dob ; }
	public void setPassword(String pswrd){ this.password = pswrd; }
}