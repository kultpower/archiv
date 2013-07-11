package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the archiv_area database table.
 * 
 */
@Embeddable
public class ArchivAreaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ungueltig_zp")
	private java.util.Date ungueltigZp;

	public ArchivAreaPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.util.Date getUngueltigZp() {
		return this.ungueltigZp;
	}
	public void setUngueltigZp(java.util.Date ungueltigZp) {
		this.ungueltigZp = ungueltigZp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ArchivAreaPK)) {
			return false;
		}
		ArchivAreaPK castOther = (ArchivAreaPK)other;
		return 
			(this.id == castOther.id)
			&& this.ungueltigZp.equals(castOther.ungueltigZp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.ungueltigZp.hashCode();
		
		return hash;
	}
}