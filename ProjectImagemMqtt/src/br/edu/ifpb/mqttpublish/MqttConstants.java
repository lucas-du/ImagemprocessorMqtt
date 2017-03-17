package br.edu.ifpb.mqttpublish;

import br.edu.ifpb.imagem.Imagem;

public final class MqttConstants {
	
	public static final String 	TCPADDRESS ="tcp://127.0.0.1:1883";
	public static final String CLIENTID ="testClientid";
	public static final int SLEEPTIMEOUT = 10000;
	public static final String FILE ="/home/lucas/Imagens/";
	public static final int QOS2 = 2;
	public static final boolean RETAINED = false;
	//public  final static String IMAGEM = getStringImagem(FILE);
	public static final String TCPIMAGEM = "imagem/test";
	
	
	public final static String getStringImagem(String file, String Matricula){
		
		Imagem img = new Imagem();
		
		String imgString = null;
		
		try {
			imgString =img.Conversor(file,Matricula);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return imgString;
	}
	

}
