package org.oregami.dropwizard;

import model.ArchivHeft;

import org.oregami.data.ArchivHeftDao;
import org.oregami.data.GenericDAO;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class KultpowerGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(new TypeLiteral<GenericDAO<ArchivHeft, Integer>>() {}).to(ArchivHeftDao.class);
//		bind(GameDAO.class);
		//bind(IUserService.class).to(UserServiceImpl.class);
	}

}
