package it.fperfetti.asos.fornitore.model;

import java.sql.Timestamp;
import java.util.ArrayList;
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

import org.hibernate.annotations.Type;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id @GeneratedValue
	private Long id;
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	@OneToMany
	private List<Detail> details = new ArrayList<Detail>();
	public List<Detail> getDetails() { return details; }
	public void addDetail(Detail detail) { details.add(detail); }
	
	@Column(name = "TOTAL")
	private Double total = new Double(0.0);
	public Double getTotal() { return total; }
	public void setTotal(Double total) { this.total = total; }	

	@Column(name = "VENDOR")
	private String vendor;
	public String getVendor() { return vendor; }
	public void setVendor(String vendor) { this.vendor = vendor; }

	@Column(name = "CONFIRMATED")
	private Boolean confimated;
	public Boolean getConfimated() { return confimated; }
	public void setConfirmated(Boolean confimated) { this.confimated = confimated; }

	@Temporal(TemporalType.TIMESTAMP) @NotNull @Column(updatable=false) @Type(type="timestamp")
	private Date timestamp;
	public Date getDate() { return timestamp; }
	public void setDate(Date timestamp) { this.timestamp = timestamp; }

	public Boolean isValidOrder(){
		Timestamp ts = new Timestamp(getDate().getTime());
		long m = 8*60*1000;
		Timestamp thresholdTs = new Timestamp(ts.getTime()+m);
		if(ts.compareTo(thresholdTs)<=0){ return true; }
		return false;
	}
}
