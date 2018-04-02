package com.mthumb.a45doSegundoWeb.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Annotation de mapeamento do JSON na entidade
 *  @author lucas
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONMapper{
	String field();
	String on();
}