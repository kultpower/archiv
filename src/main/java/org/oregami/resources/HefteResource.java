package org.oregami.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.ArchivHeft;

import org.oregami.data.ArchivHeftDao;

import com.google.inject.Inject;


@Path("/hefte")
@Produces(MediaType.APPLICATION_JSON)
public class HefteResource {

	public ArchivHeftDao heftRepository;
	
	@Inject
	public HefteResource(ArchivHeftDao gameRepository) {
		this.heftRepository = gameRepository;
	}
	
	  
	@GET
	public Map<String, List<ArchivHeft>> list() {
		
		Map<String, List<ArchivHeft>> map = new TreeMap<String, List<ArchivHeft>>();
		
		List<ArchivHeft> alleHefteListe = new ArrayList<ArchivHeft>();
		
		heftRepository.getTransaction().begin();
		alleHefteListe = heftRepository.findAll();
		heftRepository.getTransaction().commit();
		
		List<String> magazinNamen = new ArrayList<String>();
		magazinNamen.add("powerplay");
		magazinNamen.add("videogames");
		magazinNamen.add("telematch");
		
		for (String magazin : magazinNamen) {
			List<ArchivHeft> hefteListe = new ArrayList<ArchivHeft>();
			for (ArchivHeft archivHeft : alleHefteListe) {
				if (archivHeft.getPath().startsWith(magazin)) {
					hefteListe.add(archivHeft);
				}
			}	
			map.put(magazin, hefteListe.subList(0, Math.min(5, hefteListe.size())));
		}
		
//		heftRepository.getTransaction().commit();
		
//		ArchivHeft heft = new ArchivHeft();
//		heft.setName("name");
//		heftListe.add(heft);
		
		
		
		//return heftListe.subList(0, 35);
		return map;
	}
	
}
