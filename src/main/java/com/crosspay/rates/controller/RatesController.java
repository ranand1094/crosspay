package com.crosspay.rates.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crosspay.rates.entity.InterBankRates;
import com.crosspay.rates.model.GetRatesModel;
import com.crosspay.rates.model.RatesModel;
import com.crosspay.rates.model.UpdateIBRModel;
import com.crosspay.rates.services.RatesServices;

@RestController
@RequestMapping("/crosspay/rate")
public class RatesController {
	
	@Autowired
	private RatesServices rateServices;
	
	@PostMapping("/convert")
	public Map calculateExRate(@RequestBody RatesModel rates) {
		
		return rateServices.calculateRate(rates);
		
	}
	
	@PostMapping("/update")
	public Map add(@RequestBody UpdateIBRModel ibr) {
		
		return rateServices.addRate(ibr);
		
	}
	
	@GetMapping("/all")
	public GetRatesModel getRates() {
		return rateServices.getRates();
	}
	
}
