package grpc.noise;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.noise.Noise;

import grpc.noise.noiseGrpc.noiseImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class NoiseJdmns extends noiseImplBase{
	

private static final Logger logger = Logger.getLogger(Noise.class.getName());
public static void main(String[] args) {
		
		NoiseJdmns ourNoiseServer = new NoiseJdmns ();
		
		int port = 50061;
		String service_type = "_grpc._tcp.local.Noise";
		String service_name = "NoiseService";
		NoiseServiceRegistration noiseSs = new NoiseServiceRegistration();
		noiseSs.run(port, service_type, service_name);
		
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(ourNoiseServer)
			    .build()
			    .start();
			System.out.println("\nServer V1.2 Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    logger.info("Server started, listening on " + port);
	    		    
	}
	

		public void sound(checkNoise request, StreamObserver<noiseAlarm> responseObserver) {
			
			//Find out what was sent by the client
			float firstSound = request.getFirstSound();
			System.out.println("The Room voise is: " +firstSound);
			noiseAlarm.Builder response = noiseAlarm.newBuilder();
			
			if(firstSound >= 45) {
				//return message
			response.setSoundAlarm("Noise Alarm Is Activated \n" + "Alerts, Human Presence, High noise intensity");
			}
			else { //return message
				response.setSoundAlarm("No noise is found");
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		
		}
		
		
		
	
}