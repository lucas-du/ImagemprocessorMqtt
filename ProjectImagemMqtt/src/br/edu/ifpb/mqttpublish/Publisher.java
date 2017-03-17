package br.edu.ifpb.mqttpublish;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

import br.edu.ifpb.imagem.CapImagem;



public class Publisher {
	
	public void publisherenviar(String Matricula){
		
		try {
			
			MqttClient client = new MqttClient(MqttConstants.TCPADDRESS, MqttConstants.CLIENTID);
			
			client.connect();
			
			//Inciando a captura de imagem
			CapImagem cap = new CapImagem();
			
			String foto = cap.takephoto(MqttConstants.FILE, Matricula);
			
			MqttTopic topic = client.getTopic(MqttConstants.TCPIMAGEM);
			
			MqttMessage message = new MqttMessage(MqttConstants.getStringImagem(foto, Matricula).getBytes());
			
			
			
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
