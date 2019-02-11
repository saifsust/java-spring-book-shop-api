package org.woadec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.woadec.migrations.Migrate;

@Entity
@Table(name = Migrate.POST_OFFICE_CODE)
public class PostOfficeCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_office_code_id")
	private int postOfficeCodeId;
	@Column(name = "post_office_code")
	private String postOfficeCode;

	public PostOfficeCode() {
		super();
	}

	public PostOfficeCode(String postOfficeCode) {
		super();
		this.postOfficeCode = postOfficeCode;
	}

	public int getPostOfficeCodeId() {
		return postOfficeCodeId;
	}

	public void setPostOfficeCodeId(int postOfficeCodeId) {
		this.postOfficeCodeId = postOfficeCodeId;
	}

	public String getPostOfficeCode() {
		return postOfficeCode;
	}

	public void setPostOfficeCode(String postOfficeCode) {
		this.postOfficeCode = postOfficeCode;
	}

	@Override
	public String toString() {
		return "PostOfficeCode [postOfficeCodeId=" + postOfficeCodeId + ", postOfficeCode=" + postOfficeCode + "]";
	}

}
