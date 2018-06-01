package com.evilbas.dyndbcache.domain;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Vector;

public class ListDatabaseHook<?> implements DatabaseHook<?>{
	
	Vector<?> elements; 
	
	protected ListDatabaseHook() {
		elements = new Vector<>();
		generateQuery();
	}

	private void generateQuery() {
		Class t = ListDatabaseHook.class.getGenericSuperclass().getClass();
		System.out.println("Determined class: " + t);
	}
}
