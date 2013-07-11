package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the archiv_user database table.
 * 
 */
@Entity
@Table(name="archiv_user")
public class ArchivUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="kultpower_user_id")
	private int kultpowerUserId;

	@Column(name="is_admin")
	private int isAdmin;

	@Column(name="is_user")
	private byte isUser;

	public ArchivUser() {
	}

	public int getKultpowerUserId() {
		return this.kultpowerUserId;
	}

	public void setKultpowerUserId(int kultpowerUserId) {
		this.kultpowerUserId = kultpowerUserId;
	}

	public int getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public byte getIsUser() {
		return this.isUser;
	}

	public void setIsUser(byte isUser) {
		this.isUser = isUser;
	}

}