package grpc.Client;




import java.util.concurrent.TimeUnit;

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
	}
}