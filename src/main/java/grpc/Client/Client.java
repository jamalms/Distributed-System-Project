package grpc.Client;




import java.util.concurrent.TimeUnit;

import grpc.invasionEvent.checkRoomStatus;
import grpc.invasionEvent.invasionAlarm;
import grpc.noise.checkNoise;
import grpc.noise.noiseAlarm;
import grpc.noise.noiseGrpc;
import grpc.noise.noiseGrpc.noiseBlockingStub;
import grpc.pressure.PressureAlarm;
import grpc.pressure.checkPressure;
import grpc.pressure.pressureGrpc;
import grpc.pressure.pressureGrpc.pressureBlockingStub;
import grpc.temperature.checkTemperature;
import grpc.temperature.temperatureAlarm;
import grpc.temperature.temperatureGrpc;
import grpc.temperature.temperatureGrpc.temperatureBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client{
	
	public static void main(String[] args) throws Exception {
		
		
		//Build a channel
		int port = 50051;
		String host = "localhost";
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//containsString cString = containsString.newBuilder().setFirstString("test1").build();
		checkTemperature roomTemp = checkTemperature.newBuilder().setFirstTemperature(23).build();
		//newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		temperatureBlockingStub tempStub = temperatureGrpc.newBlockingStub(newChannel);
		
		//containsString response = bstub.getFirstString(cString);
		temperatureAlarm response = tempStub.sendTemperature(roomTemp);
	System.out.println(response.getTempAlarm());
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
		///////Noise
		//Build a channel
		int portNoise = 50052;
		//String host = "localhost";
		
		ManagedChannel newChannelNoise = ManagedChannelBuilder.forAddress(host, portNoise).usePlaintext().build();
		
		//containsString cString = containsString.newBuilder().setFirstString("test1").build();
		checkNoise roomNoise = checkNoise.newBuilder().setFirstSound(49).build();
		//newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		noiseBlockingStub noiseStub = noiseGrpc.newBlockingStub(newChannelNoise);
		
		//containsString response = bstub.getFirstString(cString);
		noiseAlarm noiseResponse = noiseStub.sound(roomNoise);
	System.out.println(noiseResponse.getSoundAlarm());
		
	newChannelNoise.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	
///////Pressure
		//Build a channel
		int portPressure = 50053;
		//String host = "localhost";
		
		ManagedChannel newChannelPressure = ManagedChannelBuilder.forAddress(host, portPressure).usePlaintext().build();
		
		//containsString cString = containsString.newBuilder().setFirstString("test1").build();
		checkPressure roomPres = checkPressure.newBuilder().setFirstPressure(40).build();
		//newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		pressureBlockingStub pressureStub = pressureGrpc.newBlockingStub(newChannelPressure);
		
		//containsString response = bstub.getFirstString(cString);
		PressureAlarm pressureResponse = pressureStub.roomPressure(roomPres);
	System.out.println(pressureResponse.getPressureAlarm());
		
	newChannelPressure.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	

	///////InvasionEvent
	//Build a channel
	int portInvasion = 50054;
	//String host = "localhost";
	
	ManagedChannel newChannelInvasion = ManagedChannelBuilder.forAddress(host, portInvasion ).usePlaintext().build();
	
	//containsString cString = containsString.newBuilder().setFirstString("test1").build();
	checkRoomStatus roomSta = checkRoomStatus.newBuilder().setFirstRoomSound(80).setFirstRoomTemperature(23).
			setFirstRoomPressure(62)
			.build();
	
	
	//newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
	//Builder request = invasionAlarm.newBuilder();
	checkRoomStatus.Builder request = checkRoomStatus.newBuilder(); 
			invasionAlarm.Builder response0 = invasionAlarm.newBuilder();
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
			response0.setSoundIntensityAlarm("Noise Alarm Is Activated. " + "Alerts, Human Presence, High noise intensity");
			}
			else { //return message
				response0.setSoundIntensityAlarm("No noise is found");
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