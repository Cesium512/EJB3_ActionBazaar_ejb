package negocio;

import java.util.List;

import javax.jws.WebService;

import persistencia.Bid;
import persistencia.Item;
import dto.Bid_DTO;

@WebService
public interface BidServiceWS  {
	
	public List<Bid_DTO> getBids(Item item);
	
}
