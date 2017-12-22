package com.nganle.support;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nganle.dao.impl.RecipeCategoryDAOImpl;
import com.nganle.dto.MaterialSerchDTO;
import com.nganle.dto.RecipeCateSearchDTO;
import com.nganle.entity.Comment;
import com.nganle.entity.KindOfCate;
import com.nganle.entity.RecipeCategory;
import com.nganle.entity.User;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.Utils;

public class EntitySupport {
	
	public static final List<RecipeCategory> LIST_MENU = new RecipeCategoryDAOImpl().listMenu(4);
	
	public static User initUser() {
		User user = new User();
		user.setBirthday(new Date());
		user.setCreateTime(new Date(System.currentTimeMillis()));
		user.setUpdateTime(new Date(System.currentTimeMillis()));
		user.setRecipeSavedIds(new ArrayList<String>());
		user.setTipSavedIds(new ArrayList<String>());
		return user;
	}
	
	public static void initRegisterUser(User user) {
		user.setBirthday(new Date());
		user.setCreateTime(new Date(System.currentTimeMillis()));
		user.setUpdateTime(new Date(System.currentTimeMillis()));
		user.setRecipeSavedIds(new ArrayList<String>());
		user.setTipSavedIds(new ArrayList<String>());
		user.setProfileImage(Constant.HOME.DEFAULT_IMAGE);
	}
	
	public static void transferToByteImage(User user) {
		if(!user.getProfileImage().equals(Constant.HOME.DEFAULT_IMAGE)) {
			user.setProfileImage(Utils.convertToFileByte(user.getProfileImage()));
		}
	}
	
	public static List<Integer> getListUserIdFromComments(List<Comment> comments) {
		List<Integer> ids = new ArrayList<Integer>();
		for (Comment comment : comments) {
			ids.add(comment.getUserId());
		}
		return ids;
	}
	
	public static List<String> toListKindCate(List<KindOfCate> kinds,List<Integer> cates){
		List<String> result = new ArrayList<String>();
		for (KindOfCate kind : kinds) {
			for (int cateId : cates) {
				if(kind.getId() == cateId) {
					result.add(cateId + "-" + kind.getId());
				}
			}
		}
		return result;
	}
	
	public static List<String> checkedMaterial(List<MaterialSerchDTO> listMaterial,List<Integer> materialIds) {
		List<String> titles = new ArrayList<String>();
		for (int id : materialIds) {
			for (MaterialSerchDTO material : listMaterial) {
				if(id == material.getId()) {
					titles.add(material.getTitle());
					material.setChecked("checked");
					break;
				}
			}
		}
		return titles;
	}
	
	public static void checkedCate(List<RecipeCateSearchDTO> listCate,String[] cateIds) {
		for (String id : cateIds) {
			int mId = Integer.parseInt(id);
			for (RecipeCateSearchDTO material : listCate) {
				if(mId == material.getId()) {
					material.setChecked("checked");
					break;
				}
			}
		}
	}
	
	public static List<String> getListIdFfromKindCate(List<String> listKindCate){
		List<String> result = new ArrayList<String>();
		if(listKindCate == null) {
			return result;
		}
		for (String kindCate : listKindCate) {
			result.add(kindCate.split("-")[0]);
		}
		return result;
		
	}
}
