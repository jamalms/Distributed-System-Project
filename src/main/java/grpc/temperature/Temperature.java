

package grpc.temperature;

import java.io.IOException;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import grpc.temperature.temperatureGrpc.temperatureImplBase;

public class Temperature  {
	private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Temperature ourServer = new Temperature();
		ourServer.start();

	}
	private void start() throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		int port = 50051;
		
		server = ServerBuilder.forPort(port).addService(new TempRoomImpl()).build().start();
		System.out.println("Server running on port: " +port);
		server.awaitTermination();
	}

	static class TempRoomImpl extends temperatureImplBase {

	public void sendTemperature(checkTemperature request, StreamObserver<temperatureAlarm> responseObserver) {
		

		//Find out what was sent by the client
		float firstTemperature = request.getFirstTemperature();
		System.out.println("The temperature is: " +firstTemperature);
		temperatureAlarm.Builder response = temperatureAlarm.newBuilder();
		
		if(firstTemperature >= 25) {
			//return message
		response.setTempAlarm("Temperature Alarm Is Activated \n" + "Alert, a human presence in room");
		
		}
		else {
			response.setTempAlarm("The temmperature is normal");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	
	
		
	}

	
	}
}