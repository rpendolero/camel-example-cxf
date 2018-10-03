package com.example.java;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public interface CompanyService {
   @GET
   @Path("company/{id}")
   public String getCompany(@PathParam("id") String id);

   @GET
   @Path("company")
   public  String getCompanies();

   @PUT
   @Path("company/{id}")
   public String updateCompany(@PathParam("id") String id);

   @POST
   @Path("company")
   public  String createCompany(String data);

   @DELETE
   @Path("company/{id}")
   public  String deleteCompany(@PathParam("id") String id);
}
