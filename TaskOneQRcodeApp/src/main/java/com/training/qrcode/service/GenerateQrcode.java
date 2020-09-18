package com.training.qrcode.service;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.commons.io.IOUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GenerateQrcode {
	
	public static BufferedImage generateQrcode(String text, int width, int height, String filePath ) {
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

	        Path path = FileSystems.getDefault().getPath(filePath);
	        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	        
	        System.out.println("QR code generation successful............. and saved in floder location");
	        
	        /////////////////////////////////////////
	        BufferedImage qr = MatrixToImageWriter.toBufferedImage(bitMatrix);
	        
	        //////////////////////////////////
	        
//	        InputStream in = GenerateQrcode.class.getResourceAsStream("./MyQRCode");
//	        return IOUtils.toByteArray(in);
	        
	        return qr;
			}
			catch(Exception e){
			System.out.println("Could not generate QR Code, " + e);
			return null;
			}
	
	}
}


