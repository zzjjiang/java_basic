package com.zzj.reflect.basic;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 自定义注解
 * @createTime 2020年02月13日 00:32
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PARAMETER, TYPE})
@Documented
public @interface MyAnnotation {
    String value();
}
