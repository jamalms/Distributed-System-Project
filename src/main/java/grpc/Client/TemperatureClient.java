package grpc.Client;




import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;


import grpc.temperature.TemperatureServiceDiscovery;
import grpc.temperature.checkTemperature;
import grpc.temperature.temperatureAlarm;
import grpc.temperature.temperatureGrpc;
import grpc.temperature.temperatureGrpc.temperatureBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class TemperatureClient {

	private static final Logger logger = Logger.getLogger(TemperatureClient.class.getName());

		  
	public static void main(String[] args) throws Exception {
		
		ServiceInfo serviceInfo;
		String service_type = "_grpc._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = TemperatureServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		//int port = 50051;
		
		ManagedChannel newChannel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		///checkTemperature roomTemp = checkTemperature.newBuilder().setFirstTemperature(34).build();
		
		temperatureBlockingStub tempStub = temperatureGrpc.newBlockingStub(newChannel);
	    
	    try {
	    	 float firstTemperature = 28;
	    	 checkTemperature roomTemp = checkTemperature.newBuilder().setFirstTemperature(34).build();
	    	 
	    	 temperatureAlarm response = tempStub.sendTemperature(roomTemp);
	    	 
	    	 logger.info("Temperature: " + response.getTempAlarm());
	    	 
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }
	
	
}
