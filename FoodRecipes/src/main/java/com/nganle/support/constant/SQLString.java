package com.nganle.support.constant;


public class SQLString {

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
													+ SQLInfo.USER.FIELD_CREATE_TIME + ","
													+ SQLInfo.USER.FIELD_UPDATE_TIME + ","
													+ SQLInfo.USER.FIELD_STATUS + ") "+
													"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		public static final String FIND_BY_ID = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME + " WHERE "+ SQLInfo.USER.FIELD_ID + " = ?";
		public static final String FIND_BY_USER_AND_PASS = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME + 
															" WHERE "+ SQLInfo.USER.FIELD_USER_NAME + " = ? AND "
															+ SQLInfo.USER.FIELD_MD5_PASSWORD + " = ?";
		public static final String FIND_BY_USER_NAME = "SELECT * FROM "+ SQLInfo.USER.TABLE_NAME + 
				" WHERE "+ SQLInfo.USER.FIELD_USER_NAME + " = ?";
	}
}
