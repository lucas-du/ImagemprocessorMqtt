package br.edu.ifpb.main;

import br.edu.ifpb.mqttsubscriber.Subscriber;

public class Main {

	public static void main(String[] args) {
		
		Subscriber sub = new Subscriber();
		
		sub.runner();
	}
}
