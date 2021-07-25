package cyber.java.crmApp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cyber.java.crmApp.model.Task;
import cyber.java.crmApp.service.TaskService;
import cyber.java.crmApp.util.UrlConst;

@WebServlet(name="taskServlet", urlPatterns = {
		UrlConst.TASK_DASHBOARD	,
		UrlConst.TASK_ADD,
		UrlConst.TASK_UPDATE,
		UrlConst.TASK_DELETE	
	})
public class TaskServlet extends HttpServlet {
	private TaskService service;

	@Override
	public void init() throws ServletException {
		service = new TaskService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch (req.getServletPath()) {	
		case UrlConst.TASK_DASHBOARD:
			getTaskDashboard(req,resp);
			break;
		case UrlConst.TASK_ADD:
			getTaskAdd(req,resp);
			break;
		case UrlConst.TASK_UPDATE:
			getTaskUpdate(req,resp);
			break;
		case UrlConst.TASK_DELETE:
			getTaskDelete(req,resp);
			break;
		
		
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(req.getServletPath()) {
		
		case UrlConst.TASK_DASHBOARD:
			break;
		
		case UrlConst.TASK_ADD:
			postTaskAdd(req,resp);
			break;
		case UrlConst.TASK_UPDATE:
			postTaskUpdate(req,resp);
			break;
		case UrlConst.TASK_DELETE:
			
			break;
		}	
		
	}
	
	private void getTaskDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Task> tasks = service.findTask();
		
		if (tasks != null && !tasks.isEmpty())
			req.setAttribute("tasks", tasks);

		req.getRequestDispatcher(UrlConst.TASK_DASHBOARD).forward(req, resp);
		
	}
	private void getTaskDelete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	private void getTaskUpdate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	private void getTaskAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(UrlConst.TASK_ADD).forward(req, resp);
		
	}
	

	private void postTaskUpdate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	private void postTaskAdd(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	}