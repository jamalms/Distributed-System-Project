package grpc.invasionEvent;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.invasionEvent.invasionEventGrpc.invasionEventImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class InvasionEventJdmns extends invasionEventImplBase{
	
	private static final Logger logger = Logger.getLogger(InvasionEvent.class.getName());
	
	public static void main(String[] args) throws InterruptedException, IOException {
		InvasionEventJdmns ourServer = new InvasionEventJdmns ();
		int port = 50064;
		String service_type = "_grpc._tcp.local.InvasionEvent";
		String service_name = "InvasionEvent";
		InvesionServiceRegistration invSs = new InvesionServiceRegistration();
		invSs.run(port, service_type, service_name);
		
	    
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
	
	static class InvasionEventImpl extends invasionEventImplBase {

		public void RoomStatus(checkRoomStatus request, StreamObserver<invasionAlarm> responseObserver) {
			invasionAlarm.Builder response = invasionAlarm.newBuilder();
			//Noise 
			float firstRoomSound = request.getFirstRoomSound();
			System.out.println("The Sound Intensity is: " +firstRoomSound);
			
			
			if(firstRoomSound >= 45) {
				//return message
			response.setSoundIntensityAlarm("Noise Alarm Is Activated \n" + "Alerts, Human Presence, High noise intensity");
			}
			else { //return message
				response.setSoundIntensityAlarm("No noise is found");
			}
			
			//Temperature
			float firstRoomTemperature = request.getFirstRoomTemperature();
			System.out.println("The Temperature is: " +firstRoomTemperature);
			//invasionAlarm.Builder response = invasionAlarm.newBuilder();
			
			if(firstRoomTemperature > 25) {
				//return message
			response.setObjectTempAlarm("Temperature Alarm Is Activated. Alerts, Human Presence");
			}
			else { //return message
				response.setObjectTempAlarm("The temmperature is normal");
			}
			
			//Room Pressure
			float firstRoomPressure = request.getFirstRoomPressure();
			System.out.println("The Room Pressure is: " +firstRoomPressure);
			//invasionAlarm.Builder response = invasionAlarm.newBuilder();
			
			if(firstRoomPressure  != 63.21) {
				//return message
			response.setAirPressureAlarm("Pressure Alarm Is Activated \n" + "Alerts, Air Pressure out of the range");
			}
			else { //return message
				response.setAirPressureAlarm("The room pressure is NORMAL");
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
			
			
			
		}///for RoomStatus
		
		
		
		
	}
	}
