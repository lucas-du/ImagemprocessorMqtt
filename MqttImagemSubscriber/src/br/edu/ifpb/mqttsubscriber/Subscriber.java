package br.edu.ifpb.mqttsubscriber;

import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

/**
 * 
 * @author lucas
 *
 */
public class Subscriber {
	
	public void runner(){
		try {
			
			// Cliente - MQTT
			MqttClient client = new MqttClient(MqttConstants.TCPADDRESS, MqttConstants.CLIENTID);
			
			// CallBack para tratamento das respostas.
			SubsCallback callback = new SubsCallback();
			client.setCallback(callback);
			
			// Opções de conexão
			MqttConnectOptions conOpitions = new MqttConnectOptions();
			conOpitions.setCleanSession(MqttConstants.CLEANSESSION);			
			conOpitions.setKeepAliveInterval(MqttConstants.KEEPALIVEINTERVAL);
			client.connect(conOpitions);
			
			// Escreve no tópico
			client.subscribe(MqttConstants.TCPIMAGEM, MqttConstants.QOS2);
			
			System.out.println("Press Q<Enter> to quit");
			
			Scanner scanner = new Scanner(System.in);
			
			for(String input =""; !input.equalsIgnoreCase("q"); input = scanner.nextLine() )getClass();
			
			
			client.disconnect();
			System.out.println("Subscriber ending");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
