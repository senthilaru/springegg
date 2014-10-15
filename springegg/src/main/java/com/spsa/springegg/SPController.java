package com.spsa.springegg;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spsa.springegg.domain.SPInput;
import com.spsa.springegg.domain.SPMetrics;

@RestController
public class SPController {

	private @Autowired HttpServletRequest request;
	
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
	
	@RequestMapping(value="/weather", method = RequestMethod.POST)
	public String getWeather(){
		RestTemplate rest = new RestTemplate();
		SPMetrics metrics = (SPMetrics)request.getAttribute("metrics");
		metrics.setClassName("SPController");
		metrics.setOperationName("getWeather");
		ResponseEntity<String> result = rest.exchange("http://api.openweathermap.org/data/2.5/weather?q=US,Schaumburg", HttpMethod.GET, null, String.class);
		System.out.println("result.getBody():"+result.getBody());
		return result.toString();
	}
	
}
