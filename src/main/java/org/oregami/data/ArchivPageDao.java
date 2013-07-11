package org.oregami.data;

import java.util.List;

import javax.persistence.EntityManager;

import model.ArchivArea;
import model.ArchivPage;

import com.google.inject.Inject;

public class ArchivPageDao extends GenericDAOImpl<ArchivArea, Integer>{

	@Inject
	public ArchivPageDao(EntityManager man) {
		super(man);
		entityClass=ArchivArea.class;
	}
	
	
    @SuppressWarnings("unchecked")
	public List<ArchivPage> findByHeftPath(String path) {
        List<ArchivPage> pages = (List<ArchivPage>)getEntityManager()
        		.createNativeQuery("SELECT * FROM archiv_page a, archiv_heft h where a.heft_id=h.id and h.path='" + path + "'", ArchivPage.class).getResultList(); 
        return pages;
    }


}
