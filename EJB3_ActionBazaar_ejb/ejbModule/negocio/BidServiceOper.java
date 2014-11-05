package negocio;

import java.util.List;

import persistencia.Bid;
import persistencia.Item;
import dto.Bid_DTO;
import ejbExcepciones.NoHayDatosDBException;

public interface BidServiceOper {

	public long addBid(Bid bid);
	
	public void cancelBid(Bid_DTO bid);
	
	public List<Bid_DTO> getBids(Item item);
	
	public Bid_DTO getBid(long bidId) throws NoHayDatosDBException;
	
	
}
