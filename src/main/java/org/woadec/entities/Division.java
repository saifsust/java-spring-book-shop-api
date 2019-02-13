package org.woadec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.woadec.migrations.Migrate;

@Entity
@Table(name = Migrate.DIVISION)
public class Division {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "division_id")
	private int divisionId;
	@Column(name = "division_name")
	private String divisionnName;

	public Division() {
		super();
	}

	public Division(String divisionnName) {
		this.divisionnName = divisionnName;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionnName() {
		return divisionnName;
	}

	public void setDivisionnName(String divisionnName) {
		this.divisionnName = divisionnName;
	}

	@Override
	public String toString() {
		return "Division [divisionId=" + divisionId + ", divisionnName=" + divisionnName + "]";
	}

}
