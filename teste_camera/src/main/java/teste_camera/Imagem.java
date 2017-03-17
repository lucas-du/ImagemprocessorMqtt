package teste_camera;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class Imagem {
	
	
	public static void main(String[] args) throws IOException {
		Webcam webcan = Webcam.getDefault();
		
		webcan.open();
		
		BufferedImage image = webcan.getImage();
		
		ImageIO.write(image, "JPEG", new File("C:\\Users\\lucas\\test.jpeg"));
	}

}
