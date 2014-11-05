package persistencia;

import java.util.Set;

public class Bidder extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5018571012748391775L;
	private Long CreditRating;
	private Set<Bid> bids;
	
	
	public Bidder() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param creditRating
	 */
	public Bidder(Long creditRating) {
		super();
		CreditRating = creditRating;
	}


	public Long getCreditRating() {
		return CreditRating;
	}


	public void setCreditRating(Long creditRating) {
		CreditRating = creditRating;
	}


	public Set<Bid> getBids() {
		return bids;
	}


	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	
	
}
