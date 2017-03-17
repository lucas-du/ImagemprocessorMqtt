package br.edu.ifpb.imagem;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;

public class Imagem {
	
	public String Conversor(String local){
		
		File file = new File(local);
		String imagemString = null ;
		FileInputStream imagem;
		
		try {
			
			imagem = new FileInputStream(file);
			byte imagemData[] = new byte[(int) file.length()];
			imagem.read(imagemData);
			imagemString = encodeImagem(imagemData);
			imagem.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return imagemString;
		
		
		
	}

	private String encodeImagem(byte[] imagemData) {
		// TODO Auto-generated method stub
		return Base64.encodeBase64URLSafeString(imagemData);
	}

}
