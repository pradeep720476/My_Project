package com.mypharamacy.entity;

import javax.persistence.Lob;

public class Presciption {

	private int docId;
	@Lob
	private byte[] image;

	public Presciption(byte[] image) {
		super();
		this.image = image;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
