package com.lti.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class HelloService {

	@GET
	//URL: http://localhost:8181/rest-app/api/hello
	//public String sayHello() {
	//URL: http://localhost:8181/rest-app/api/hello?name=Majrul
	//public String sayHello(@QueryParam("name") String name) {
	//URL: http://localhost:8181/rest-app/api/hello/Majrul
	@Path("/{name}/{age}") //http://localhost:8181/rest-app/api/hello/Majrul/40
	public String sayHello(@PathParam("name") String name, @PathParam("age") int age) {
		return "Hello " + name + " from JAX-RS. Your age is " + age;
	}
}
