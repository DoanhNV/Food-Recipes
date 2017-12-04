package com.nganle.support.constant;


public class SQLString {

	public class USER {
		public static final String CREATE_USER = "INSERT INTO " + SQLInfo.USER.TABLE_NAME + "("
													+ SQLInfo.USER.FILED_USER_NAME + ","
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
	}
}
