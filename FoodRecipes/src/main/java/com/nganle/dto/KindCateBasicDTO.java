package com.nganle.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.nganle.entity.KindOfCate;
import com.nganle.entity.RecipeCategory;

public class KindCateBasicDTO {
	private String title;
	private List<RecipeCateBasic> cates;

	public KindCateBasicDTO(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<RecipeCateBasic> getCates() {
		return cates;
	}

	public void setCates(List<RecipeCateBasic> cates) {
		this.cates = cates;
	}

	public static List<KindCateBasicDTO> toListDTO(List<KindOfCate> kinds, List<RecipeCategory> cates) {
		List<KindCateBasicDTO> result = new ArrayList<KindCateBasicDTO>();
		Collections.sort(cates, createComparator());
		for (KindOfCate kind : kinds) {
			KindCateBasicDTO kbDTO = new KindCateBasicDTO(kind.getKindTitle());
			List<RecipeCateBasic> cates2 = new ArrayList<RecipeCateBasic>();
			kbDTO.setCates(cates2);
			boolean add = false;
			for (RecipeCategory cate : cates) {
				if(cate.getKindId() == kind.getId()) {
					add = true;
					cates2.add(new RecipeCateBasic(cate.getId(), cate.getCateTitle()));
				}else if(add){
					break;
				}
			}
			result.add(kbDTO);
		}
		return result;
	}

	public static Comparator<RecipeCategory> createComparator() {
		return new Comparator<RecipeCategory>() {
			public int compare(RecipeCategory cate1, RecipeCategory cate2) {
				return cate1.getKindId() - cate2.getKindId();
			}

		};
	}

}
