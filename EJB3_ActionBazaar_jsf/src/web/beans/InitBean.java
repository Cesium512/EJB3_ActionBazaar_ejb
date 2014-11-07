package web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import negocio.FeturedItemLocal;
import dto.Item_DTO;


@ManagedBean
@RequestScoped
public class InitBean {
	
	public List<Item_DTO> items;

	@EJB
	private static FeturedItemLocal featuredItemService;
	
	public InitBean() {

	}
	
	@PostConstruct
	private void initialize(){
		
		items = featuredItemService.getFeturedItems();
		
	}

	public List<Item_DTO> getItems() {
		return items;
	}

	public void setItems(List<Item_DTO> items) {
		this.items = items;
	}

}
