package com.qinxiandiqi.annotationprocessordemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Jianan on 2015/10/24.
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface BeanInfo {
}
