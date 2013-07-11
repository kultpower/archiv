package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the archiv_kommentar database table.
 * 
 */
@Entity
@Table(name="archiv_kommentar")
public class ArchivKommentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kommentar_id")
	private int kommentarId;

	@Column(name="autor_email")
	private String autorEmail;

	@Column(name="autor_homepage")
	private String autorHomepage;

	@Column(name="autor_name")
	private String autorName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="erstell_zeitpunkt")
	private Date erstellZeitpunkt;

	private byte freigeschaltet;

	private String hash;

	@Lob
	@Column(name="kommentar_text")
	private String kommentarText;

	private String referenz;

	public ArchivKommentar() {
	}

	public int getKommentarId() {
		return this.kommentarId;
	}

	public void setKommentarId(int kommentarId) {
		this.kommentarId = kommentarId;
	}

	public String getAutorEmail() {
		return this.autorEmail;
	}

	public void setAutorEmail(String autorEmail) {
		this.autorEmail = autorEmail;
	}

	public String getAutorHomepage() {
		return this.autorHomepage;
	}

	public void setAutorHomepage(String autorHomepage) {
		this.autorHomepage = autorHomepage;
	}

	public String getAutorName() {
		return this.autorName;
	}

	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	public Date getErstellZeitpunkt() {
		return this.erstellZeitpunkt;
	}

	public void setErstellZeitpunkt(Date erstellZeitpunkt) {
		this.erstellZeitpunkt = erstellZeitpunkt;
	}

	public byte getFreigeschaltet() {
		return this.freigeschaltet;
	}

	public void setFreigeschaltet(byte freigeschaltet) {
		this.freigeschaltet = freigeschaltet;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getKommentarText() {
		return this.kommentarText;
	}

	public void setKommentarText(String kommentarText) {
		this.kommentarText = kommentarText;
	}

	public String getReferenz() {
		return this.referenz;
	}

	public void setReferenz(String referenz) {
		this.referenz = referenz;
	}

}