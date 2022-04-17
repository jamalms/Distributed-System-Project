package grpc.Client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import grpc.invasionEvent.InvasionEvent;
import grpc.invasionEvent.InvasionServiceDiscovery;
import grpc.invasionEvent.checkRoomStatus;
import grpc.invasionEvent.invasionAlarm;
import grpc.invasionEvent.invasionAlarm.Builder;
import grpc.invasionEvent.invasionEventGrpc;
import grpc.invasionEvent.invasionEventGrpc.invasionEventBlockingStub;
import grpc.invasionEvent.invasionEventGrpc.invasionEventImplBase;
import grpc.temperature.TemperatureServiceDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class InvasionEventClient{
	private static final Logger logger = Logger.getLogger(InvasionEvent.class.getName());
	public static void main(String[] args) throws Exception {
		
		

		ServiceInfo serviceInfo;
		String service_type = "_grpc._tcp.local.InvasionEvent";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = InvasionServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		//int port = 50051;
		
		
		ManagedChannel newChannelInvasion = ManagedChannelBuilder.forAddress(host, port ).usePlaintext().build();
		
		
		
		
		
		
		
		checkRoomStatus.Builder request = checkRoomStatus.newBuilder(); 
				invasionAlarm.Builder response = invasionAlarm.newBuilder();
				invasionAlarm.Builder response1 = invasionAlarm.newBuilder();
				invasionAlarm.Builder response2 = invasionAlarm.newBuilder();
				
				try {
				checkRoomStatus roomSta = checkRoomStatus.newBuilder().setFirstRoomSound(80).setFirstRoomTemperature(23).
						setFirstRoomPressure(62)
						.build();
				//Noise
				
				float firstRoomSound = roomSta.getFirstRoomSound();
				//System.out.println("The Sound Intensity is: " +firstRoomSound + response.getSoundIntensityAlarm());
				
				
				if(firstRoomSound >= 45) {
					//return message
				response.setSoundIntensityAlarm("Noise Alarm Is Activated. " + "Alerts, Human Presence, High noise intensity");
				}
				else { //return message
					response.setSoundIntensityAlarm("No noise is found");
				}
				logger.info("The Noise Intensity: " + response.getSoundIntensityAlarm());
				
		System.out.println("The Sound Intensity is: " + roomSta.getFirstRoomSound() +" " + response);
				
				
				
		//Temperature
		float firstRoomTemperature = roomSta.getFirstRoomTemperature();
		//System.out.println("The Temperature is: " +firstRoomTemperature);
		//invasionAlarm.Builder response = invasionAlarm.newBuilder();
		
		if(firstRoomTemperature > 25) {
			//return message
		response1.setObjectTempAlarm("Temperature Alarm Is Activated. Alerts, Human Presence");
		}
		else { //return message
			response1.setObjectTempAlarm("The temmperature is normal");
		}
		logger.info("Temperature: " + response1.getObjectTempAlarm());
		System.out.println("The Object Temperature is: "+ roomSta.getFirstRoomTemperature() + " " + response1);
		
		//Room Pressure
		float firstRoomPressure = roomSta.getFirstRoomPressure();
		//System.out.println("The Room Pressure is: " +firstRoomPressure);
		//invasionAlarm.Builder response = invasionAlarm.newBuilder();
		
		if(firstRoomPressure  != 63.21) {
			//return message
		response2.setAirPressureAlarm("Pressure Alarm Is Activated." + "Alerts, Air Pressure out of the range");
		}
		else { //return message
			response2.setAirPressureAlarm("The room pressure is NORMAL");
		}
		logger.info("Air pressure: " + response2.getAirPressureAlarm());
		System.out.println("The Air Room Pressure is: " + roomSta.getFirstRoomPressure() + " " + response2);
	}
		catch(StatusRuntimeException e) { logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
	    
	    return;}
		
		//newChannelInvasion.shutdown().awaitTermination(20, TimeUnit.SECONDS);
				finally{//shutdown channel
			    	newChannelInvasion.shutdown().awaitTermination(5, TimeUnit.SECONDS);}
		

	}
	
}
class InvasionEventImpl extends invasionEventImplBase {
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
	checkRoomStatus roomSta = checkRoomStatus.newBuilder().setFirstRoomSound(49).setFirstRoomTemperature(27).
			setFirstRoomPressure(48)
			.build();
	System.out.println("The Sound Intensity is: " + roomSta.getFirstRoomSound()+ response.getSoundIntensityAlarm());
	System.out.println("The Air Room Pressure is: " + roomSta.getFirstRoomPressure());
	System.out.println("The Object Temperature is: " + roomSta.getFirstRoomTemperature());
	responseObserver.onNext(response.build());
	responseObserver.onCompleted();
	
}
}