

package grpc.temperature;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import grpc.temperature.temperatureGrpc.temperatureImplBase;

public class Temperature extends temperatureImplBase  {
	private static final Logger logger = Logger.getLogger(Temperature.class.getName());
public static void main(String[] args) {
		
		Temperature ourServer = new Temperature();
		
		int port = 50059;
		String service_type = "_grpc._tcp.local.";
		String service_name = "TemperatureService";
		TemperatureServiceRegistration tempSs = new TemperatureServiceRegistration();
		tempSs.run(port, service_type, service_name);
		
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(ourServer)
			    .build()
			    .start();
			System.out.println("\nServer V1.2 Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    logger.info("Server started, listening on " + port);
	    		    
	}
	

	public void sendTemperature(checkTemperature request, StreamObserver<temperatureAlarm> responseObserver) {
		

		//Find out what was sent by the client
		float firstTemperature = request.getFirstTemperature();
		System.out.println("The temperature is: " +firstTemperature);
		temperatureAlarm.Builder response = temperatureAlarm.newBuilder();
		
		if(firstTemperature > 25) {
			//return message
		response.setTempAlarm("Temperature Alarm Is Activated. Alerts, Human Presence");
		}
		else {
			response.setTempAlarm("The temmperature is normal");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	
	
		
	}

	
	}
