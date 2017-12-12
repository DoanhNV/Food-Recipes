package com.nganle.entity;

import java.util.ArrayList;
import java.util.List;

public class Step {
	private String text;
	private String filePath;

	public Step() {

	}

	public Step(String text, String filePath) {
		this.text = text;
		this.filePath = filePath;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	public static List<Step> toListDTO(List<String> texts,List<String> filePaths){
		List<Step> result = new ArrayList<Step>();
		for (int i = 0; i < texts.size(); i++) {
			result.add(new Step(texts.get(i), filePaths.get(i)));
		}
		return result;
	}
	
	public static String toSQLArray(List<String> texts,List<String> filePaths){
		String result = "[";
		int stepNumber = texts.size();
		for (int i = 0; i < stepNumber; i++) {
			String stepStr = "{";
			stepStr += texts.get(i) + "||";
			stepStr += filePaths.get(i);
			stepStr += "}";
			result += stepStr;
			if( i != (stepNumber -1)){
				result += "*";
			}
		}
		return result + "]";
	}
}
