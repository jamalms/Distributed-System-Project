package grpc.pressure;

import java.io.IOException;


import grpc.pressure.Pressure;
import grpc.pressure.pressureGrpc.pressureImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Pressure{
	private Server server;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Pressure ourServer = new Pressure();
		ourServer.start();

	}
	
	private void start() throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		int port = 50053;
		
		server = ServerBuilder.forPort(port).addService(new PressureRoomImpl()).build().start();
		System.out.println("Server running on port: " +port);
		server.awaitTermination();
	}
	
	static class PressureRoomImpl extends pressureImplBase{

		@Override
		public void roomPressure(checkPressure request, StreamObserver<PressureAlarm> responseObserver) {
			//Find out what was sent by the client
			float firstPressure = request.getFirstPressure();
			System.out.println("The Room Pressure is: " +firstPressure);
			PressureAlarm.Builder response = PressureAlarm.newBuilder();
			
			if(firstPressure != 63.21) {
				//return message
			response.setPressureAlarm("Pressure Alarm Is Activated \n" + "Alerts, Air Pressure out of the range");
			}
			else { //return message
				response.setPressureAlarm("The room pressure is NORMAL");
			}
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}
		
		
	}
}