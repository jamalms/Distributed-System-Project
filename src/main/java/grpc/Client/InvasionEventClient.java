package grpc.Client;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import grpc.invasionEvent.InvasionEvent;
import grpc.invasionEvent.checkRoomStatus;
import grpc.invasionEvent.invasionAlarm;
import grpc.invasionEvent.invasionAlarm.Builder;
import grpc.invasionEvent.invasionEventGrpc;
import grpc.invasionEvent.invasionEventGrpc.invasionEventBlockingStub;
import grpc.invasionEvent.invasionEventGrpc.invasionEventImplBase;
import grpc.invasionEvent.invasionEventGrpc.invasionEventStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class InvasionEventClient{
	private static invasionEventBlockingStub blockingStub;
	private static invasionEventStub asyncStub;
	public static void main(String[] args) throws Exception {
		
		
		
		
		///////InvasionEvent
		//Build a channel
		int portInvasion = 50054;
		String host = "localhost";
		
		ManagedChannel newChannelInvasion = ManagedChannelBuilder.forAddress(host, portInvasion ).usePlaintext().build();
		
		//stubs -- generate from proto
		blockingStub = invasionEventGrpc.newBlockingStub(newChannelInvasion);

		asyncStub = invasionEventGrpc.newStub(newChannelInvasion);
	
		RoomStatus();
		

	}
	

/*
public void RoomStatus(checkRoomStatus request, StreamObserver<invasionAlarm> responseObserver) {
		
}*/
	
public static void RoomStatus() throws InterruptedException {
	//checkRoomStatus request, StreamObserver<invasionAlarm> responseObserver
	StreamObserver<invasionAlarm> responseObserver = new StreamObserver<invasionAlarm>() {

		@Override
		public void onNext(invasionAlarm value) {
			System.out.println("The Sound Intensity is: " + value.getSoundIntensityAlarm() +" "
		+ value.getObjectTempAlarm() + " " + value.getAirPressureAlarm());
			
	
			
		}

		@Override
		public void onError(Throwable t) {
			t.printStackTrace();

		}

		@Override
		public void onCompleted() {
			System.out.println("stream is completed ... received ");
			
		}};
		
		StreamObserver<checkRoomStatus> requestObserver = asyncStub.roomStatus(responseObserver);
		
		try {
			checkRoomStatus roomSta = checkRoomStatus.newBuilder().setFirstRoomSound(80).setFirstRoomTemperature(23).
					setFirstRoomPressure(62)
					.build();
			// Mark the end of requests
						requestObserver.onCompleted();


						// Sleep for a bit before sending the next one.
						Thread.sleep(new Random().nextInt(1000) + 500);
			
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}


}