package com.nganle.entity;

import java.util.ArrayList;
import java.util.List;

import com.nganle.support.constant.Constant;
import com.nganle.support.util.Utils;

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
			stepStr += texts.get(i) + Constant.STEP_ELEMENT_SEPARATOR;
			stepStr += filePaths.get(i);
			stepStr += "}";
			result += stepStr;
			if( i != (stepNumber -1)){
				result += Constant.STEP_SEPARATOR;
			}
		}
		return result + "]";
	}
	
	public static List<Step> toListStep(String sqlStep){
		List<Step> result = new ArrayList<Step>();
		String standard = sqlStep.substring(1,sqlStep.length()-1);
		String[] data = standard.split(Constant.STEP_SEPARATOR);
		for (int i = 0; i < data.length; i++) {
			String step = data[i].substring(1, data[i].length()-1);
			String[] stepContent = step.split(Constant.STEP_ELEMENT_SEPARATOR);
			String fileByte = Utils.convertToFileByte( stepContent[1]);
			Step currentStep = new Step(stepContent[0], fileByte);
			result.add(currentStep);
		}
		return result;
	}
	
	public static List<Step> toListStepV2(String sqlStep){
		List<Step> result = new ArrayList<Step>();
		String standard = sqlStep.substring(1,sqlStep.length()-1);
		String[] data = standard.split(Constant.STEP_SEPARATOR);
		for (int i = 0; i < data.length; i++) {
			String step = data[i].substring(1, data[i].length()-1);
			String[] stepContent = step.split(Constant.STEP_ELEMENT_SEPARATOR);
			Step currentStep = new Step(stepContent[0], stepContent[1]);
			result.add(currentStep);
		}
		return result;
	}
}
