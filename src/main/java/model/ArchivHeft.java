package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;


/**
 * The persistent class for the archiv_heft database table.
 * 
 */
@Entity
@Table(name="archiv_heft")
@NamedQuery(name="ArchivHeft.GetAll", query="SELECT c FROM ArchivHeft c") 
public class ArchivHeft implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="erste_seite")
	private int ersteSeite;

	private String name;

	private String oeffentlich;

	private String path;

	@Column(name="spieleveteranen_folge")
	private Integer spieleveteranenFolge;

	//bi-directional many-to-one association to ArchivArea
//	@OneToMany(mappedBy="archivHeft", fetch=FetchType.LAZY)
//	private Set<ArchivArea> archivAreas;

	//bi-directional many-to-many association to ArchivKategorie
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(
//		name="archiv_heft_kategorie"
//		, joinColumns={
//			@JoinColumn(name="heft_id")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="kategorie_id")
//			}
//		)
//	private Set<ArchivKategorie> archivKategories;

	public ArchivHeft() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getErsteSeite() {
		return this.ersteSeite;
	}

	public void setErsteSeite(int ersteSeite) {
		this.ersteSeite = ersteSeite;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOeffentlich() {
		return this.oeffentlich;
	}

	public void setOeffentlich(String oeffentlich) {
		this.oeffentlich = oeffentlich;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSpieleveteranenFolge() {
		return this.spieleveteranenFolge;
	}

	public void setSpieleveteranenFolge(Integer spieleveteranenFolge) {
		this.spieleveteranenFolge = spieleveteranenFolge;
	}

//	public Set<ArchivArea> getArchivAreas() {
//		return this.archivAreas;
//	}
//
//	public void setArchivAreas(Set<ArchivArea> archivAreas) {
//		this.archivAreas = archivAreas;
//	}
//
//	public ArchivArea addArchivArea(ArchivArea archivArea) {
//		getArchivAreas().add(archivArea);
//		archivArea.setArchivHeft(this);
//
//		return archivArea;
//	}
//
//	public ArchivArea removeArchivArea(ArchivArea archivArea) {
//		getArchivAreas().remove(archivArea);
//		archivArea.setArchivHeft(null);
//
//		return archivArea;
//	}

//	public Set<ArchivKategorie> getArchivKategories() {
//		return this.archivKategories;
//	}
//
//	public void setArchivKategories(Set<ArchivKategorie> archivKategories) {
//		this.archivKategories = archivKategories;
//	}

}