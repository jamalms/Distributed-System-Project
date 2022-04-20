package ClientJdmns;




import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import grpc.pressure.PressureAlarm;
import grpc.pressure.PressureServiceDiscovery;
import grpc.pressure.checkPressure;
import grpc.pressure.pressureGrpc;
import grpc.pressure.pressureGrpc.pressureBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class PressureClient {

	private static final Logger logger = Logger.getLogger(PressureClient.class.getName());

		  
	public static void main(String[] args) throws Exception {
		
		ServiceInfo serviceInfo;
		String service_type = "_grpc._tcp.local.Pressure";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = PressureServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		//int port = 50051;
		
		ManagedChannel pressureNewChannel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		///checkTemperature roomTemp = checkTemperature.newBuilder().setFirstTemperature(34).build();
		
		pressureBlockingStub pressStub = pressureGrpc.newBlockingStub(pressureNewChannel);
	    
	    try {
	    	 float firstPressure =  64;
	    	 checkPressure roomPres = checkPressure.newBuilder().setFirstPressure(40).build();
	    	 
	    	 PressureAlarm pressureResponse = pressStub.roomPressure(roomPres);
	    	 
	    	 logger.info("Air Pressure: " + pressureResponse.getPressureAlarm());
	    	 
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	pressureNewChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }
	
	
}
