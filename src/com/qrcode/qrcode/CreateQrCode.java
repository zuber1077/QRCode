package com.qrcode.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class CreateQrCode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Qrcode x = new Qrcode();
		x.setQrcodeErrorCorrect('M'); // Error correction Level
		x.setQrcodeEncodeMode('B'); // N stand for numbers, A fir a-2, B for other characters
		x.setQrcodeVersion(7);
		String qrData = "zuber1077.github.io";
		int width = 67 + 12 * (7 - 1);
		int height = 67 + 12 * (7 - 1);

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D gs = bufferedImage.createGraphics();

		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);

		int pixoff = 2; // Offset

		byte[] d = qrData.getBytes("gb2312");

		if (d.length > 0 && d.length < 120) {
			boolean[][] s = x.calQrcode(d);

			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}
		}

		gs.dispose();
		bufferedImage.flush();

		try {
			ImageIO.write(bufferedImage, "png", new File("/Users/air/Desktop/QrCode/qrcode.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
