package org.oregami.data;

import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDAO<E extends Object, P>
{
 /**
  * Persist the indicated entity to database
  * @param entity
  * @return the primary key
  */
 boolean save(E entity);
  
 /**
  * Retrieve an object using indicated ID
  * @param id
  * @return
  */
 E findOne(P id);
 
 /**
  * Update indicated entity to database
  * @param entity
  */
 void update(E entity);
  
 /**
  * Delete indicated entity from database
  * @param entity
  */
 void delete(E entity);
  
 /**
  * Return the entity class
  * @return
  */
 Class<E> getEntityClass();
  
 /**
  * Get the entity manager
  * @return
  */
 EntityManager getEntityManager();
  
 /**
  *
  * @return
  */
 List<E> findAll();
}