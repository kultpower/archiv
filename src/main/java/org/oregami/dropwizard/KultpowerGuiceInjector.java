package org.oregami.dropwizard;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;


public class KultpowerGuiceInjector {

	private static final Injector INJECTOR = createInjector();
	
	private static Injector createInjector() {
    	return Guice.createInjector(
    			new KultpowerGuiceModule(), new JpaPersistModule("data")
    	);
    }

	public static Injector get() {
		return INJECTOR;
	}
}