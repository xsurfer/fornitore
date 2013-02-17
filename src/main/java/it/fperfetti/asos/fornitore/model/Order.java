package it.fperfetti.asos.fornitore.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id @GeneratedValue
	private Long id;
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	@OneToMany
	public List<Detail> getDetails() { return details; }
	public void addDetail(Detail detail) { details.add(detail); }
	private List<Detail> details;

	@Temporal(TemporalType.DATE) @NotNull @Column(updatable=false)
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	private Date date;
	
	@Column(name = "TOTAL")
	private Double total;
	public Double getTotal() { return total; }
	public void setTotal(Double total) { this.total = total; }	
	
	@Column(name = "VENDOR")
	private String vendor;
	public String getVendor() { return vendor; }
	public void setVendor(String vendor) { this.vendor = vendor; }
	
}
