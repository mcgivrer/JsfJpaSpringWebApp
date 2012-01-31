package com.samples.spring.JSFSpringJPASample.bean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.samples.spring.JSFSpringJPASample.model.Task;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Task task) {
		entityManager.persist(task);
	}

	@Transactional
	public void delete(Long  taskId) {
		Task t = (Task)entityManager.find(Task.class,taskId);
		entityManager.remove(t);
		t=null;
	}

	@SuppressWarnings("unchecked")
	public List<Task> list() {
		return entityManager.createQuery("select t from Task t")
				.getResultList();
	}

}
