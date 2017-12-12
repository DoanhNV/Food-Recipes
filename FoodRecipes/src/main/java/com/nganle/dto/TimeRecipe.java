package com.nganle.dto;

public class TimeRecipe {
	private int timeValue;
	private String timeName;

	public TimeRecipe() {

	}

	public TimeRecipe(int timeValue, String timeName) {
		this.timeValue = timeValue;
		this.timeName = timeName;
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

}
