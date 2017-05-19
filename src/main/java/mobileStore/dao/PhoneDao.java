package mobileStore.dao ;

import java.sql.SQLException;  
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import mobileStore.domain.Phone;

@Repository
public class PhoneDao{
	
private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public PhoneDao(){
		setDatasource();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////// setDataSource
	private void setDatasource() {  
	    DriverManagerDataSource ds = new DriverManagerDataSource(); 
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://localhost/mobileStore");
	    ds.setUsername("root");
	    ds.setPassword("Chopraa17");
	    this.jdbcTemplate.setDataSource(ds);
	}  
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Phone getPhoneById(String id){
		String query = "select p_id , p_company , p_model, p_sprice, imgLocation from phone where p_id = '" + id + "' ;" ;
		return this.jdbcTemplate.queryForObject(query, new RowMapper<Phone>(){
			public Phone mapRow(ResultSet rs, int rowNum)
					                     throws SQLException{
				Phone phn = new Phone();
				phn.setId(rs.getString("p_id"));
				phn.setCompany(rs.getString("p_company"));
				phn.setModel(rs.getString("p_model"));
				phn.setPrice(rs.getInt("p_sprice"));
				phn.setImgLoc(rs.getString("imgLocation"));
				
				return phn;
			}// end map row
		}/* end anonymous class */ );  // end queryForObject
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Phone getPhone(String company,String model){
		String query = "select p_id , p_company , p_model, p_sprice, imgLocation from phone where p_company = '" 
	                   + company 
	                   + "' and p_model = '" 
	                   + model 
	                   + "' limit 1;" ;
		
		return this.jdbcTemplate.queryForObject(query, new RowMapper<Phone>(){
			public Phone mapRow(ResultSet rs, int rowNum)
					                   throws SQLException{
				Phone phn = new Phone();
				phn.setId(rs.getString("p_id"));
				phn.setCompany(rs.getString("p_company"));
				phn.setModel(rs.getString("p_model"));
				phn.setPrice(rs.getInt("p_sprice"));
				phn.setImgLoc(rs.getString("imgLocation"));
				
				return phn;
			}// end map row
		}/* end anonymous class */ );  // end queryForObject
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
}