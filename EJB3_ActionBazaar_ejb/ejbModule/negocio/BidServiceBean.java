package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
//import javax.ejb.Local;
//import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import persistencia.Bid;
import persistencia.Bidder;
import persistencia.Item;
import dto.Bid_DTO;
import ejbExcepciones.NoHayDatosDBException;

/**
 * Session Bean implementation class BidServiceBean
 */
@Stateless(name = "BidServiceBean")
//@Local({BidServiceLocal.class, BidServiceRemote.class})
//@LocalBean
public class BidServiceBean implements BidServiceLocal, BidServiceRemote, BidServiceWS {
	
	private Connection conexion;
	//@Resource(name = "jdbc/ActionBazaarDB")
	@Resource(name = "java:jboss/datasources/ActionBazaarDB")
	private DataSource datasource;
	
    /**
     * Default constructor.
     */
    public BidServiceBean() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct 
    public void initialize() {
    	/**
    	 * Inicializa la conexion con el datasource.
    	 */
    	
    	try{
    		
    		conexion = datasource.getConnection();
    		
    	}catch ( SQLException e){
    		e.printStackTrace();
    	}
    	
    }
    
    @PreDestroy
    public void cleanup(){
    	/** 
    	 * Se limpian las conexiones a la base se datos. 
    	 */
    	try{
    		
    		conexion.close();
    		conexion = null;
    		
    	} catch ( SQLException e) {
    		e.printStackTrace();
    	}
    	
    	
    }
        
	/**
     * @see BidServiceOper#getBids(Item)
     */
    public List<Bid_DTO> getBids(Item item) {
        // TODO Auto-generated method stub
    	
    	return null;
			
    }

	/**
     * @see BidServiceOper#addBid(Bid)
     */
    public long addBid(Bid bid) {
        // TODO Auto-generated method stub
			return 0;
    }

	/**
     * @see BidServiceOper#cancelBid(Bid)
     */
    public void cancelBid(Bid_DTO bid) {
        // TODO Auto-generated method stub
    }

	/**
     * @throws NoHayDatosDBException 
	 * @see BidServiceOper#getBid(long)
     */
    public Bid_DTO getBid(long bidId) throws NoHayDatosDBException {
    	
    	Bid_DTO bidResultado;
    	bidResultado = null;
    	String CONSULTA = "SELECT * FROM actionBazaar.Bid WHERE idBid = ?";
    	
    	
    	try{
    		
    		PreparedStatement pstmt = conexion.prepareStatement( CONSULTA );
    		pstmt.setLong( 1 , bidId );
    		ResultSet rs = pstmt.executeQuery();
    		
    		if (rs.next() ){ 
    			
    			bidResultado = new Bid_DTO( rs.getDouble("importe"),  rs.getInt("idItem") , rs.getInt("idUser") );
    			
    		} else {
    			
    			throw new NoHayDatosDBException( "No fueron encontrados datos para el bid: " + bidId );
    			
    		}
    		
    	}catch (SQLException e){
    		e.printStackTrace();
    	}
    	
		return bidResultado;
    }

}
