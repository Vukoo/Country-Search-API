package com.gadek.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Country {
	private String country;
	private String capital;
	private String flag;
	private String currency;
	
	public Country() {}
	
	@Override
	public String toString() {
		return "Country [country=" + country + ", capital=" + capital + ", flag=" + flag + ", currency=" + currency
				+ "]";
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
