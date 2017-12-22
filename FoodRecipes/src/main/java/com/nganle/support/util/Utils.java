package com.nganle.support.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nganle.dto.TimeRecipe;
import com.nganle.entity.Step;
import com.nganle.support.constant.Constant;

public class Utils {

	public static void destroySession(HttpSession session, String sessionName) {
		session.removeAttribute(sessionName);
	}

	public static void setSession(HttpSession session, String sessionName, Object value) {
		session.setAttribute(sessionName, value);
	}

	public static Object getSession(HttpSession session, String sessionName) {
		return session.getAttribute(sessionName);
	}

	public static void setErrorMessage(ModelMap model, String messageName, String messageValue) {
		model.addAttribute(messageName, messageValue);
	}

	public static List<String> getPageToDisplay(int size, int currentPage) {
		List<String> result = new ArrayList<String>();
		if (currentPage > size) {
			return result;
		}
		if (currentPage - 2 > 0) {
			result.add("...");
		}
		if (currentPage - 1 > 0) {
			result.add(String.valueOf(currentPage - 1));
		}
		result.add(String.valueOf(currentPage));
		if (currentPage + 1 <= size) {
			result.add(String.valueOf(currentPage + 1));
		}
		if (currentPage + 2 <= size) {
			result.add("...");
		}
		return result;
	}

	/**
	 * Url : /part/part
	 * 
	 * @param url
	 * @return
	 */
	public static String redirect(String url) {
		return "redirect:" + url;
	}

	public static String toSQlArray(List<Integer> list) {
		if (list == null) {
			return "";
		}
		String result = "";
		int size = list.size();
		for (int i = 0; i < size; i++) {
			result += list.get(i);
			if (i != size - 1) {
				result += ",";
			}
		}
		return result;
	}

	public static String toCateList(List<String> list) {
		if (list == null) {
			return "";
		}
		String result = "";
		int size = list.size();
		for (int i = 0; i < size; i++) {
			result += list.get(i);
			if (i != size - 1) {
				result += ",";
			}
		}
		return result;
	}

	public static Timestamp getCurrentSQLDate() {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		return timeStamp;
	}

	/**
	 * arr format: "a,b,c"
	 * 
	 * @param arr
	 *            String
	 * @return List<String>
	 */
	public static List<Integer> toList(String arr) {
		List<Integer> result = new ArrayList<Integer>();
		if (arr == null || arr == "") {
			return result;
		}
		String[] data = arr.split(",");
		for (int i = 0; i < data.length; i++) {
			result.add(Integer.parseInt(data[i]));
		}
		return result;
	}

	public static List<String> toListString(String arr) {
		List<String> result = new ArrayList<String>();
		if (arr == null || arr == "") {
			return result;
		}
		String[] data = arr.split(",");
		for (int i = 0; i < data.length; i++) {
			if (!data[i].isEmpty()) {
				result.add(data[i]);
			}
		}
		return result;
	}

	public static String uploadToStorage(MultipartFile file) {
		String filePath = Constant.FILE_STORE + file.getOriginalFilename();
		File desFile = new File(filePath);
		if(!desFile.getParentFile().exists()) {
			desFile.getParentFile().mkdir();
		}
		try {
			if (file.getSize() != 0) {
				FileCopyUtils.copy(file.getBytes(), desFile);
				return filePath;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("update no filePath!");
		}
		return "noFilePath";
	}

	public static List<String> uploadToStorageAndCheckUpdate(List<MultipartFile> files, List<Step> listStep) {
		List<String> listpath = new ArrayList<String>();
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			String filePath = Constant.FILE_STORE + file.getOriginalFilename();
			File desFile = new File(filePath);
			if(!desFile.getParentFile().exists()) {
				desFile.getParentFile().mkdir();
			}
			try {
				if (file.getSize() != 0) {
					FileCopyUtils.copy(file.getBytes(), desFile);
					listpath.add(filePath);
				} else {
					if (i < listStep.size()) {
						listpath.add(listStep.get(i).getFilePath());
					} else {
						listpath.add("nofilePath");
					}
				}
			} catch (IOException e) {
				System.out.println("update no file path!");
			}
		}

		return listpath;
	}

	public static List<TimeRecipe> init(int max, String suffix) {
		List<TimeRecipe> result = new ArrayList<TimeRecipe>();
		for (int i = 0; i < max + 1; i++) {
			result.add(new TimeRecipe(i, i + " " + suffix));
		}
		return result;
	}

	public static List<TimeRecipe> initTime(int max, String suffix, int current) {
		List<TimeRecipe> result = new ArrayList<TimeRecipe>();
		for (int i = 0; i < max + 1; i++) {
			TimeRecipe timeRecipe = new TimeRecipe(i, i + " " + suffix);
			if (i == current) {
				timeRecipe.setSelected("selected");
			}
			result.add(timeRecipe);
		}
		return result;
	}

	public static Map<Integer, String> initMapTime(int max, String suffix) {
		Map<Integer, String> result = new HashMap<Integer, String>();
		for (int i = 0; i < max + 1; i++) {
			result.put(i, i + " " + suffix);
		}
		return result;
	}

	public static String convertToFileByte(String path) {
		String fileByte = "data:image/png;base64,";
		try {
			byte[] fileBytes = Files.readAllBytes(new File(path).toPath());
			byte[] code = Base64Utils.encode(fileBytes);
			fileByte += new String(code, "UTF-8");
			return fileByte;
		} catch (IOException e) {
			System.out.println("read no image!");
		}
		return null;
	}

	public static String toSqlLikes(List<String> listKindCate, String field) {
		String result = "";
		int size = listKindCate.size();
		for (int i = 0; i < size; i++) {
			result += field + " LIKE '%" + listKindCate.get(i) + "%'";
			if (i != size - 1) {
				result += " OR ";
			}
		}
		return result;
	}

	public static String toSqlLikesFrInt(List<Integer> listKindCate, String field) {
		String result = "";
		int size = listKindCate.size();
		for (int i = 0; i < size; i++) {
			result += field + " LIKE '%" + listKindCate.get(i) + "%'";
			if (i != size - 1) {
				result += " OR ";
			}
		}
		return result;
	}

	public static String toSqlLikesFromInt(List<Integer> listKindCate, String field) {
		String result = "";
		int size = listKindCate.size();
		for (int i = 0; i < size; i++) {
			result += field + " LIKE '%" + listKindCate.get(i) + ",%' OR " + field + " LIKE '%," + listKindCate.get(i)
					+ "%' ";
			if (i != size - 1) {
				result += " OR ";
			}
		}
		return result;
	}

	public static String toSqlInList(List<String> inputStr) {
		String result = "(";
		int size = inputStr.size();
		for (int i = 0; i < size; i++) {
			result += inputStr.get(i);
			if (i != size - 1) {
				result += ",";
			}
		}
		return result + ")";
	}

	public static String toSqlInListFromInt(List<Integer> list) {
		String result = "(";
		int size = list.size();
		for (int i = 0; i < size; i++) {
			result += list.get(i);
			if (i != size - 1) {
				result += ",";
			}
		}
		return result + ")";
	}

	public static String formatMoney(Double money) {
		MonetaryAmount oneDollar = Monetary.getDefaultAmountFactory().setCurrency("VND").setNumber(money).create();
		MonetaryAmountFormat formatUSD = MonetaryFormats.getAmountFormat(new Locale("vi", "VN"));
		return formatUSD.format(oneDollar);
	}

	public static List<Integer> toListCateId(String[] data) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < data.length; i++) {
			try {
				result.add(Integer.parseInt(data[i]));
			} catch (Exception e) {
				e.printStackTrace();
				return result;
			}
		}
		return result;
	}

	public static List<String> toListRecipeCate(String[] data) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < data.length; i++) {
			result.add(data[i] + "-");
		}
		return result;
	}

	public static String toSqlLikesTitle(String title, String field) {
		String[] words = title.split("[\\s]+");
		String result = "";
		int size = words.length;
		for (int i = 0; i < size; i++) {
			result += field + " LIKE '%" + words[i] + "%'";
			if (i != size - 1) {
				result += " OR ";
			}
		}
		return result;
	}

	public static List<String> toListCateId(List<String> listKindCate) {
		List<String> result = new ArrayList<String>();
		if (listKindCate == null) {
			return result;
		}
		for (String kindCate : listKindCate) {
			result.add(kindCate.split("-")[0]);
		}
		return result;
	}

	public static List<String> getListCateId(String listString) {
		List<String> result = new ArrayList<String>();
		String substring = listString.substring(1, listString.length() - 1);
		if (!substring.isEmpty()) {
			String[] data = substring.split(",");
			for (String id : data) {
				result.add(id.trim());
			}
		}
		return result;
	}

	public static List<String> getListDecrease(List<String> originals, List<String> listUpdate) {
		if (originals != null && listUpdate != null) {
			for (String id : listUpdate) {
				if(originals.contains(id)) {
					originals.remove(id);
				}
			}
		}
		return originals;
	}
	
	public static List<String> getListIncrease(List<String> originals, List<String> listUpdate) {
		List<String> result = new ArrayList<String>();
		if (originals != null && listUpdate != null) {
			for (String id : listUpdate) {
				if(!originals.contains(id)) {
					result.add(id);
				}
			}
		}
		return result;
	}

}
