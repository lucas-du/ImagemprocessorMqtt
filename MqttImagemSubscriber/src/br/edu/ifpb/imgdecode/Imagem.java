package br.edu.ifpb.imgdecode;

import java.io.FileOutputStream;

import org.apache.commons.codec.binary.Base64;

public class Imagem {
	
	public boolean conversor(String imgString, String file){
		
		byte[] imagembyte = null;
		
		try {
			
			imagembyte = decodeImagem(imgString);
			
			FileOutputStream imgemout = new FileOutputStream(file);
			
			imgemout.write(imagembyte);
			
			imgemout.close();
			
			
			
		} catch (Exception e) {
			//TODO: tratar exceções e adicionar a classe Logger
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}

	private byte[] decodeImagem(String imgString) {
		
		return Base64.decodeBase64(imgString);
	}

}
