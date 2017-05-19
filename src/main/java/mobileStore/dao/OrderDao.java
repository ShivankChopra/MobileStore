package mobileStore.dao;

import mobileStore.domain.Order;

import java.sql.PreparedStatement;  
import java.sql.SQLException;  

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback; 

import mobileStore.domain.Cart;
import mobileStore.domain.CartItem;
import mobileStore.domain.Phone;

@Repository
public class OrderDao{
	
private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public OrderDao(){
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
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	private void setNewOrderIdAndDate(Order order){
		int var = 0;
		try{
		    var = this.jdbcTemplate.queryForObject("select count(*) from customerorder ;",Integer.class);
		}
		catch(DataAccessException s){
			var = 0;
		}
		
		order.setOrderId(order.getCart().getId() + "O" + (++var));
		
		//set current date 
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String orderDate = dateformat.format(date);
		order.setOrderDate(orderDate);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	private Boolean addToOrder(final Order order){
		String query = "insert into customerorder values(?,?,?,?);";
		return this.jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
			
			public Boolean doInPreparedStatement(PreparedStatement ps)
					          throws SQLException, DataAccessException{
				
				ps.setString(1, order.getCart().getId());
				ps.setString(2, order.getOrderId());
				ps.setString(3, order.getOrderDate());
				ps.setLong(4, order.getCart().getGrandTotal());
				
				return ps.execute();
			}
		});
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean addToOrderItem(final String orderId, final CartItem item){
    	String query = "insert into orderitem values(?,?,?,?);";
		return this.jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
			
			public Boolean doInPreparedStatement(PreparedStatement ps)
					          throws SQLException, DataAccessException{
				
				ps.setString(1, orderId);
				ps.setString(2, item.getPhone().getId());
				ps.setInt(3, item.getQuantity());
				ps.setLong(4, item.getTotalPrice());
				
				return ps.execute();
			}
		});
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	public Order addOrder(Order order){
		setNewOrderIdAndDate(order);
		addToOrder(order);
		for(CartItem ci : order.getCart().getCartItems().values()){
			addToOrderItem(order.getOrderId(),ci);
		}
		return order;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	private Map<String,CartItem> getCartItems(String orderId){
		String query = "select * from orderitem where orderId = '" + orderId + "';" ;
		Map<String,CartItem> orderItems = new HashMap<String,CartItem>();
		List<Map<String,Object>> rows = this.jdbcTemplate.queryForList(query);
		PhoneDao pd = new PhoneDao();
		
		for(Map<String,Object> row : rows){
			String phoneId = (String)row.get("phoneId");
			Phone phone = new Phone(pd.getPhoneById(phoneId));
			CartItem item = new CartItem(phone);
			item.setQuantity((Integer)row.get("quantity"));
			item.setTotalPrice((Long)row.get("totalPrice"));
			orderItems.put(phoneId, item);
		}// for
		
		return orderItems;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Order> getPreviousOrders(String cstmrId){
		
		String query = "select * from customerorder where cstmrId = '" + cstmrId + "';" ;
		List<Order> prevOrders = new ArrayList<Order>();
		List<Map<String,Object>> rows = this.jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> row : rows){
			Cart cart = new Cart(cstmrId);
			Order order = new Order();
			
			order.setOrderId((String)row.get("orderId"));
			order.setOrderDate(row.get("orderDate").toString());
			cart.setGrandTotal(Integer.valueOf((Integer)row.get("totalPrice")));
			cart.setCartItems(getCartItems(order.getOrderId()));
			order.setCart(cart);
			
			prevOrders.add(order);
		}// for
		
		return prevOrders;
	}
}