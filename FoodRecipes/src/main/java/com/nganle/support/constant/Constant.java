package com.nganle.support.constant;

public class Constant {

	public class SESSION_NAME {
		public static final String ADMIN_SESSION = "admin_session";
		public static final String USER_SESSION = "sessionUser";
		public static final String FOOTER_SESSION = "footer_session";
		public static final String MENU_SESSION = "menu_session";
	}

	public class ATTRIBUTE_NAME {
		public static final String LIST_USER = "listuser";
		public static final String USER_PAGE = "userpages";
		public static final String CURRENT_PAGE = "currentpage";
		public static final String FISRT_PAGE = "first";
		public static final String LAST_PAGE = "last";

		// material
		public static final String LIST_MATERIAL = "listmaterial";
		public static final String DISPLAY_PAGE = "materialpages";
		public static final String MATERIAL = "material";
		public static final String lIST_MATERIAL_TITLE = "list_material_title";

		// kind of cate
		public static final String LIST_KIND = "listkind";
		public static final String KIND = "kind";

		// recipe cate
		public static final String LIST_RECIPE_CATE = "list_recipecate";
		public static final String RECIPE_CATE = "recipecate";

		// tip cate
		public static final String LIST_TIP_CATE = "list_tipcate";
		public static final String TIP_CATE = "tipcate";

		// tip
		public static final String LIST_TIP= "list_tip";
		public static final String TIP = "tip";
		public static final String BASIC_CATE = "basic_cate";
		public static final String TIP_SUGGEST = "tip_suggest";
		
		// Recipe
		public static final String LIST_KIND_CATE = "list_kind_cate";
		public static final String RECIPE_HOUR = "recipe_hours";
		public static final String RECIPE_MINUTE = "recipe_minutes";
		public static final String LIST_RECIPE = "list_recipe";
		public static final String LIST_STEP = "list_step";
		public static final String RECIPE = "recipe";
		public static final String COST = "cost";
		public static final String LIST_CHECKED_MATERIAL = "list_checked_material";
		public static final String ADDED_HOUR = "added_hour";
		public static final String ADDED_MINUTE = "added_minute";
		public static final String LIST_KIND_CATE_BUFFER = "list_kind_cate_buffer";
		
		// home
		public static final String SLIDE = "slide";
		public static final String TOP_RECIPE = "top_recipe";
		public static final String TOP_NEW_RECIPE = "top_new_recipe";
		public static final String RECIPE_DETAIL = "recipe_detail";
		public static final String RECIPE_DETAIL_SUGGEST = "recipe_detail_suggest";
		public static final String USER = "user_register";
		public static final String LIST_COMMENT = "list_comment";
		public static final String USER_PROFILE = "user_profile";
		public static final String KIND_CATE = "kind_cate";
		public static final String SEARCH_KEY = "search_key";
		public static final String DATA_BUFFER = "data_buffer";
		
		//error
		public static final String EXIST_RECIPE_WITH_CATE = "exist_recipe_with_cate";
	}

	public class STATUS {
		public static final String ACTIVE = "active";
		public static final int ACTIVE_VALUE = 1;
		public static final int DEACTIVE_VALUE = 0;
		public static final String DEACTIVE = "deactive";
	}

	public static final int NUMBER_PERPAGE = 8;
	public static final int NUMBER_PER_PAGE_SEARCH = 16;
	public static final int NUMBER_PER_PAGE_TIP_SEARCH = 12;

	public static final String FILE_STORE = "F:/upload/";
	
	public class HTML_ATTRIBUTE {
		public static final String CHECKED_VALUE = "checked";
	}
	
	public static final String STEP_ELEMENT_SEPARATOR = "###";
	public static final String STEP_SEPARATOR = "@@";
	public static final String ESTIMATE_TIME_SEPARATOR = "@";
	public static final String HOUR_SUFFIX = "h";
	public static final String MINUTE_SUFFIX = "P";
	
	public class SQL_CHARACTER {
		public static final String DESC = "DESC";
	}
	
	public static final int MAX_SUGGEST_TITLE_LENGTH = 25;
	
	public class HOME {
		public static final String DEFAULT_IMAGE = "/resources/asset/img/cooker.png";
	}
}
