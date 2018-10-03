package com.example.beans;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class EmployeeServiceResource {
	
	public EmployeeServiceResource() {
	}

	@GET
	@Path("/employees/{name}/")
	public String getCustomer(@PathParam("name") String name) {
		return "Ejemplo";
	}


}
