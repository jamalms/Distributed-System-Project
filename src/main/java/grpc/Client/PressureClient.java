package grpc.Client;

import java.util.concurrent.TimeUnit;


import grpc.pressure.PressureAlarm;
import grpc.pressure.checkPressure;
import grpc.pressure.pressureGrpc;
import grpc.pressure.pressureGrpc.pressureBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PressureClient{
	
	public static void main(String[] args) throws Exception {
		
		
		
		
		///////Pressure
		//Build a channel
		int portPressure = 50053;
		String host = "localhost";
		
		ManagedChannel newChannelPressure = ManagedChannelBuilder.forAddress(host, portPressure).usePlaintext().build();
		
		//containsString cString = containsString.newBuilder().setFirstString("test1").build();
		checkPressure roomPres = checkPressure.newBuilder().setFirstPressure(40).build();
		//newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
		pressureBlockingStub pressureStub = pressureGrpc.newBlockingStub(newChannelPressure);
		
		//containsString response = bstub.getFirstString(cString);
		PressureAlarm pressureResponse = pressureStub.roomPressure(roomPres);
	System.out.println(pressureResponse.getPressureAlarm());
		
	newChannelPressure.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
}