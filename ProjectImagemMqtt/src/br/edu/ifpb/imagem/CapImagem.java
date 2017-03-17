package br.edu.ifpb.imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class CapImagem {
	
	public String takephoto(String file, String matricula) throws IOException{
		String photo = file +"/"+ matricula+".jpeg";
		
		Webcam web = Webcam.getDefault();
		
		BufferedImage imagem = web.getImage();
		
		ImageIO.write(imagem, "jpeg", new File(photo));
		
		return photo;
	}

}
