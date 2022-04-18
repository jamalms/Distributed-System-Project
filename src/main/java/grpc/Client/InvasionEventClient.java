package grpc.Client;

import java.util.concurrent.TimeUnit;

import grpc.invasionEvent.checkRoomStatus;
import grpc.invasionEvent.invasionAlarm;
import grpc.invasionEvent.invasionAlarm.Builder;
import grpc.invasionEvent.invasionEventGrpc;
import grpc.invasionEvent.invasionEventGrpc.invasionEventBlockingStub;
import grpc.invasionEvent.invasionEventGrpc.invasionEventImplBase;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class InvasionEventClient{
	
	public static void main(String[] args) throws Exception {
		
		
		
		
		///////InvasionEvent
		//Build a channel
		int portInvasion = 50054;
		String host = "localhost";
		
		ManagedChannel newChannelInvasion = ManagedChannelBuilder.forAddress(host, portInvasion ).usePlaintext().build();
		
		//containsString cString = containsString.newBuilder().setFirstString("test1").build();
		checkRoomStatus roomSta = checkRoomStatus.newBuilder().setFirstRoomSound(80).setFirstRoomTemperature(23).
				setFirstRoomPressure(62)
				.build();
		
		
		//newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		//Builder request = invasionAlarm.newBuilder();
		checkRoomStatus.Builder request = checkRoomStatus.newBuilder(); 
				invasionAlarm.Builder response = invasionAlarm.newBuilder();
				invasionAlarm.Builder response1 = invasionAlarm.newBuilder();
				invasionAlarm.Builder response2 = invasionAlarm.newBuilder();
				//Noise 
				//Builder firstRoomSound = response.setSoundIntensityAlarm("The Sound Intensity is: ");
				//System.out.println( firstRoomSound);
				
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
		
		System.out.println("The Air Room Pressure is: " + roomSta.getFirstRoomPressure() + " " + response2);
		
		//System.out.println("The Sound Intensity is: " + roomSta.getFirstRoomSound()+ firstRoomSound);
		//System.out.println("The Air Room Pressure is: " + roomSta.getFirstRoomPressure());
		//System.out.println("The Object Temperature is: " + roomSta.getFirstRoomTemperature());
		
		newChannelInvasion.shutdown().awaitTermination(20, TimeUnit.SECONDS);
	
		

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