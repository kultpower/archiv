package org.oregami.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.ArchivArea;
import model.ArchivPage;

import org.oregami.data.ArchivAreaDao;
import org.oregami.data.ArchivPageDao;

import com.google.inject.Inject;


@Path("/heft/")
@Produces(MediaType.APPLICATION_JSON)
public class HeftResource {

	@Inject
	public ArchivAreaDao areaRepository;
	
	@Inject
	public ArchivPageDao pageRepository;	
	
	public HeftResource() {
	}
	
	  
	@GET
	@Path("{heftname}")
	public Object show(@PathParam("heftname") String heftname) {
		Map<String,Object> result = new HashMap<String,Object>();
		
		areaRepository.getTransaction().begin();
		List<ArchivArea> listAreas = areaRepository.findByHeftPath(heftname);
		areaRepository.getTransaction().commit();
		
		pageRepository.getTransaction().begin();
		List<ArchivPage> listPages = pageRepository.findByHeftPath(heftname);
		pageRepository.getTransaction().commit();
		
		List<Integer> filledPageNumbers = new ArrayList<Integer>();
		
		Map<Integer, ArchivPage> pagesByRealPageNumber = new TreeMap<Integer, ArchivPage>();
		for (ArchivPage archivPage : listPages) {
			filledPageNumbers.add(archivPage.getRealPageNumber());
			pagesByRealPageNumber.put(archivPage.getRealPageNumber(), archivPage);
		}
		
		List<List<Integer>> doublePages = new ArrayList<List<Integer>>();
		doublePages.add(new ArrayList<Integer>());
		int doublePageNumber = 0;
		for (int i = 0; i < filledPageNumbers.size(); i++) {
			doublePages.get(doublePageNumber).add(filledPageNumbers.get(i));
			if (i%2==0 || i==0) {
				doublePages.add(new ArrayList<Integer>());
				doublePageNumber++;
			}
		}
		if (doublePages.get(doublePages.size()-1).size()==0) {
			doublePages.remove(doublePages.size()-1);
		}
		result.put("filledPageNumbers",filledPageNumbers);
		result.put("doublePages",doublePages);
		result.put("pagesByRealPageNumber",pagesByRealPageNumber);
//		result.put("areas",listAreas);
		result.put("pages",listPages);
		
		
		
		
		return result;
	}
	
}
