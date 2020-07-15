package com.crosspay.rates.model;

public class RatesModel {
	
	
	private String fromCcy;
	private String toCcy;
	private Double amount;
	
	
	public String getFromCcy() {
		return fromCcy;
	}
	public void setFromCcy(String fromCcy) {
		this.fromCcy = fromCcy;
	}
	public String getToCcy() {
		return toCcy;
	}
	public void setToCcy(String toCcy) {
		this.toCcy = toCcy;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
