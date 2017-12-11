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
													+ SQLInfo.USER.FIELD_RECIPE_SAVE_IDS + ","
													+ SQLInfo.USER.FIELD_TIPE_SAVE_IDS + ","
													+ SQLInfo.USER.FIELD_PROFILE_IMAGE + ","
													+ SQLInfo.USER.FIELD_NUMBER_OF_RECIPE + ","
													+ SQLInfo.USER.FIELD_IS_ADMIN + ","
													+ SQLInfo.FIELD_CREATE_TIME + ","
													+ SQLInfo.FIELD_UPDATE_TIME + ","
													+ SQLInfo.FIELD_STATUS + ") "+
													"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		public static final String FIND_BY_ID = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME + " WHERE "+ SQLInfo.FIELD_ID + " = ?";
		public static final String FIND_BY_USER_AND_PASS = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME + 
															" WHERE "+ SQLInfo.USER.FIELD_USER_NAME + " = ? AND "
															+ SQLInfo.USER.FIELD_MD5_PASSWORD + " = ?";
		public static final String FIND_BY_USER_NAME = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME + 
				" WHERE "+ SQLInfo.USER.FIELD_USER_NAME + " = ?";
		public static final String LIST_ALL = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME;
		
		public static final String DELETE_BY_ID = "DELETE FROM "+ SQLInfo.USER.TABLE_NAME + " WHERE "+ SQLInfo.FIELD_ID + " = ?";
		public static final String UPDATE_STATUS = "UPDATE "+ SQLInfo.USER.TABLE_NAME + " SET "
													+ SQLInfo.FIELD_STATUS +" = ? WHERE "
													+ SQLInfo.FIELD_ID + " = ?";
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
		
		public static final String LIST_ALL = "SELECT *  FROM "+ SQLInfo.TIP.TABLE_NAME;
	}
}
