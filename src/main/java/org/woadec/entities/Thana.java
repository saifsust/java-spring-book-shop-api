package org.woadec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.woadec.migrations.Migrate;

@Entity
@Table(name = Migrate.THANA)
public class Thana {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "thana_id")
	private int thana_id;
	@Column(name = "thana_name")
	private String thana_name;

	public Thana() {
		super();
	}

	public Thana(String thana_name) {
		super();
		this.thana_name = thana_name;
	}

	public int getThana_id() {

		return thana_id;
	}

	public void setThana_id(int thana_id) {
		this.thana_id = thana_id;
	}

	public String getThana_name() {
		return thana_name;
	}

	public void setThana_name(String thana_name) {
		this.thana_name = thana_name;
	}

	@Override
	public String toString() {
		return "Thana [thana_id=" + thana_id + ", thana_name=" + thana_name + "]";
	}

}
