package com.spsa.springegg;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spsa.springegg.domain.SPInput;

@RestController
public class SPController {

	@RequestMapping(value="/name", method = RequestMethod.GET)
	public String getName(){
		return "SPSA";
	}
	
	@RequestMapping(value="/greet", method = RequestMethod.POST)
	public String getName(@RequestBody SPInput spin){
		if(spin.getName().equals("SP")){
			throw new IllegalArgumentException("Testing SPSAException");
		}
		return "Dear " + spin.getName();
	}
}
