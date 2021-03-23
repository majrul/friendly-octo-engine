package com.lti.ws;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.lti.model.Passenger;
import com.lti.model.Passenger.Gender;
import com.lti.model.Passenger.Status;
import com.lti.model.PnrStatus;

//assume that we are working for IRCTC
@Path("/pnr")
public class PnrService {

	@GET
	public PnrStatus check(@QueryParam("pnrNo") int pnrNo, @Context HttpServletResponse response) {
		//enabling support for CORS
		response.setHeader("Access-Control-Allow-Origin", "*");
		//System.out.println("inside check..");
		//for the time being we will return some hardcoded data
		//in an actual application, we will access the other classes in our application
		PnrStatus pnrStatus = new PnrStatus();
		pnrStatus.setPnrNo(pnrNo);
		pnrStatus.setTrainNo(12345);
		pnrStatus.setTravelDate(LocalDate.of(2021, 3, 20));
		
		List<Passenger> passengers = new ArrayList<>();
		Passenger p1 = new Passenger();
		p1.setName("Majrul");
		p1.setGender(Gender.MALE);
		p1.setStatus(Status.RAC);
		Passenger p2 = new Passenger();
		p2.setName("Dinesh");
		p2.setGender(Gender.MALE);
		p2.setStatus(Status.CONFIRMED);
		
		passengers.add(p1);
		passengers.add(p2);
		pnrStatus.setPassengers(passengers);
		
		return pnrStatus;
	}
}
