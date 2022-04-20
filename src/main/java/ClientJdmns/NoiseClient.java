package ClientJdmns;




import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import grpc.noise.Noise;
import grpc.noise.NoiseServiceDiscovery;
import grpc.noise.checkNoise;
import grpc.noise.noiseAlarm;
import grpc.noise.noiseGrpc;
import grpc.noise.noiseGrpc.noiseBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class NoiseClient{
	
	private static final Logger logger = Logger.getLogger(Noise.class.getName());
	public static void main(String[] args) throws Exception {
		
		
		ServiceInfo serviceInfo;
		String service_type = "_grpc._tcp.local.Noise";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = NoiseServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		//int port = 50051;
		
		
		
		
		
		ManagedChannel newChannelNoise = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		
		//checkNoise roomNoise = checkNoise.newBuilder().setFirstSound(49).build();
		
		noiseBlockingStub noiseStub = noiseGrpc.newBlockingStub(newChannelNoise);
		try {
	    	 float firstSound = 45;
	    	 checkNoise roomNoise = checkNoise.newBuilder().setFirstSound(49).build();
	    	 
	    	 noiseAlarm noiseResponse = noiseStub.sound(roomNoise);
	    	 
	    	 logger.info("Noise Intensity: " + noiseResponse.getSoundAlarm());
	    	 
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	newChannelNoise.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	
		/*noiseAlarm noiseResponse = noiseStub.sound(roomNoise);
	System.out.println(noiseResponse.getSoundAlarm());
		
	newChannelNoise.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	*/
	}
}