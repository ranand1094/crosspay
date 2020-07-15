package com.crosspay.rates.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crosspay.rates.entity.InterBankRates;
import com.crosspay.rates.model.GetRatesModel;
import com.crosspay.rates.model.RatesModel;
import com.crosspay.rates.model.UpdateIBRModel;
import com.crosspay.rates.repository.RatesRepository;

@Service
public class RatesServices {

	@Autowired
	private RatesRepository ratesRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	InterBankRates ibrEntity = new InterBankRates();

	
	private RatesModel convertToDto(InterBankRates ibr) {
		RatesModel restModel = modelMapper.map(ibr, RatesModel.class);
		return restModel;
	}

	private InterBankRates convertToEntity(RatesModel restModel) {
		InterBankRates interBankRates = modelMapper.map(restModel, InterBankRates.class);
		return interBankRates;
	}
	
	public Map calculateRate(RatesModel rates) {
		Map rateResult = new HashMap<String,String>();
		
		InterBankRates payinCcyRate = ratesRepo.getOne(rates.getFromCcy());
		InterBankRates payoutCcyRate = ratesRepo.getOne(rates.getToCcy());
		
		Double payinRate = payinCcyRate.getRate();
		Double payoutRate = payoutCcyRate.getRate();
		Double exchangeRate = payoutRate/payinRate;
		Double amount = rates.getAmount();
		Double convertedAmount = amount * exchangeRate;
		
		rateResult.put("returnCode", "2000");
		rateResult.put("returnMsg", "Sucessfully processed the request");
		rateResult.put("convertionAmount", convertedAmount);
		rateResult.put("conversionRate", exchangeRate);

		
		return rateResult;
	}

	public Map addRate(UpdateIBRModel ibr) {
		// TODO Auto-generated method stub
		Map addIBRResult = new HashMap<String,String>();
		
		ibrEntity = modelMapper.map(ibr, InterBankRates.class);
		ratesRepo.save(ibrEntity);
		addIBRResult.put("returnCode", "2000");
		addIBRResult.put("returnMsg", "Rates updated sucessfully");
			

		return addIBRResult;
	}

	public GetRatesModel  getRates() {
		
		GetRatesModel ratesModel = new GetRatesModel();
		List<InterBankRates> ibrRates = ratesRepo.findAll();
		
		if(ibrRates.isEmpty())
		{
			ratesModel.setReturnCode("4000");
			ratesModel.setReturnMsg("No Records available");
		}
		else
		{
			ratesModel.setRateList(ibrRates);
			ratesModel.setReturnCode("2000");
			ratesModel.setReturnMsg("Successfully processed request");
		}
		return ratesModel;
	}

}
