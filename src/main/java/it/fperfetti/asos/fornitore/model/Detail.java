package it.fperfetti.asos.fornitore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DETAILS")
public class Detail {
	
	@Id @GeneratedValue private Long id;
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	@OneToOne private Event event;
	public Event getEvent() { return event; }
	public void setEvent(Event event) { this.event = event; }
	
	@OneToOne private Order order;
	public Order getOrder() { return order; }
	public void setOrder(Order order) { this.order = order; }
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	public Integer getQuantity() { return quantity; }
	public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
 