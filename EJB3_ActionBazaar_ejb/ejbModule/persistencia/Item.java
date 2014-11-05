package persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Item implements Serializable {

	/*
	 * 
	 */
	private static final long serialVersionUID = 464506821798670620L;
	private String itemName;
	private Date bidStartDate;
	private Date bidEndTime;
	private Date CreateDate;
	private Long itemId;
	private List<Bid> bids;
		
	public Item() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param itemId
	 */
	public Item(Long itemId) {
		super();
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public Date getBidEndTime() {
		return bidEndTime;
	}

	public void setBidEndTime(Date bidEndTime) {
		this.bidEndTime = bidEndTime;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	
	
}
