package org.oregami.util;

import java.io.File;
import java.io.FilenameFilter;

import model.ArchivHeft;

import org.oregami.data.ArchivHeftDao;
import org.oregami.dropwizard.KultpowerGuiceInjector;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;

public class HeftPagelistCreator {

	private static Injector injector;

	public static void init() {
		injector = KultpowerGuiceInjector.get();
		PersistService persistService = injector.getInstance(PersistService.class);
		persistService.start();
	}

	@Inject
	private ArchivHeftDao heftRepository;

	
	public static void main(String[] args) {
		init();
		HeftPagelistCreator app = injector.getInstance(HeftPagelistCreator.class);
		
		String heftPath = "powerplay_1989-08";
		String directory = "/Users/sebastian/Documents/KULTPOWER/_BACKUP/hidrive_kultpower_2012-05/www/archiv/hefte/";
		
		app.createPageList(directory, heftPath);
		
	}


	private void createPageList(String directory, String heftPath) {
		
		File dir = new File(directory + heftPath);
		String[] fileList = dir.list(new FilenameFilter() {
		    public boolean accept(File d, String name) {
		       return name.endsWith(".jpg") && name.indexOf("_")>0;
		    }
		});
		
		ArchivHeft heft = heftRepository.findByPath(heftPath);
		int heftId = heft.getId();
		
		for (String dateiname : fileList) {
			int available = 1;
			String sql = "insert into archiv_page (heft_id, dateiname, available) " +
					" values ("+ heftId + ", " + "'" + dateiname + "', " + available + ");";
			System.out.println(sql);
		}		
	}
	
}
