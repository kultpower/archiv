package org.oregami.data;

import java.util.List;

import javax.persistence.EntityManager;

import model.ArchivArea;

import com.google.inject.Inject;

public class ArchivAreaDao extends GenericDAOImpl<ArchivArea, Integer>{

	@Inject
	public ArchivAreaDao(EntityManager man) {
		super(man);
		entityClass=ArchivArea.class;
	}
	
	
    @SuppressWarnings("unchecked")
	public List<ArchivArea> findByHeftPath(String path) {
        List<ArchivArea> games = (List<ArchivArea>)getEntityManager()
        		.createNativeQuery("SELECT * FROM archiv_area a, archiv_heft h where a.heft_id=h.id and h.path='" + path + "'", ArchivArea.class).getResultList(); 
        return games;
    }


}
