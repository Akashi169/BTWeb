package com.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Role.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Role_ {

	
	/**
	 * @see com.example.model.Role#name
	 **/
	public static volatile SingularAttribute<Role, String> name;
	
	/**
	 * @see com.example.model.Role#id
	 **/
	public static volatile SingularAttribute<Role, Integer> id;
	
	/**
	 * @see com.example.model.Role
	 **/
	public static volatile EntityType<Role> class_;
	
	/**
	 * @see com.example.model.Role#user
	 **/
	public static volatile ListAttribute<Role, User> user;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String USER = "user";

}

