package grpc.Client;




import java.util.concurrent.TimeUnit;

import grpc.noise.checkNoise;
import grpc.noise.noiseAlarm;
import grpc.noise.noiseGrpc;
import grpc.noise.noiseGrpc.noiseBlockingStub;
import grpc.temperature.checkTemperature;
import grpc.temperature.temperatureAlarm;
import grpc.temperature.temperatureGrpc;
import grpc.temperature.temperatureGrpc.temperatureBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TemperatureClient{
	
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
		
		
	}
}