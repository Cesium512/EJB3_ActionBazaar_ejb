package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Item_DTO implements Serializable {

	private static final long serialVersionUID = 464506821798670620L;
	private String itemName;
	private Date bidStartDate;
	private Date bidEndTime;
	private Date createDate;
	private Long itemId;
	private List<Bid_DTO> bids;
	
	public Item_DTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param itemName
	 * @param bidStartDate
	 * @param bidEndTime
	 * @param createDate
	 * @param itemId
	 */
	public Item_DTO(String itemName, Date bidStartDate, Date bidEndTime,
			Date createDate, Long itemId) {
		super();
		this.itemName = itemName;
		this.bidStartDate = bidStartDate;
		this.bidEndTime = bidEndTime;
		this.createDate = createDate;
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
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public List<Bid_DTO> getBids() {
		return bids;
	}

	public void setBids(List<Bid_DTO> bids) {
		this.bids = bids;
	}
	
}
