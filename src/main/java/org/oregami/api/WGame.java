package org.oregami.api;

import java.util.ArrayList;
import java.util.List;

public class WGame {
	
	String name;
	boolean compilation;
	List<WReleaseGroup> releaseGroups = new ArrayList<WReleaseGroup>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WReleaseGroup> getReleaseGroups() {
		return releaseGroups;
	}

	public void setReleaseGroups(List<WReleaseGroup> releaseGroups) {
		this.releaseGroups = releaseGroups;
	}

	public boolean isCompilation() {
		return compilation;
	}

	public void setCompilation(boolean compilation) {
		this.compilation = compilation;
	}

}
