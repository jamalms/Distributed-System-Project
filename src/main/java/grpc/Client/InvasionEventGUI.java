package grpc.Client;


import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import grpc.invasionEvent.checkRoomStatus;
import grpc.invasionEvent.invasionAlarm;
import grpc.invasionEvent.invasionEventGrpc;
import grpc.invasionEvent.invasionEventGrpc.invasionEventBlockingStub;
import grpc.noise.noiseAlarm;
import grpc.noise.noiseGrpc;
import grpc.noise.noiseGrpc.noiseBlockingStub;
import grpc.pressure.pressureGrpc;
import grpc.pressure.pressureGrpc.pressureBlockingStub;
import grpc.temperature.*;
import grpc.temperature.checkTemperature.Builder;
import grpc.temperature.temperatureGrpc.temperatureBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class InvasionEventGUI implements ActionListener{


	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private JTextField entry3, reply3;
	


	private JPanel getTemperatureJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Send Temperature Value ");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 100);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getPressureJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("",10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Send Pressure Value ");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 100);
		reply2 .setEditable(false);
		panel.add(reply2 );

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getNoiseJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("",10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Send Noise Value ");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 100);
		reply3 .setEditable(false);
		panel.add(reply3 );

		panel.setLayout(boxlayout);

		return panel;

	}

	

	
	public static void main(String[] args) {

		InvasionEventGUI gui = new InvasionEventGUI();

		gui.build();
	}

	private void build() { 

		JFrame frame = new JFrame("Bidirectional Streaming Invasion Event");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		
		panel.add( getTemperatureJPanel() );
		panel.add( getNoiseJPanel() );
		panel.add( getPressureJPanel() );
		

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("Send Temperature Value ")) {
			System.out.println("Temperature service  to be invoked ...");
			
			
			/*
			 * 
			 */
			
			ManagedChannel newChannelInvasion = ManagedChannelBuilder.forAddress("host", 50054 ).usePlaintext().build();
			invasionEventBlockingStub bstub = invasionEventGrpc.newBlockingStub(newChannelInvasion);
			checkRoomStatus roomSta = checkRoomStatus.newBuilder().setFirstRoomTemperature(34).
					build();
			//newServiceBlockingStub bstub = newServiceGrpc.newBlockingStub(newChannel);
			//Builder request = invasionAlarm.newBuilder();
			checkRoomStatus.Builder request = checkRoomStatus.newBuilder(); 
				
					invasionAlarm.Builder response1 = invasionAlarm.newBuilder();
					
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
			//System.out.println("The Object Temperature is: "+ roomSta.getFirstRoomTemperature() + " " + response1);
			
			reply1.setText( String.valueOf(  response1) );
		}else if (label.equals("Send Noise Value ")) {
			System.out.println("service 2 to be invoked ...");

		
			/*
			 * 
			 */
		
			
			ManagedChannel newChannelInvasion = ManagedChannelBuilder.forAddress("host", 50054 ).usePlaintext().build();
			invasionEventBlockingStub bstub = invasionEventGrpc.newBlockingStub(newChannelInvasion);
			checkRoomStatus roomSta = checkRoomStatus.newBuilder().setFirstRoomSound(80)
					.build();
			invasionAlarm.Builder response = invasionAlarm.newBuilder();
		
			//Noise 
			//Builder firstRoomSound = response.setSoundIntensityAlarm("The Sound Intensity is: ");
			//System.out.println( firstRoomSound);
			
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
	//System.out.println("The Sound Intensity is: " + roomSta.getFirstRoomSound() +" " + response);
	
			reply3.setText( String.valueOf( response) );
			
		}else if (label.equals("Send Pressure Value ")) {
			System.out.println("service 3 to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel newChannelInvasion = ManagedChannelBuilder.forAddress("host", 50054 ).usePlaintext().build();
			invasionEventBlockingStub bstub = invasionEventGrpc.newBlockingStub(newChannelInvasion);
			checkRoomStatus roomSta = checkRoomStatus.newBuilder().
					setFirstRoomPressure(62)
					.build();
			
			invasionAlarm.Builder response2 = invasionAlarm.newBuilder();
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
			
			//System.out.println("The Air Room Pressure is: " + roomSta.getFirstRoomPressure() + " " + response2);
			

			reply2.setText( String.valueOf( response2) );
		
		
		
		}

	}

}
