package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the archiv_area database table.
 * 
 */
@Entity
@Table(name="archiv_area")
public class ArchivArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArchivAreaPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="erstell_zp")
	private Date erstellZp;

	private int fileheight;

	private String filename;

	private int filewidth;

	private int height;

	private String title;

	private String type;

	private int type2;

	private int userid;

	private int width;

	private int xpos;

	private int ypos;

	//bi-directional many-to-one association to ArchivHeft
//	@ManyToOne
//	@JoinColumn(name="heft_id")
//	private ArchivHeft archivHeft;

	public ArchivArea() {
	}

	public ArchivAreaPK getId() {
		return this.id;
	}

	public void setId(ArchivAreaPK id) {
		this.id = id;
	}

	public Date getErstellZp() {
		return this.erstellZp;
	}

	public void setErstellZp(Date erstellZp) {
		this.erstellZp = erstellZp;
	}

	public int getFileheight() {
		return this.fileheight;
	}

	public void setFileheight(int fileheight) {
		this.fileheight = fileheight;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFilewidth() {
		return this.filewidth;
	}

	public void setFilewidth(int filewidth) {
		this.filewidth = filewidth;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getType2() {
		return this.type2;
	}

	public void setType2(int type2) {
		this.type2 = type2;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getXpos() {
		return this.xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return this.ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

//	public ArchivHeft getArchivHeft() {
//		return this.archivHeft;
//	}
//
//	public void setArchivHeft(ArchivHeft archivHeft) {
//		this.archivHeft = archivHeft;
//	}

}