package com.mypharamacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "prescription")
public class Image {

	@Id
	@Column(name = "DocId")
	private int docId;
	@Lob
	private byte[] image;

	public Image(byte[] image) {
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
