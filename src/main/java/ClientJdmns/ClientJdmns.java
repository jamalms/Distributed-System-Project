package ClientJdmns;




import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import grpc.invasionEvent.InvasionEvent;
import grpc.invasionEvent.InvasionServiceDiscovery;
import grpc.invasionEvent.checkRoomStatus;
import grpc.invasionEvent.invasionAlarm;
import grpc.noise.NoiseServiceDiscovery;
import grpc.noise.checkNoise;
import grpc.noise.noiseAlarm;
import grpc.noise.noiseGrpc;
import grpc.noise.noiseGrpc.noiseBlockingStub;
import grpc.pressure.PressureAlarm;
import grpc.pressure.PressureServiceDiscovery;
import grpc.pressure.checkPressure;
import grpc.pressure.pressureGrpc;
import grpc.pressure.pressureGrpc.pressureBlockingStub;
import grpc.temperature.TemperatureDiscovery;
import grpc.temperature.checkTemperature;
import grpc.temperature.temperatureAlarm;
import grpc.temperature.temperatureGrpc;
import grpc.temperature.temperatureGrpc.temperatureBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class ClientJdmns{
	private static final Logger logger = Logger.getLogger(InvasionEvent.class.getName());
	public static void main(String[] args) throws Exception {
		
		ServiceInfo serviceInfo;
		String service_type = "_grpc._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = TemperatureDiscovery.run(service_type);
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
	    
	    //pressure
		ServiceInfo serviceInfoPress;
		String service_typePress = "_grpc._tcp.local.Pressure";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = PressureServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int portPress = serviceInfo.getPort();
		String hostPress = "localhost";
		//int port = 50051;
		
		ManagedChannel pressureNewChannel = ManagedChannelBuilder.
				forAddress(hostPress, portPress)
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
	    
	    //Noise
		ServiceInfo serviceInfoNoise;
		String service_typeNoise = "_grpc._tcp.local.Noise";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = NoiseServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int portNoise = serviceInfo.getPort();
		String hostNoise = "localhost";
		//int port = 50051;
		
		
		
		
		
		ManagedChannel newChannelNoise = ManagedChannelBuilder.forAddress(hostNoise, portNoise).usePlaintext().build();
		
		
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
		
		
		//InvasionEvent

		ServiceInfo serviceInfoInvasion;
		String service_typeInvasion = "_grpc._tcp.local.InvasionEvent";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = InvasionServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int portInvasion = serviceInfo.getPort();
		String hostInvasion = "localhost";
		//int port = 50051;
		
		
		ManagedChannel newChannelInvasion = ManagedChannelBuilder.forAddress(hostInvasion, portInvasion ).usePlaintext().build();
		
		
		
		
		
		
		
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
			    	newChannelInvasion.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			    	}
		

	    
   
	  }//main method
	
	}//main class
