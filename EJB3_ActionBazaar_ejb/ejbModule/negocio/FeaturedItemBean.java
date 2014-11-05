package negocio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.sql.DataSource;

import dto.Item_DTO;

@Singleton
@Startup
//@DependsOn("")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class FeaturedItemBean implements FeturedItemLocal {

	@Resource(name="java:jboss/datasources/ActionBazaarDB")
	private DataSource datasource;
	private Connection connection;
	
	private List<Item_DTO> featuredItems;
	
	public FeaturedItemBean() {

	}
	
	@PostConstruct
	public void openConnection(){
		try{
			connection = datasource.getConnection();
			//this.loadFeaturedItem();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	@Schedule( year="*", dayOfWeek="*" , hour="*" , minute="*/3" , persistent=false )
	@Timeout
	@AccessTimeout(unit=TimeUnit.MINUTES, value=1)
	private void loadFeaturedItem(Timer timer){
		
		System.out.println(" #### Iniciando el FeaturedItemBean.loadFeaturedItem() ");
		
		this.featuredItems = new ArrayList<Item_DTO>();
		
		Item_DTO fitem = null;
		String CONSULTA = "SELECT i.ItemId, i.itemName, i.bidStartDate, i.bidEndTime, i.CreateDate " +
						  "FROM FeturedItems f, Item i "+
						  "WHERE f.itemId = i.ItemId";
		
		try{
			
			Statement stmt = connection.createStatement( );
			ResultSet rs = stmt.executeQuery( CONSULTA );
			
			while ( rs.next()){
				
				fitem = new Item_DTO( rs.getString( "itemName" ),
									  (java.sql.Date)rs.getDate( "bidStartDate" ),
									  (java.sql.Date)rs.getDate( "bidEndTime" ) ,
									  (java.sql.Date)rs.getDate( "CreateDate" ),
									  rs.getLong( "itemId" ) );
				
				this.featuredItems.add( fitem );
				
			}
				
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Item_DTO> getFeturedItems() {

		return this.featuredItems;
		
	}
	
    @PreDestroy
    public void cleanup(){
    	
    	try{
    		connection.close();
    		connection = null;
    	} catch ( SQLException e ) {
    		e.printStackTrace();
    	}

    }
    
}
