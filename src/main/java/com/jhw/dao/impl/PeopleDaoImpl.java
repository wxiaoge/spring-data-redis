package com.jhw.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.jhw.dao.PeopleDao;
import com.jhw.model.People;


@Repository
public class PeopleDaoImpl implements PeopleDao {
	
	private static String KEY = "people";
	
	@Autowired
	private RedisTemplate<String, People> redisTemplate;

	@Override
	public void save(People people) {
		redisTemplate.opsForHash().put(KEY, people.getId(), people);
	}

	@Override
	public People getById(Long id) {
		return (People) redisTemplate.opsForHash().get(KEY, id);
	}

	@Override
	public Map<Object, Object> findAll() {
		return redisTemplate.opsForHash().entries(KEY);
	}


}
