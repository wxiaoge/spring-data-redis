package com.jhw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jhw.model.People;

public interface PeopleRepository extends CrudRepository<People, Long>{

	List<People> findByName(String name);
}
