package com.khsiung.controller;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import com.khsiung.model.DowJones;
import com.khsiung.repository.DowJonesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@RestController
public class DowJonesController {
	private static final Logger logger = LoggerFactory.getLogger(DowJonesController.class);

	@Autowired
    private DowJonesRepository repository;
    
    @GetMapping("/search")
	public Object search(@RequestParam(value = "ticker") String ticker)  {
		List<DowJones> stocks = repository.findByStock(ticker);
		return stocks;
	}
	
	@PostMapping("/add")
	public Map<String, Object> createBook(@RequestBody Map<String, Object> dowJones){
		DowJones dowjones = new DowJones(
			dowJones.get("quarter").toString(),
			dowJones.get("stock").toString(),
			dowJones.get("date").toString(),
			dowJones.get("open").toString(),
			dowJones.get("high").toString(),
			dowJones.get("low").toString(),
			dowJones.get("close").toString(),
			dowJones.get("volume").toString(),
			dowJones.get("percent_change_price").toString(),
			dowJones.get("percent_change_volume_over_last_wk").toString(),
			dowJones.get("previous_weeks_volume").toString(),
			dowJones.get("next_weeks_open").toString(),
			dowJones.get("next_weeks_close").toString(),
			dowJones.get("percent_change_next_weeks_price").toString(),
			dowJones.get("days_to_next_dividend").toString(),
			dowJones.get("percent_return_next_dividend").toString());		
		repository.save(dowjones);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "dowjones created successfully");
		response.put("dowjones", dowjones);
		return response;
	}

	@PostMapping("/upload")
	public Map<String, Integer> upload(@RequestBody List<Map<String, Object>> dowJones){
		dowJones.forEach(dj -> {
			DowJones dowjones = new DowJones(
				dj.get("quarter").toString(),
				dj.get("stock").toString(),
				dj.get("date").toString(),
				dj.get("open").toString(),
				dj.get("high").toString(),
				dj.get("low").toString(),
				dj.get("close").toString(),
				dj.get("volume").toString(),
				dj.get("percent_change_price").toString(),
				dj.get("percent_change_volume_over_last_wk").toString(),
				dj.get("previous_weeks_volume").toString(),
				dj.get("next_weeks_open").toString(),
				dj.get("next_weeks_close").toString(),
				dj.get("percent_change_next_weeks_price").toString(),
				dj.get("days_to_next_dividend").toString(),
				dj.get("percent_return_next_dividend").toString());
			repository.save(dowjones);

		});
		
		Map<String, Integer> response = new LinkedHashMap<String, Integer>();
		response.put("dowjones", dowJones.size());
		return response;
	}
		
}