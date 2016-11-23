package com.jhw;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.jhw.dao.PeopleDao;
import com.jhw.model.Card;
import com.jhw.model.People;
import com.jhw.repository.PeopleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Redis2ApplicationTests {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private PeopleDao peopleDao;

	@Test
	public void test1() {
		System.out.println("hello redis");
		Card card = new Card();
		card.setAddress("常州市软件园");
		card.setNumber("222222");
		People people = new People();
		people.setAge(22);
		people.setCard(card);
		people.setId(3l);
		people.setName("小哥");
		peopleRepository.save(people);
	}
	
	
	@Test
	public void test2(){
		People people = peopleRepository.findOne(3l);
		System.out.println(people);
		List<People> list = peopleRepository.findByName("小哥");
		if (!CollectionUtils.isEmpty(list)) {
			for (People people2 : list) {
				System.out.println("开始遍历");
				System.out.println(people2);
			}
		}
		
	}
	
	@Test
	public void test3(){
		peopleRepository.deleteAll();
	}
	
	@Test
	public void test4(){
		//Map<Object, Object> map = peopleDao.findAll();
		//System.out.println(map);
		Card card = new Card();
		card.setAddress("常州市软件园");
		card.setNumber("222222");
		People people = new People();
		people.setAge(22);
		people.setCard(card);
		people.setId(3l);
		people.setName("小哥");
		peopleDao.save(people);
		
	}
	
	@Test
	public void test5(){
		People people = peopleDao.getById(3l);
		System.out.println(people);
	}

}
