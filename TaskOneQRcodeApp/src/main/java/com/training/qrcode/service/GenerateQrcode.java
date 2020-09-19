package com.training.qrcode.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.training.qrcode.model.QrcodeDetails;

public class GenerateQrcode {
	
	private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";
	
	@Autowired
	QrcodeDetails details;
	public static BufferedImage generateQrcode(String text, int width, int height ) {
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	        
	    ////////////////for saving QR image to a local folder////////////    	
	    //    Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH);
	    //    MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	    //    System.out.println("QR code generation successful............. and saved in floder location");
	    /////////////////////////////////////////////////////////////////
	        
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
	public static String getQRcodeDetails(String qrname) throws Exception {
		
		BufferedImage qrcodeimage = GenerateQrcode.generateQrcode(qrname, 350, 350);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ImageIO.write( qrcodeimage, "jpg", baos );
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByte);
		baos.close();
		
		return b64;
	}
	
}


