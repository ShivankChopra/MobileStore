package mobileStore.dao;

import java.sql.PreparedStatement;  
import java.sql.SQLException;  
import java.sql.ResultSet;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback; 
import mobileStore.domain.Customer;

@Repository
public class CustomerDao{

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public CustomerDao(){
		setDatasource();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////// setDataSource
	private void setDatasource() {  
	    DriverManagerDataSource ds = new DriverManagerDataSource(); 
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://localhost/mobileStore");
	    ds.setUsername("root");
	    ds.setPassword("Chopraa17");
	    this.jdbcTemplate.setDataSource(ds);
	}  
	/////////////////////////////////////////////////////////////////////////// calculate new customer id
	private void setNewCustomerId(Customer customer){
		int var = this.jdbcTemplate.queryForObject("select count(*) from customer ;",Integer.class);
		customer.setId("C_" + (++var));
	}
	////////////////////////////////////////////////////////////////////////////////// add new customer
	public Boolean addCustomer(final Customer customer){
		this.setNewCustomerId(customer);
		String query = "insert into customer values(?,?,?,?,?,?,?,?) ; " ;
		return this.jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
			    public Boolean doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			
			        ps.setString(1,customer.getId());
			        ps.setString(2,customer.getUsername());
			        ps.setString(3,customer.getFname());
			        ps.setString(4,customer.getLname());
			        ps.setString(5,customer.getPhone());
			        ps.setString(6,customer.getEmail());
			        ps.setString(7,customer.getDOB());
			        ps.setString(8,customer.getPassword());
			              
			        return ps.execute();  
			            
			    } // end doInPreparedStateent 
			    } /* end anonymous class */ ); // end execute  
	}
	/////////////////////////////////////////////////////////////////////// get customer by id
	public Customer getCustomerDetails(String username ,String password){
		String query = "select * from customer where c_username = '" + username + "' and c_password = '" + password + "' ;" ;
		try{
		return this.jdbcTemplate.queryForObject(query,new RowMapper<Customer>(){
			public Customer mapRow(ResultSet rs,int rowNum) throws SQLException{
				Customer cs = new Customer();
				cs.setId(rs.getString(1));
				cs.setUsername(rs.getString(2));
				cs.setFname(rs.getString(3));
				cs.setLname(rs.getString(4));
				cs.setPhone(rs.getString(5));
				cs.setEmail(rs.getString(6));
				cs.setDOB(rs.getDate(7).toString());
				
				return cs;
			}// end map row
		}/* end anonymous class*/ ); // end return
		
		}
		catch(Exception e){
			return null;
		}
	}
}////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// end class customerDao
