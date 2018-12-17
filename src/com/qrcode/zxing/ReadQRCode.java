package com.qrcode.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadQRCode {

	public static void main(String[] args) {
		
		try {
			MultiFormatReader formatReader = new MultiFormatReader();
			
			File file = new File("/Users/air/Desktop/QrCode/img.png");
			
			BufferedImage image = ImageIO.read(file);
			
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			
			Result result = formatReader.decode(binaryBitmap, hints);
			
			System.out.println("Result: "+ result.toString());
			System.out.println("QRCode Format: "+ result.getBarcodeFormat());
			System.out.println("QRCode Text content: "+ result.getText());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
