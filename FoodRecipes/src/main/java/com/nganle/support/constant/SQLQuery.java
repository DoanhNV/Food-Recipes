package com.nganle.support.constant;


public class SQLQuery {

	public class USER {
		public static final String CREATE_USER = "INSERT INTO " + SQLInfo.USER.TABLE_NAME + "("
													+ SQLInfo.USER.FIELD_USER_NAME + ","
													+ SQLInfo.USER.FIELD_FULL_NAME + ","
													+ SQLInfo.USER.FIELD_EMAIL + ","
													+ SQLInfo.USER.FIELD_MD5_PASSWORD + ","
													+ SQLInfo.USER.FIELD_ORIGINAL_PASSWORD + ","
													+ SQLInfo.USER.FIELD_BIRTHDAY + ","
													+ SQLInfo.USER.FIELD_PROFILE_IMAGE + ","
													+ SQLInfo.USER.FIELD_NUMBER_OF_RECIPE + ","
													+ SQLInfo.USER.FIELD_IS_ADMIN + ","
													+ SQLInfo.FIELD_CREATE_TIME + ","
													+ SQLInfo.FIELD_UPDATE_TIME + ","
													+ SQLInfo.FIELD_STATUS + ") "+
													"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		public static final String FIND_BY_ID = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME 
													+ " WHERE "+ SQLInfo.FIELD_ID + " = ?";
		public static final String FIND_BY_USER_AND_PASS = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME 
													+ " WHERE "+ SQLInfo.USER.FIELD_USER_NAME + " = ? AND "
													+ SQLInfo.USER.FIELD_MD5_PASSWORD + " = ?";
		public static final String FIND_BY_USER_NAME = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME 
													+ " WHERE "+ SQLInfo.USER.FIELD_USER_NAME + " = ?";
		public static final String LIST_ALL = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME;
		
		public static final String DELETE_BY_ID = "DELETE FROM "+ SQLInfo.USER.TABLE_NAME + " WHERE "
													+ SQLInfo.FIELD_ID + " = ?";
		public static final String UPDATE_STATUS = "UPDATE "+ SQLInfo.USER.TABLE_NAME + " SET "
													+ SQLInfo.FIELD_STATUS +" = ? WHERE "
													+ SQLInfo.FIELD_ID + " = ?";
		public static final String GET_TOP_ORDER = " SELECT * FROM " + SQLInfo.USER.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_STATUS  +" = 1 "
													+ " ORDER BY ? ? "
													+ " LIMIT ?";
		public static final String FIND_IN_LIST = "SELECT * FROM " + SQLInfo.USER.TABLE_NAME 
													+ " WHERE " + SQLInfo.FIELD_ID + " IN %s";
		public static final String UPDATE = " UPDATE " + SQLInfo.USER.TABLE_NAME + " SET "
													+ SQLInfo.USER.FIELD_FULL_NAME + "= ?,"
													+ SQLInfo.USER.FIELD_EMAIL + "= ?,"
													+ SQLInfo.USER.FIELD_ORIGINAL_PASSWORD + "= ?,"
													+ SQLInfo.USER.FIELD_MD5_PASSWORD + "= ?,"
													+ SQLInfo.USER.FIELD_PROFILE_IMAGE + "= ?,"
													+ SQLInfo.USER.FIELD_BIRTHDAY + "= ?,"
													+ SQLInfo.FIELD_UPDATE_TIME + "= ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "= ?"; 
		public static final String 	SAVED_RECIPE = " UPDATE " + SQLInfo.USER.TABLE_NAME + " SET "
													+  SQLInfo.USER.FIELD_RECIPE_SAVE_IDS + " = ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "=?";	
	}
	
	
	public class MATERIAL {
		public static final String CREATE = "INSERT INTO " + SQLInfo.MATERIAL.TABLE_NAME + "("
													+ SQLInfo.MATERIAL.FIELD_MATERIAL_NAME + "," 
													+ SQLInfo.MATERIAL.FIELD_FEATURE_IMAGE + ","
													+ SQLInfo.FIELD_CREATE_TIME + ","
													+ SQLInfo.FIELD_UPDATE_TIME + ","
													+ SQLInfo.FIELD_CREATER_ID + ","
													+ SQLInfo.FIELD_STATUS + " )"
													+ " VALUE(?,?,?,?,?,?)";
		public static final String UPDATE = "UPDATE " + SQLInfo.MATERIAL.TABLE_NAME + " SET "
													+ SQLInfo.MATERIAL.FIELD_MATERIAL_NAME + " = ?," 
													+ SQLInfo.MATERIAL.FIELD_FEATURE_IMAGE + "= ?,"
													+ SQLInfo.FIELD_UPDATE_TIME + " = ?,"
													+ SQLInfo.FIELD_STATUS + " = ?"
													+ " WHERE "+ SQLInfo.FIELD_ID + " = ?";
		public static final String DELETE = "DELETE FROM " + SQLInfo.MATERIAL.TABLE_NAME
													+ " WHERE "+ SQLInfo.FIELD_ID + " = ?";
		
		public static final String GET_BY_ID = "SELECT * FROM " + SQLInfo.MATERIAL.TABLE_NAME
				+ " WHERE "+ SQLInfo.FIELD_ID + " = ?";
		
		public static final String LIST_ALL = "SELECT * FROM " + SQLInfo.MATERIAL.TABLE_NAME;
		
		public static final String GET_TOP_LIMIT = "SELECT * FROM "+ SQLInfo.MATERIAL.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_STATUS + "= 1"
													+ " ORDER BY ? ?"
													+ " LIMIT ?";
		
	}
	
	
	public class KINDOFCATE {
		public static final String CREATE = "INSERT INTO "+ SQLInfo.KIND_OF_CATE.TABLE_NAME + "("
													+ SQLInfo.KIND_OF_CATE.FIELD_KIND_TITLE + ","
													+ SQLInfo.FIELD_CREATE_TIME + ","
													+ SQLInfo.FIELD_UPDATE_TIME+ ","
													+ SQLInfo.FIELD_CREATER_ID + ","
													+ SQLInfo.FIELD_STATUS + ")"
													+ "VALUE(?,?,?,?,?)";
		public static final String UPDATE = "UPDATE "+ SQLInfo.KIND_OF_CATE.TABLE_NAME + " SET "
													+ SQLInfo.KIND_OF_CATE.FIELD_KIND_TITLE + "= ?,"
													+ SQLInfo.FIELD_UPDATE_TIME + "= ? ,"
													+ SQLInfo.FIELD_STATUS + "= ? "
													+ " WHERE "+ SQLInfo.FIELD_ID + "= ?";
		public static final String GET_BY_ID = "SELECT * FROM "+ SQLInfo.KIND_OF_CATE.TABLE_NAME
													+ " WHERE "+ SQLInfo.FIELD_ID +"= ?";
		public static final String LIST_ALL = "SELECT * FROM "+ SQLInfo.KIND_OF_CATE.TABLE_NAME;
		
		public static final String DELETE = "DELETE FROM "+ SQLInfo.KIND_OF_CATE.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_ID + "= ?";
	}
	
	public class RECIPE_CATE {
		public static final String CREATE = "INSERT INTO "+ SQLInfo.RECIPE_CATE.TABLE_NAME + "("
													+ SQLInfo.RECIPE_CATE.FIELD_CATE_TITLE + ","
													+ SQLInfo.RECIPE_CATE.FIELD_KIND_ID + ","
													+ SQLInfo.FIELD_CREATE_TIME +","
													+ SQLInfo.FIELD_UPDATE_TIME +","
													+ SQLInfo.RECIPE_CATE.FIELD_NUMBER_OF_RECIPE +","
													+ SQLInfo.FIELD_CREATER_ID +","
													+ SQLInfo.FIELD_STATUS +")"
													+ " VALUE(?,?,?,?,?,?,?)";
		public static final String UPDATE = "UPDATE " + SQLInfo.RECIPE_CATE.TABLE_NAME + " SET "
													+ SQLInfo.RECIPE_CATE.FIELD_CATE_TITLE + " = ?,"
													+ SQLInfo.RECIPE_CATE.FIELD_KIND_ID + " = ?,"
													+ SQLInfo.FIELD_UPDATE_TIME +" = ?,"
													+ SQLInfo.FIELD_STATUS +" = ?"
													+ " WHERE "+ SQLInfo.FIELD_ID +"= ?";
		public static final String DELETE = "DELETE FROM "+ SQLInfo.RECIPE_CATE.TABLE_NAME 
													+ " WHERE "+ SQLInfo.FIELD_ID + " = ?";
		public static final String GET_BY_ID = "SELECT * FROM "+SQLInfo.RECIPE_CATE.TABLE_NAME
													+ " WHERE "+ SQLInfo.FIELD_ID +  "=?";
		public static final String LIST_ALL = "SELECT * FROM "+ SQLInfo.RECIPE_CATE.TABLE_NAME;
		
		public static final String INCREASE_NUMBER_RECIPE = " UPDATE " + SQLInfo.RECIPE_CATE.TABLE_NAME
													+ " SET " + SQLInfo.RECIPE_CATE.FIELD_NUMBER_OF_RECIPE + " = " + SQLInfo.RECIPE_CATE.FIELD_NUMBER_OF_RECIPE + " + 1"
													+ " WHERE " + SQLInfo.FIELD_ID + " IN %s";
		
		public static final String DECREASE_NUMBER_RECIPE = " UPDATE " + SQLInfo.RECIPE_CATE.TABLE_NAME
													+ " SET " + SQLInfo.RECIPE_CATE.FIELD_NUMBER_OF_RECIPE + " = " + SQLInfo.RECIPE_CATE.FIELD_NUMBER_OF_RECIPE + " - 1"
													+ " WHERE " + SQLInfo.FIELD_ID + " IN %s";
		public static final String GET_RANDOM_MENU = "SELECT "+SQLInfo.RECIPE_CATE.FIELD_CATE_TITLE + "," + SQLInfo.FIELD_ID
													+ " FROM " + SQLInfo.RECIPE_CATE.TABLE_NAME
													+ " ORDER BY RAND() "
													+ " LIMIT ?";
		
	}
	
	public class TIP_CATE {
		public static final String CREATE = "INSERT INTO "+ SQLInfo.TIP_CATE.TABLE_NAME + "("
													+ SQLInfo.TIP_CATE.FIELD_CATE_NAME + ","
													+ SQLInfo.FIELD_CREATE_TIME + ","
													+ SQLInfo.FIELD_UPDATE_TIME + ","
													+ SQLInfo.TIP_CATE.FIELD_NUMBER_OF_TIPS + ","
													+ SQLInfo.FIELD_CREATER_ID + ","
													+ SQLInfo.FIELD_STATUS + ")"
													+ "VALUE(?,?,?,?,?,?)";
		public static final String UPDATE = "UPDATE " + SQLInfo.TIP_CATE.TABLE_NAME + " SET "
													+ SQLInfo.TIP_CATE.FIELD_CATE_NAME + "= ? ,"
													+ SQLInfo.FIELD_UPDATE_TIME + "= ? ,"
													+ SQLInfo.FIELD_STATUS + "= ? "
													+ " WHERE " + SQLInfo.FIELD_ID + " = ?";
		public static final String DELETE = "DELETE FROM "+ SQLInfo.TIP_CATE.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_ID + " = ?";
	
		public static final String GET_BY_ID = "SELECT * FROM "+SQLInfo.TIP_CATE.TABLE_NAME
													+ " WHERE "+ SQLInfo.FIELD_ID +  "=?";
		public static final String LIST_ALL = "SELECT * FROM "+ SQLInfo.TIP_CATE.TABLE_NAME;
	}
	
	public class TIP {
		public static final String CREATE = "INSERT INTO "+ SQLInfo.TIP.TABLE_NAME + "("
													+ SQLInfo.TIP.TITLE + ","
													+ SQLInfo.TIP.CONTENT + ","
													+ SQLInfo.TIP.TIP_CATE_IDS + ","
													+ SQLInfo.FIELD_CREATE_TIME + ","
													+ SQLInfo.FIELD_UPDATE_TIME + ","
													+ SQLInfo.TIP.FEATURE_IMAGE + ","
													+ SQLInfo.TIP.SAVED_USER_IDS + ","
													+ SQLInfo.FIELD_CREATER_ID + ","
													+ SQLInfo.TIP.VIEW + ","
													+ SQLInfo.FIELD_STATUS + ")"
													+ " VALUE(?,?,?,?,?,?,?,?,?,?)";
		public static final String UPDATE = "UPDATE "+ SQLInfo.TIP.TABLE_NAME + " SET "
													+ SQLInfo.TIP.TITLE + " = ?, "
													+ SQLInfo.TIP.CONTENT + " = ?, "
													+ SQLInfo.TIP.TIP_CATE_IDS + " = ?, "
													+ SQLInfo.FIELD_UPDATE_TIME + " = ?, "
													+ SQLInfo.TIP.FEATURE_IMAGE + " = ?, "
													+ SQLInfo.TIP.SAVED_USER_IDS + " = ?,"
													+ SQLInfo.FIELD_STATUS + " = ? "
													+ " WHERE "+ SQLInfo.FIELD_ID + " = ?";
		public static final String DELETE = "DELETE FROM "+ SQLInfo.TIP.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_ID +" = ?";
		
		public static final String GET_BY_ID = "SELECT * FROM "+ SQLInfo.TIP.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_ID +" = ?";
		
		public static final String LIST_ALL = "SELECT * FROM "+ SQLInfo.TIP.TABLE_NAME;
		
		public static final String GET_TOP_LIMIT = "SELECT * FROM " + SQLInfo.TIP.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_STATUS + "= 1"
													+ " ORDER BY ? ?"
													+ " LIMIT ?";
		public static final String SEARCH_BY_LIST_ID = "SELECT * FROM " + SQLInfo.TIP.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_ID  + " IN %s";
		public static final String SEARCH_BY_CATE_ID = "SELECT * FROM "+ SQLInfo.TIP.TABLE_NAME
													+ " WHERE %s";
		public static final String 	GET_SUGGEST = "SELECT * FROM "+ SQLInfo.TIP.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_ID +" != ? "
													+ " LIMIT ?";
		public static final String 	INCRREASE_VIEW = " UPDATE " + SQLInfo.TIP.TABLE_NAME 
													+ " SET " +  SQLInfo.TIP.VIEW + " = " + SQLInfo.TIP.VIEW + " + 1"
													+ " WHERE " + SQLInfo.FIELD_ID + " = ?";
	}
	
	public class RECIPE {
		public static final String 	CREATE = "INSERT INTO " + SQLInfo.RECIPE.TABLE_NAME + "("
													+ SQLInfo.RECIPE.TITLE + ","
													+ SQLInfo.RECIPE.CONTENT + ","
													+ SQLInfo.RECIPE.FEATURE_IMAGE + ","
													+ SQLInfo.RECIPE.COST + ","
													+ SQLInfo.RECIPE.MATERIAL_IDS + ","
													+ SQLInfo.RECIPE.SAVED_USER_IDS + ","
													+ SQLInfo.RECIPE.LIKE_IDS + ","
													+ SQLInfo.RECIPE.COMMENT_IDS + ","
													+ SQLInfo.FIELD_CREATE_TIME + ","
													+ SQLInfo.FIELD_UPDATE_TIME + ","
													+ SQLInfo.FIELD_CREATER_ID + ","
													+ SQLInfo.FIELD_STATUS + ","
													+ SQLInfo.RECIPE.ESTIMATE_TIME + ","
													+ SQLInfo.RECIPE.RECIPE_CATE_IDS +","
													+ SQLInfo.RECIPE.VIDEO_URL +")"
													+ " VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		public static final String UPDATE = "UPDATE " + SQLInfo.RECIPE.TABLE_NAME + " SET "
													+ SQLInfo.RECIPE.TITLE + " = ?,"
													+ SQLInfo.RECIPE.CONTENT + " = ?,"
													+ SQLInfo.RECIPE.FEATURE_IMAGE + " = ?,"
													+ SQLInfo.RECIPE.COST + " = ?,"
													+ SQLInfo.RECIPE.MATERIAL_IDS + " = ?,"
													+ SQLInfo.FIELD_UPDATE_TIME + " = ?,"
													+ SQLInfo.RECIPE.ESTIMATE_TIME + " = ?,"
													+ SQLInfo.RECIPE.VIDEO_URL +" = ?,"
													+ SQLInfo.RECIPE.RECIPE_CATE_IDS +"= ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "= ?";
		public static final String DELETE  = "DELETE FROM " + SQLInfo.RECIPE.TABLE_NAME 
													+ " WHERE " + SQLInfo.FIELD_ID  + "= ?";
		public static final String GET_BY_ID = "SELECT * FROM "+ SQLInfo.RECIPE.TABLE_NAME
													+ " WHERE "+ SQLInfo.FIELD_ID + "=?";
		public static final String LIST_ALL = "SELECT * FROM " + SQLInfo.RECIPE.TABLE_NAME;
		
		public static final String CHANGE_STATUS = "UPDATE " + SQLInfo.RECIPE.TABLE_NAME + " SET "
													+ SQLInfo.FIELD_STATUS + "= ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "=?";
		public static final String ADD_SAVED_IDS = "UPDATE " + SQLInfo.RECIPE.TABLE_NAME + " SET "
													+ SQLInfo.RECIPE.SAVED_USER_IDS + "= ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "= ?";
		
		public static final String ADD_LIKED_IDS = "UPDATE " + SQLInfo.RECIPE.TABLE_NAME + " SET "
													+ SQLInfo.RECIPE.LIKE_IDS + "= ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "= ?";
		public static final String ADD_COMMENT_IDS = "UPDATE " + SQLInfo.RECIPE.TABLE_NAME + " SET "
													+ SQLInfo.RECIPE.COMMENT_IDS + "= ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "= ?";
		public static final String CHANGE_SLIDE = "UPDATE " + SQLInfo.RECIPE.TABLE_NAME + " SET "
													+ SQLInfo.RECIPE.IS_SLIDE + "= ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "= ?";
		public static final String GET_SLIDE = "SELECT * FROM " + SQLInfo.RECIPE.TABLE_NAME
													+ " WHERE " + SQLInfo.RECIPE.IS_SLIDE + " = 1" ;
		public static final String GET_TOP_VIEW = "SELECT * FROM " + SQLInfo.RECIPE.TABLE_NAME 
													+ " ORDER BY " + SQLInfo.RECIPE.VIEWS + " DESC LIMIT ?";
		public static final String SEARCH_BY_TITLE = " SELECT * FROM " + SQLInfo.RECIPE.TABLE_NAME 
													+ " WHERE  %s collate utf8_unicode_ci" ;
		public static final String SEARCH_BY_CATE = " SELECT * FROM " + SQLInfo.RECIPE.TABLE_NAME
													+ " WHERE  %s  "; 			//special - multiple like
		public static final String SEARCH_BY_MATERIAL = "SELECT * FROM "+ SQLInfo.RECIPE.TABLE_NAME + 
													" WHERE %s  LIMIT %d";													//special - multiple like
		public static final String GET_TOP_NEWS = "SELECT * FROM " + SQLInfo.RECIPE.TABLE_NAME 
													+ " WHERE " + SQLInfo.RECIPE.IS_SLIDE + " = 0"
													+ " AND " +  SQLInfo.FIELD_STATUS + " = 1"
													+ " ORDER BY " + SQLInfo.FIELD_CREATE_TIME + " DESC "
													+ " LIMIT ? ";
		public static final String SEARCH_BY_LIST_ID = "SELECT * FROM " + SQLInfo.RECIPE.TABLE_NAME
													+ " WHERE " + SQLInfo.FIELD_ID + " IN %s";
		public static final String INCREASE_VIEW = " UPDATE " + SQLInfo.RECIPE.TABLE_NAME 
													+ " SET " + SQLInfo.RECIPE.VIEWS + " = " + SQLInfo.RECIPE.VIEWS + " + 1"
													+ " WHERE " + SQLInfo.FIELD_ID + " = ?";
		public static final String GET_BY_CATE_ID = "SELECT * FROM "+ SQLInfo.RECIPE.TABLE_NAME
													+ " WHERE "+ SQLInfo.RECIPE.RECIPE_CATE_IDS + " LIKE %s";
		
	}
	
	public class COMMENT {
		public static final String CREATE = "INSERT INTO " + SQLInfo.COMMENT.TABLE_NAME + "("
													+ SQLInfo.COMMENT.CONTENT + ","
													+ SQLInfo.COMMENT.RECIPE_ID + ","
													+ SQLInfo.COMMENT.USER_ID + ","
													+ SQLInfo.FIELD_CREATE_TIME + ","
													+ SQLInfo.FIELD_UPDATE_TIME + ","
													+ SQLInfo.FIELD_STATUS + ")"
													+ " VALUE(?,?,?,?,?,?)";
		public static final String UPDATE = "UPDATE" + SQLInfo.COMMENT.TABLE_NAME + " SET "
													+ SQLInfo.COMMENT.CONTENT + "= ?,"
													+ SQLInfo.FIELD_UPDATE_TIME + "= ?,"
													+ SQLInfo.FIELD_STATUS + "= ?"
													+ " WHERE " + SQLInfo.FIELD_ID + "= ?";
		public static final String DELETE = "DELETE FROM " + SQLInfo.COMMENT.TABLE_NAME 
													+ "WHERE " + SQLInfo.FIELD_ID + "= ?";
		public static final String GET_BY_RECIPE_ID = "SELECT * FROM " + SQLInfo.COMMENT.TABLE_NAME
													+ " WHERE "+ SQLInfo.COMMENT.RECIPE_ID + "= ?";
		public static final String LIST_ALL = "SELECT * FROM " + SQLInfo.COMMENT.TABLE_NAME;
	}
}
