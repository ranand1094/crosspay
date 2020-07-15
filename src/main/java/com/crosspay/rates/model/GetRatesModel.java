package com.crosspay.rates.model;
import java.util.List;

import com.crosspay.rates.dto.RatesDTO;
import com.crosspay.rates.entity.InterBankRates;

public class GetRatesModel {
	
	private String returnCode;
	private String returnMsg;
	private List<InterBankRates> rateList;
	
	
	public List<InterBankRates> getRateList() {
		return rateList;
	}
	public void setRateList(List<InterBankRates> rateList) {
		this.rateList = rateList;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
	
	

}
