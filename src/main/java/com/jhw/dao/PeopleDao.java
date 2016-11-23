package com.jhw.dao;

import java.util.List;
import java.util.Map;

import com.jhw.model.People;

public interface PeopleDao {

	void save(People people);
	
	People getById(Long id);
	
	Map<Object, Object> findAll();
}
