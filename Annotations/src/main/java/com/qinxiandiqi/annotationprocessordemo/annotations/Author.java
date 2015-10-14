package com.qinxiandiqi.annotationprocessordemo.annotations;

/**
 * Created by Jianan on 2015/10/14.
 */
public @interface Author {
    String name();
    String created();
    int revision() default 1;
    String[] reviewers() default {};
}
