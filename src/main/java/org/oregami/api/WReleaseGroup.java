package org.oregami.api;

import java.util.ArrayList;
import java.util.List;

public class WReleaseGroup {

	private String platform;
	private List<WRelease> releaseList = new ArrayList<WRelease>();
	
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public List<WRelease> getReleaseList() {
		return releaseList;
	}

	public void setReleaseList(List<WRelease> releaseList) {
		this.releaseList = releaseList;
	}
}
