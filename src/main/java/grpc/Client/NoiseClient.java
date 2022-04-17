package grpc.Client;




import java.util.concurrent.TimeUnit;

import grpc.noise.checkNoise;
import grpc.noise.noiseAlarm;
import grpc.noise.noiseGrpc;
import grpc.noise.noiseGrpc.noiseBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NoiseClient{
	
	public static void main(String[] args) throws Exception {
		
		
		
		
		///////Noise
		//Build a channel
		int portNoise = 50052;
		String host = "localhost";
		
		ManagedChannel newChannelNoise = ManagedChannelBuilder.forAddress(host, portNoise).usePlaintext().build();
		
		//containsString cString = containsString.newBuilder().setFirstString("test1").build();
		checkNoise roomNoise = checkNoise.newBuilder().setFirstSound(49).build();
		//newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		noiseBlockingStub noiseStub = noiseGrpc.newBlockingStub(newChannelNoise);
		
		//containsString response = bstub.getFirstString(cString);
		noiseAlarm noiseResponse = noiseStub.sound(roomNoise);
	System.out.println(noiseResponse.getSoundAlarm());
		
	newChannelNoise.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
}