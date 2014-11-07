package web.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import negocio.BidServiceLocal;
import dto.Bid_DTO;
import ejbExcepciones.NoHayDatosDBException;

@ManagedBean(name="BidBean")
@RequestScoped
public class BidBean {
	
	private double importe;
	private int idItem;
	private int idUser;
	private int idBid;
	
	@EJB
	private static BidServiceLocal bidService;

	public BidBean() {

	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
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

	public int getIdBid() {
		return idBid;
	}

	public void setIdBid(int idBid) {
		this.idBid = idBid;
	}

	public void addBid(){
		
	}
	
	private void clean(){
		this.idBid = 0;
		this.idItem = 0;
		this.idUser = 0;
		this.importe = 0.0;
	}
	
	public void bidSearch( ) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			
			Bid_DTO bid =  bidService.getBid( idBid );
			
			setIdItem( bid.getIdItem());
			setIdUser( bid.getIdUser());
			setImporte( bid.getBidPrice() );
			
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
			fc.addMessage( "bidBid.msjBidBid",  new FacesMessage( "<!>", "Error al buscar bid. " + e.getMessage() ));
			clean();
		} catch ( NoHayDatosDBException e ) {
			fc.addMessage( "bidBid.msjBidBid",  new FacesMessage( "<!>", "No fue encontrado bid con # " + idBid  ));
			clean();
		}
		
	}
	
}
