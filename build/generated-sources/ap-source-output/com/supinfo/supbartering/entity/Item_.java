package com.supinfo.supbartering.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, String> picturePath;
	public static volatile SingularAttribute<Item, String> dateCreation;
	public static volatile SingularAttribute<Item, Float> price;
	public static volatile SingularAttribute<Item, String> name;
	public static volatile SingularAttribute<Item, String> description;
	public static volatile SingularAttribute<Item, Long> id;
	public static volatile SingularAttribute<Item, String> type;
	public static volatile SingularAttribute<Item, Long> idCreator;

}

