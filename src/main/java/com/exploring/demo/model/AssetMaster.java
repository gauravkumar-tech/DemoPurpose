package com.exploring.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ASSETMASTER")
public class AssetMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ASSETID")
	private String assetid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INVOICEDATE")
	private Date invoicedate;
	
	@Column(name = "PONUMBER")
	private BigDecimal ponumber;

	public AssetMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetMaster(String assetid, Date invoicedate, BigDecimal ponumber) {
		super();
		this.assetid = assetid;
		this.invoicedate = invoicedate;
		this.ponumber = ponumber;
	}

	public String getAssetid() {
		return assetid;
	}

	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}

	public Date getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(Date invoicedate) {
		this.invoicedate = invoicedate;
	}

	public BigDecimal getPonumber() {
		return ponumber;
	}

	public void setPonumber(BigDecimal ponumber) {
		this.ponumber = ponumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetid == null) ? 0 : assetid.hashCode());
		result = prime * result + ((invoicedate == null) ? 0 : invoicedate.hashCode());
		result = prime * result + ((ponumber == null) ? 0 : ponumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetMaster other = (AssetMaster) obj;
		if (assetid == null) {
			if (other.assetid != null)
				return false;
		} else if (!assetid.equals(other.assetid))
			return false;
		if (invoicedate == null) {
			if (other.invoicedate != null)
				return false;
		} else if (!invoicedate.equals(other.invoicedate))
			return false;
		if (ponumber == null) {
			if (other.ponumber != null)
				return false;
		} else if (!ponumber.equals(other.ponumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssetMaster [assetid=" + assetid + ", invoicedate=" + invoicedate + ", ponumber=" + ponumber + "]";
	}
	
	
}
