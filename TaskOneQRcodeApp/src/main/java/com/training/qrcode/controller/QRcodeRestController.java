package com.training.qrcode.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.qrcode.model.QrcodeDetails;
import com.training.qrcode.service.GenerateQrcode;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class QRcodeRestController {
	
	@Autowired
	QrcodeDetails details;
	
	
	@GetMapping("/qrcodee/{qrname}")
	public QrcodeDetails  getQrcode(@PathVariable("qrname") String qrname)throws Exception {
		
		//System.out.println("//////"+qrname+"/////inside Rest getmapping/////////");
		details.setQrname(qrname);
		details.setBase64image(GenerateQrcode.getQRcodeDetails(qrname));
	    return details;
	}
	
}
