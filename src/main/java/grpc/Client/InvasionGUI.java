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

import grpc.noise.noiseAlarm;
import grpc.noise.noiseGrpc;
import grpc.noise.noiseGrpc.noiseBlockingStub;
import grpc.pressure.pressureGrpc;
import grpc.pressure.pressureGrpc.pressureBlockingStub;
import grpc.temperature.*;
import grpc.temperature.temperatureGrpc.temperatureBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class InvasionGUI implements ActionListener{


	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private JTextField entry3, reply3;
	private JTextField entry4, reply4;


	private JPanel getTemperatureJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Temperature Service");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
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

		JButton button = new JButton("Invoke Pressure Service ");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
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

		JButton button = new JButton("Invoke Noise Service ");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 10);
		reply3 .setEditable(false);
		panel.add(reply3 );

		panel.setLayout(boxlayout);

		return panel;

	}

	

	
	public static void main(String[] args) {

		InvasionGUI gui = new InvasionGUI();

		gui.build();
	}

	private void build() { 

		JFrame frame = new JFrame("Secure Room Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		
		panel.add( getTemperatureJPanel() );
		panel.add( getPressureJPanel() );
		panel.add( getNoiseJPanel() );

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

		if (label.equals("Invoke Temperature Service ")) {
			System.out.println("Temperature service  to be invoked ...");

		
			/*
			 * 
			 */
			//ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			ManagedChannel newChannel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			//Service1Grpc.Service1BlockingStub blockingStub = Service1Grpc.newBlockingStub(channel);
			temperatureGrpc.temperatureBlockingStub tempStub = temperatureGrpc.newBlockingStub(newChannel);

			//preparing message to send
			//ds.service1.RequestMessage request1 = ds.service1.RequestMessage.newBuilder().setText(entry1.getText()).build();
			grpc.temperature.checkTemperature request = grpc.temperature.checkTemperature.newBuilder().setFirstTemperature(25).build();
			//checkTemperature roomTemp = checkTemperature.newBuilder().setFirstTemperature(entry1.getFirstTemperature).build();
			grpc.temperature.temperatureAlarm response = tempStub.sendTemperature(request);
			//retreving reply from service
			//ds.service1.ResponseMessage response = blockingStub.service1Do(request);

			reply1.setText( String.valueOf( response.getTempAlarm()) );
			
		}else if (label.equals("Invoke Noise Service ")) {
			System.out.println("service 2 to be invoked ...");

		
			/*
			 * 
			 */
			//int portNoise = 50052;
			//String host = "localhost";
			
			ManagedChannel newChannelNoise = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			noiseBlockingStub noiseStub = noiseGrpc.newBlockingStub(newChannelNoise);

			//preparing message to send
			grpc.noise.checkNoise request = grpc.noise.checkNoise .newBuilder().setFirstSound(0).build();

			//retreving reply from service
			//ds.service2.ResponseMessage response = blockingStub.service2Do(request);
			grpc.noise.noiseAlarm response = noiseStub.sound(request);
			reply3.setText( String.valueOf( response.getSoundAlarm()) );
			
		}else if (label.equals("Invoke Pressure Service ")) {
			System.out.println("service 3 to be invoked ...");

		
			/*
			 * 
			 */
			ManagedChannel newChannelPressure = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			pressureBlockingStub pressureStub = pressureGrpc.newBlockingStub(newChannelPressure);

			//preparing message to send
			grpc.pressure.checkPressure request = grpc.pressure.checkPressure.newBuilder().setFirstPressure(0).build();

			//retreving reply from service
			grpc.pressure.PressureAlarm response = pressureStub.roomPressure(request);

			reply2.setText( String.valueOf( response.getPressureAlarm()) );
		
		
		
		}else{
			
		}

	}

}
