package com.evilbas.dyndbcache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.sql.DataSource;

import com.evilbas.dyndbcache.annotations.DynEntity;
import com.evilbas.dyndbcache.annotations.DynMapKey;
import com.evilbas.dyndbcache.domain.DatabaseHook;
import com.evilbas.dyndbcache.domain.DatabaseHookFactory;
import com.evilbas.dyndbcache.exception.DynDbException;

/**
 * 
 * @author Evilbas
 *
 */

public class DynCache {
	private DataSource dataSource;
	private DynConfiguration configuration;
	private List<List<DynEntity>> registeredLists;
	private List<Map<DynMapKey, DynEntity>> registeredMaps;
	
	public DynCache(DataSource dataSource) {
		registeredLists = new ArrayList<>();
		registeredMaps = new ArrayList<>();
		this.dataSource = dataSource;
		this.configuration = new DynConfiguration();
		this.configuration.setPollTimeMillis(1000L);
	}

	public DynConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(DynConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public Vector<?> registerList(Class<?> entityClass) throws DynDbException {
		// Validation
		// instantiate and inspect
		
		Object dummy;
		try {
			dummy = entityClass.getConstructor().newInstance();
			System.out.println("Instantiating dummy object of type " + dummy.getClass());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new DynDbException("Instantiation exception. Perhaps provided class has a private constructor?");
		}
		
		Vector<?> list = new Vector<>();
		DatabaseHook<?> dbHook = DatabaseHookFactory.buildListDatabaseHook(dummy.getClass());
		//registeredLists.add(list);
		return list;
	}
	
	public void registerMap(Map<DynMapKey, DynEntity> entityMap) {
		registeredMaps.add(entityMap);
	}
	
	
	
	
}
