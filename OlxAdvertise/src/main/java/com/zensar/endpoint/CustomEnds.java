package com.zensar.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
@Endpoint(id="custom")
@Component

public class CustomEnds {
	@ReadOperation
	public String myOwnEndpoint() {
		return "My  endpoint customised ";
		
	}
}
