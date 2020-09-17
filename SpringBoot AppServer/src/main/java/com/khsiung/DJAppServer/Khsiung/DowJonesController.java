package com.khsiung.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
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
}