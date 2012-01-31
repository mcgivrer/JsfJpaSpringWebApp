package com.samples.spring.JSFSpringJPASample.bean;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samples.spring.JSFSpringJPASample.model.Task;

/**
 * Home manager for Tasks page (home.xhtml/jsf). 
 * @author frederic
 *
 */
@Component("taskHome")
public class TaskHome extends MyHome{
	/**
	 * Internal logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(TaskHome.class);
	/**
	 * Task object corresponding to form.
	 */
	private Task task = new Task();
	/**
	 * List of task from database.
	 */
	private List<Task> tasks;

	@Autowired
	private TaskDao taskDao;

	/**
	 * return a message from Home.
	 * @return
	 */
	public String getMessage() {
		logger.debug("Returning message from task home bean");
		return "Hello from Spring";
	}	

	/**
	 * retrieve task from form.
	 * @return
	 */
	public Task getTask() {
		task.setCreatedBy("FDE");
		return task;
	}

	/**
	 * Save task object.
	 */
	public void saveTask() {
		taskDao.save(task);
		task = new Task();
		invalidateTasks();
	}

	/**
	 * Delete the task which id is <code>id</code>.
	 * @param id of the task to be deleted.
	 */
	public void deleteTask(){
		taskDao.delete(Long.parseLong(this.getParameter("taskId")));
		tasks = taskDao.list();
	}
	
	/**
	 * Retrieve list of all tasks created.
	 * @return
	 */
	public List<Task> getTasks() {
		if (tasks == null) {
			tasks = taskDao.list();
		}
		return tasks;
		
	}

	/**
	 * Internal task list cleaner.
	 */
	private void invalidateTasks() {
		tasks = null;
	}
}
