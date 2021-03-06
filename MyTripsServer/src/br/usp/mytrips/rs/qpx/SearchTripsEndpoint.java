package br.usp.mytrips.rs.qpx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

import br.usp.mytrips.rs.qpx.entities.QPXResponse;
import br.usp.mytrips.rs.qpx.request.Passenger;
import br.usp.mytrips.rs.qpx.request.QPXRequest;
import br.usp.mytrips.rs.qpx.request.Request;
import br.usp.mytrips.rs.qpx.request.Slice;

public class SearchTripsEndpoint {

	public static String testSearchTripsEndpoint() {
		/*WebClient webClient = WebClient.create("https://www.googleapis.com");
        webClient.accept(MediaType.APPLICATION_JSON);
        webClient.type(MediaType.APPLICATION_JSON);
        
        Gson gson = new Gson();
        
        QPXRequest qpxreq = new QPXRequest();
        qpxreq.setMaxPrice("GBP5000");
        
        Response r = webClient.path("qpxExpress/v1/trips/search?key=AIzaSyAm9JhpnhWE0-K3lsqC5m4AB45qJRZCtnA").post(gson.toJson(qpxreq));
        
        String jsonString = gson.toJson((String)r);
        
        QPXResponse qpxres = gson.fromJson(jsonString, QPXResponse.class);
        
        return qpxres.getTrips().getRequestId();*/
		try {
			
			Gson gson = new Gson();
			
			QPXRequest qpxreq = new QPXRequest();
			Request req = new Request();
			
			Passenger passenger = new Passenger();
			passenger.setAdultCount(1);
			
			Slice s1 = new Slice();
			s1.setOrigin("BOS");
			s1.setDestination("LAX");
			s1.setDate("2016-09-19");
			
	        //qpxreq.setMaxPrice("GBP5000");
			req.setPassengers(passenger);
			req.setSlice(new Slice[] { s1 });
			req.setSolutions(1);
			
			qpxreq.setRequest(req);
	        
			// create HTTP Client
			HttpClient httpClient = HttpClientBuilder.create().build();
 
			// Create new getRequest with below mentioned URL
			HttpPost getRequest = new HttpPost("https://www.googleapis.com/qpxExpress/v1/trips/search?key=AIzaSyAm9JhpnhWE0-K3lsqC5m4AB45qJRZCtnA");
 
			// Add additional header to getRequest which accepts application/xml data
			getRequest.addHeader("accept", "application/json");
 
			StringEntity requestEntity = new StringEntity(
					gson.toJson(qpxreq),
				    ContentType.APPLICATION_JSON);
			
			getRequest.setEntity(requestEntity);
			
			// Execute your request and catch response
			HttpResponse response = httpClient.execute(getRequest);
 
			// Check for HTTP response code: 200 = success
			if (response.getStatusLine().getStatusCode() != 200) {
				//throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
 
			// Get-Capture Complete application/xml body response
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			String outputFinal = "";
			//System.out.println("============Output:============");
 
			// Simply iterate through XML response and show on console.
			while ((output = br.readLine()) != null) {
				outputFinal += output;
			}
			
			//return gson.toJson(qpxreq);
			
			QPXResponse qpxres = gson.fromJson(outputFinal, QPXResponse.class);
			
			return outputFinal;
 
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
