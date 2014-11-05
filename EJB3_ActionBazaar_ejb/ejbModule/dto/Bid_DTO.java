package dto;

import java.io.Serializable;

import persistencia.Bidder;
import persistencia.Item;

public class Bid_DTO implements Serializable {

	private static final long serialVersionUID = -1789671619212493957L;
	private Double bidPrice;
	private int idItem;
	private int idUser;
	private Item item;
	private Bidder bidder;
	

	public Bid_DTO()  {
		
	}
	
	/**
	 * @param bidPrice
	 * @param idItem
	 * @param idUser
	 */
	public Bid_DTO(Double bidPrice, int idItem, int idUser) {
		super();
		this.bidPrice = bidPrice;
		this.idItem = idItem;
		this.idUser = idUser;
	}

	public Double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

}
