package persistencia;

import java.io.Serializable;
import java.util.Date;

public class Bid implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date bidDate;
	private Long bidId;
	private Double bidPrice;
	private Item item;
	private Bidder bidder;
	
	public Bid() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param bidPrice
	 * @param item
	 * @param bidder
	 */
	public Bid(Double bidPrice, Item item, Bidder bidder) {
		super();
		this.bidPrice = bidPrice;
		this.item = item;
		this.bidder = bidder;
		
	}



	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public Long getBidId() {
		return bidId;
	}

	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	public Double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
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
