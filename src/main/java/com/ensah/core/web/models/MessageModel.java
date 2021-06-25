package com.ensah.core.web.models;

public class MessageModel {


	private String text;

	private Long expediteurid;

	private Long destinataireid;

	public MessageModel() {
		// TODO Auto-generated constructor stub
	}

	public MessageModel(Long idexp) {
		this.expediteurid = idexp;
	}
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getExpediteurid() {
		return expediteurid;
	}

	public void setExpediteurid(Long expediteurid) {
		this.expediteurid = expediteurid;
	}

	public Long getDestinataireid() {
		return destinataireid;
	}

	public void setDestinataireid(Long destinataireid) {
		this.destinataireid = destinataireid;
	}
	
	

}
