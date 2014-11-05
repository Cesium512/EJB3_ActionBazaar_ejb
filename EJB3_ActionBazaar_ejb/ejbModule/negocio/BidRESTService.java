package negocio;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dto.Bid_DTO;
import ejbExcepciones.NoHayDatosDBException;

/**
 * Session Bean implementation class BidRESTService
 */
@Stateless
@Path("/bid")
public class BidRESTService {
	@EJB
	private BidServiceLocal bidService;

    /**
     * Default constructor. 
     */
    public BidRESTService() {
        // TODO Auto-generated constructor stub
    }
    
    @GET
    @Produces("text/xml")
    public Bid_DTO getBid( @QueryParam("id") long id ) throws NoHayDatosDBException{
    	
    	return bidService.getBid( id );
    	
    }
    
    @DELETE
    public void deleteBid( @QueryParam("id") long id ) throws NoHayDatosDBException{
    	
    	Bid_DTO bid = bidService.getBid( id );
    	bidService.cancelBid( bid );
    	
    }

}
