package com.nganle.support.constant;

public class SQLInfo {

	public static final String FIELD_ID = "id";
	public static final String FIELD_CREATE_TIME = "create_time";
	public static final String FIELD_UPDATE_TIME = "update_time";
	public static final String FIELD_STATUS = "status";
	public static final String FIELD_CREATER_ID = "creater_id";

	public class USER {
		public static final String TABLE_NAME = "user";
		public static final String FIELD_USER_NAME = "user_name";
		public static final String FIELD_FULL_NAME = "full_name";
		public static final String FIELD_EMAIL = "email";
		public static final String FIELD_MD5_PASSWORD = "md5_password";
		public static final String FIELD_ORIGINAL_PASSWORD = "original_password";
		public static final String FIELD_BIRTHDAY = "birth_day";
		public static final String FIELD_RECIPE_SAVE_IDS = "recipe_save_ids";
		public static final String FIELD_TIPE_SAVE_IDS = "tips_save_ids";
		public static final String FIELD_PROFILE_IMAGE = "profile_image";
		public static final String FIELD_NUMBER_OF_RECIPE = "number_of_recipe";
		public static final String FIELD_IS_ADMIN = "is_admin";
	}

	public class MATERIAL {
		public static final String TABLE_NAME = "material";
		public static final String FIELD_MATERIAL_NAME = "material_name";
		public static final String FIELD_FEATURE_IMAGE = "feature_image";
	}

	public class KIND_OF_CATE {
		public static final String TABLE_NAME = "kindofcate";
		public static final String FIELD_KIND_TITLE = "kind_title";
	}

	public class RECIPE_CATE {
		public static final String TABLE_NAME = "recipecate";
		public static final String FIELD_CATE_TITLE = "cate_title";
		public static final String FIELD_KIND_ID = "kind_id";
		public static final String FIELD_NUMBER_OF_RECIPE = "number_of_recipe";
	}
	
	public class TIP_CATE{
		public static final String TABLE_NAME = "tipcate";
		public static final String FIELD_CATE_NAME = "cate_name";
		public static final String FIELD_NUMBER_OF_TIPS = "number_of_tips";
	}
	
	public class TIP {
		public static final String TABLE_NAME = "tip";
		public static final String TITLE =  "title";
		public static final String CONTENT = "content";
		public static final String TIP_CATE_IDS = "tip_cate_ids";
		public static final String FEATURE_IMAGE = "feature_image";
		public static final String  SAVED_USER_IDS = "saved_user_ids";
		public static final String  VIEW = "view";
	}
}
