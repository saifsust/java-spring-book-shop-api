package org.woadec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.woadec.migrations.Migrate;

@Entity
@Table(name = Migrate.ZELA)
public class Zela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "zela_id")
	private int zela_id;
	@Column(name = "zela_name")
	private String zela_name;

	public Zela() {
		super();
	}

	public Zela(String zela_name) {
		super();
		this.zela_name = zela_name;
	}

	public int getZela_id() {
		return zela_id;
	}

	public void setZela_id(int zela_id) {
		this.zela_id = zela_id;
	}

	public String getZela_name() {
		return zela_name;
	}

	public void setZela_name(String zela_name) {
		this.zela_name = zela_name;
	}

	@Override
	public String toString() {
		return "Zela [zela_id=" + zela_id + ", zela_name=" + zela_name + "]";
	}

}
