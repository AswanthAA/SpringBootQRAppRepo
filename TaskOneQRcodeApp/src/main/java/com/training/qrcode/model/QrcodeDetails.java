package com.training.qrcode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QrcodeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String qrname;
	private String base64image;
	
	
	public String getBase64image() {
		return base64image;
	}
	public void setBase64image(String base64image) {
		this.base64image = base64image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQrname() {
		return qrname;
	}
	public void setQrname(String qrname) {
		this.qrname = qrname;
	}
	

}


