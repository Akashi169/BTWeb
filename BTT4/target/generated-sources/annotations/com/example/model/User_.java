package com.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@StaticMetamodel(User.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class User_ {

	
	/**
	 * @see com.example.model.User#passWord
	 **/
	public static volatile SingularAttribute<User, String> passWord;
	
	/**
	 * @see com.example.model.User#createdDate
	 **/
	public static volatile SingularAttribute<User, Date> createdDate;
	
	/**
	 * @see com.example.model.User#phone
	 **/
	public static volatile SingularAttribute<User, String> phone;
	
	/**
	 * @see com.example.model.User#roleid
	 **/
	public static volatile SingularAttribute<User, Integer> roleid;
	
	/**
	 * @see com.example.model.User#id
	 **/
	public static volatile SingularAttribute<User, Integer> id;
	
	/**
	 * @see com.example.model.User#categories
	 **/
	public static volatile ListAttribute<User, Category> categories;
	
	/**
	 * @see com.example.model.User#avatar
	 **/
	public static volatile SingularAttribute<User, String> avatar;
	
	/**
	 * @see com.example.model.User#userName
	 **/
	public static volatile SingularAttribute<User, String> userName;
	
	/**
	 * @see com.example.model.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see com.example.model.User#email
	 **/
	public static volatile SingularAttribute<User, String> email;

	public static final String PASS_WORD = "passWord";
	public static final String CREATED_DATE = "createdDate";
	public static final String PHONE = "phone";
	public static final String ROLEID = "roleid";
	public static final String ID = "id";
	public static final String CATEGORIES = "categories";
	public static final String AVATAR = "avatar";
	public static final String USER_NAME = "userName";
	public static final String EMAIL = "email";

}

