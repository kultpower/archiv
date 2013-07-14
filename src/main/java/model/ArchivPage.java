package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the archiv_heft_datei database table.
 * 
 */
@Entity
@Table(name="archiv_page")
public class ArchivPage implements Serializable {
	private static final long serialVersionUID = 1L;

	private byte available;

	@Id
	private String dateiname;

	@Column(name="heft_id")
	private int heftId;

	public ArchivPage() {
	}

	public byte getAvailable() {
		return this.available;
	}

	public void setAvailable(byte available) {
		this.available = available;
	}

	public String getDateiname() {
		return this.dateiname;
	}

	public void setDateiname(String dateiname) {
		this.dateiname = dateiname;
	}

	public int getHeftId() {
		return this.heftId;
	}

	public void setHeftId(int heftId) {
		this.heftId = heftId;
	}
	
	public int getRealPageNumber() {
		String temp = dateiname.replaceAll(".jpg", "");
		int realPageNumber = Integer.parseInt(temp.substring(temp.length()-3));
		return realPageNumber;
	}

	public void setRealPageNumber(int realPageNumber) {
		//this.realPageNumber = realPageNumber;
	}	

}