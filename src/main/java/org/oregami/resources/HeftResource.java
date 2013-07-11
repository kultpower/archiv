package org.oregami.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		result.put("areas",listAreas);
		areaRepository.getTransaction().commit();
		
		pageRepository.getTransaction().begin();
		List<ArchivPage> listPages = pageRepository.findByHeftPath(heftname);
		result.put("pages",listPages);
		pageRepository.getTransaction().commit();
		
		return result;
	}
	
}
