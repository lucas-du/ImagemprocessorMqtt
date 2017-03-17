package br.edu.ifpb.mqttpublish;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;



public class Publisher {
	
	public void publisherenviar(String file){
		
		try {
			
			MqttClient client = new MqttClient(MqttConstants.TCPADDRESS, MqttConstants.CLIENTID);
			
			client.connect();
			
			MqttTopic topic = client.getTopic(MqttConstants.TCPIMAGEM);
			
			MqttMessage message = new MqttMessage(MqttConstants.getStringImagem(file).getBytes());
			
			message.setQos(MqttConstants.QOS2);
			
			System.out.println("waiting for up to" +
					MqttConstants.SLEEPTIMEOUT/1000+
					" seconds for publication of \""+
					message.toString() + " \" with QoS = " + message.getQos() );
			
			System.out.println("On topic \"" +topic.getName() +
					   "\" for client instance: \"" + 
					   client.getClientId() + "\" on address "+
					   client.getServerURI()+"\"");
			
			MqttDeliveryToken token = topic.publish(message);
			
			
			token.waitForCompletion(MqttConstants.SLEEPTIMEOUT);
			
			System.out.println("Devivery token \""+
					token.hashCode()+"\" has received:" +
					token.isComplete());

			client.disconnect();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
