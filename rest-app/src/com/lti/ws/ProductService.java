package com.lti.ws;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.lti.model.Product;
import com.lti.model.Status;

@Path("/product")
public class ProductService {

	@POST
	public Status add(Product product) {
		//ProductDao dao = new ProductDao();
		//dao.insert(product);
		
		Status status = new Status();
		status.setMessage("Product added successfully!!");
		return status;
	}
}
