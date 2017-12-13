package com.nganle.dto;

public class TimeRecipe {
	private int timeValue;
	private String timeName;
	private String selected;

	public TimeRecipe() {

	}

	public TimeRecipe(int timeValue, String timeName) {
		this.timeValue = timeValue;
		this.timeName = timeName;
	}
	
	public TimeRecipe(int timeValue, String timeName, String selected) {
		this.timeValue = timeValue;
		this.timeName = timeName;
		this.selected = selected;
	}

	public int getTimeValue() {
		return timeValue;
	}

	public void setTimeValue(int timeValue) {
		this.timeValue = timeValue;
	}

	public String getTimeName() {
		return timeName;
	}

	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

}
