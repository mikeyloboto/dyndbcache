package com.evilbas.dyndbcache.domain;

public class DatabaseHookFactory {
	public static DatabaseHook<?> buildListDatabaseHook(Class<?> entityClass) {
		return new ListDatabaseHook<>();
	}
}
