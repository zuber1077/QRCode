package com.qrcode.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class ReadQRCode {

	public static void main(String[] args) throws Exception {
		File file = new File("/Users/air/Desktop/QrCode/qrcode.png");

		BufferedImage bufferedImage = ImageIO.read(file);

		QRCodeDecoder codeDecoder = new QRCodeDecoder();

		String result = new String(codeDecoder.decode(new MYQRCodeImage(bufferedImage)), "gb2312");
		
		System.out.println(result);
	}

}
