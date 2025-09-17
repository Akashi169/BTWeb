package com.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Category_ {

	
	/**
	 * @see com.example.model.Category#imageUrl
	 **/
	public static volatile SingularAttribute<Category, String> imageUrl;
	
	/**
	 * @see com.example.model.Category#name
	 **/
	public static volatile SingularAttribute<Category, String> name;
	
	/**
	 * @see com.example.model.Category#id
	 **/
	public static volatile SingularAttribute<Category, Integer> id;
	
	/**
	 * @see com.example.model.Category
	 **/
	public static volatile EntityType<Category> class_;
	
	/**
	 * @see com.example.model.Category#user
	 **/
	public static volatile SingularAttribute<Category, User> user;

	public static final String IMAGE_URL = "imageUrl";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String USER = "user";

}

