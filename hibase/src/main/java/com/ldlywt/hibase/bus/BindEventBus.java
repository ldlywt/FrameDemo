package com.ldlywt.hibase.bus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 *     author : lex
 *     e-mail : ldlywt@gmail.com
 *     time   : 2017/09/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindEventBus {
}
