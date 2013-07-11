package org.oregami.data;

import javax.persistence.EntityManager;

import model.ArchivHeft;

import com.google.inject.Inject;

public class ArchivHeftDao extends GenericDAOImpl<ArchivHeft, Integer>{

	@Inject
	public ArchivHeftDao(EntityManager man) {
		super(man);
		entityClass=ArchivHeft.class;
	}
	
	
    @SuppressWarnings("unchecked")
	public ArchivHeft findByPath(String heftPath) {
        ArchivHeft heft = (ArchivHeft)getEntityManager()
        		.createNativeQuery("SELECT * FROM archiv_heft h where h.path = '" + heftPath + "'", ArchivHeft.class).getResultList().get(0); 
        return heft;
    }


}
