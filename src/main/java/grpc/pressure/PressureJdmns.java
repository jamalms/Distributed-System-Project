package grpc.pressure;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.pressure.Pressure;
import grpc.pressure.pressureGrpc.pressureImplBase;
import grpc.temperature.Temperature;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class PressureJdmns extends pressureImplBase{
	
	
	private static final Logger logger = Logger.getLogger(PressureJdmns.class.getName());
public static void main(String[] args) {
		
	PressureJdmns ourServer = new PressureJdmns ();
		
		int port = 50060;
		String service_type = "_grpc._tcp.local.Pressure";
		String service_name = "PressureService";
		PressureServiceRegistration PreSs = new PressureServiceRegistration();
		PreSs.run(port, service_type, service_name);
		
	    
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
	

		@Override
		public void roomPressure(checkPressure request, StreamObserver<PressureAlarm> responseObserver) {
			//Find out what was sent by the client
			float firstPressure = request.getFirstPressure();
			System.out.println("The Room Pressure is: " +firstPressure);
			PressureAlarm.Builder response = PressureAlarm.newBuilder();
			
			if(firstPressure != 64) {
				//return message
			response.setPressureAlarm("Pressure Alarm Is Activated \n" + "Alerts, Air Pressure out of the range");
			}
			else { //return message
				response.setPressureAlarm("The room pressure is NORMAL");
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}
		
		
	
}