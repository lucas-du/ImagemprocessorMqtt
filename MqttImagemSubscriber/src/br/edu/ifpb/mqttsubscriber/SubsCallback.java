package br.edu.ifpb.mqttsubscriber;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import br.edu.ifpb.imgdecode.Imagem;

public class SubsCallback implements MqttCallback{

	@Override
	public void connectionLost(Throwable cause) {
		System.out.println("Connection lost on instance\""+
				"\" with cause \""+
				cause.getMessage()+ "\" reason code"+
				((MqttException)cause).getReasonCode()+
				"\" cause \"" +
				((MqttException)cause).getCause()+
				"\" ");
		cause.printStackTrace();
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		Imagem img = new Imagem();
		boolean verificaconversor = false;
		verificaconversor = img.conversor(message.toString(), MqttConstants.LOCAL);
		
		if(verificaconversor){
			System.out.println("imagem recebida com sucesso");
		} else {
			System.out.println("erro ao receber imagem");
		}
	}

}
