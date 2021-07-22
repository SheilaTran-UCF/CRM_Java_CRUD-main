package cyber.java.crmApp.dto;

import java.util.Date;

import cyber.java.crmApp.model.Project;

public class ProjectDto {
	private int id;
	private String name;
	private String description;
	private String start_date;
	private String end_date;
	private int owner;

	public ProjectDto(int id, String name, String description, String start_date, String end_date, int owner) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.owner = owner;
	}
	
	public ProjectDto() {
		this.id = id;
	}
	
	public ProjectDto(Project project) {
		this.setId(project.getId());
		this.name = project.getName();
		this.description = project.getDescription();
		this.start_date = project.getStart_date();
		this.end_date = project.getEnd_date();
		this.owner = project.getOwner();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

}