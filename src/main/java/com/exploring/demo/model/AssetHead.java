package com.exploring.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASSETHEAD")
public class AssetHead implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ASSETID")
	private String assetid;
	
	@Column(name = "ASSETHEADID")
	private String assetheadid;

	public String getAssetid() {
		return assetid;
	}

	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}

	public String getAssetheadid() {
		return assetheadid;
	}

	public void setAssetheadid(String assetheadid) {
		this.assetheadid = assetheadid;
	}

	public AssetHead(String assetid, String assetheadid) {
		super();
		this.assetid = assetid;
		this.assetheadid = assetheadid;
	}

	public AssetHead() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetheadid == null) ? 0 : assetheadid.hashCode());
		result = prime * result + ((assetid == null) ? 0 : assetid.hashCode());
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
		AssetHead other = (AssetHead) obj;
		if (assetheadid == null) {
			if (other.assetheadid != null)
				return false;
		} else if (!assetheadid.equals(other.assetheadid))
			return false;
		if (assetid == null) {
			if (other.assetid != null)
				return false;
		} else if (!assetid.equals(other.assetid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssetHead [assetid=" + assetid + ", assetheadid=" + assetheadid + "]";
	}
	
	
	
}
