package com.spsa.springegg;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SPServiceImpl{

	@PayloadRoot(localPart = "testMe", namespace="http://www.example.org/spservice/")
    @ResponsePayload
	public String testMe(String name) {
		return name+" - " + "SPSA";
	}

}
