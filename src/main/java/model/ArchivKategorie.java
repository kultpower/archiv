package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the archiv_kategorie database table.
 * 
 */
@Entity
@Table(name="archiv_kategorie")
public class ArchivKategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kategorie_id")
	private int kategorieId;

	@Column(name="ist_testbericht")
	private byte istTestbericht;

	private String kommentar;

	private String plural;

	private String singular;

	private int sortierindex;

	//bi-directional many-to-many association to ArchivHeft
//	@ManyToMany(mappedBy="archivKategories", fetch=FetchType.EAGER)
//	private List<ArchivHeft> archivHefts;

	public ArchivKategorie() {
	}

	public int getKategorieId() {
		return this.kategorieId;
	}

	public void setKategorieId(int kategorieId) {
		this.kategorieId = kategorieId;
	}

	public byte getIstTestbericht() {
		return this.istTestbericht;
	}

	public void setIstTestbericht(byte istTestbericht) {
		this.istTestbericht = istTestbericht;
	}

	public String getKommentar() {
		return this.kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public String getPlural() {
		return this.plural;
	}

	public void setPlural(String plural) {
		this.plural = plural;
	}

	public String getSingular() {
		return this.singular;
	}

	public void setSingular(String singular) {
		this.singular = singular;
	}

	public int getSortierindex() {
		return this.sortierindex;
	}

	public void setSortierindex(int sortierindex) {
		this.sortierindex = sortierindex;
	}

//	public List<ArchivHeft> getArchivHefts() {
//		return this.archivHefts;
//	}
//
//	public void setArchivHefts(List<ArchivHeft> archivHefts) {
//		this.archivHefts = archivHefts;
//	}

}