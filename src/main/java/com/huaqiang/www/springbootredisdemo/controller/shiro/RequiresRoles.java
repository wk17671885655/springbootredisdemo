package com.huaqiang.www.springbootredisdemo.controller.shiro;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})//@Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages
// 、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量
// （如循环变量、catch参数）。在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
@Retention(RetentionPolicy.RUNTIME)
/*注解@Retention可以用来修饰注解，是注解的注解，称为元注解。
        Retention注解有一个属性value，是RetentionPolicy类型的，Enum RetentionPolicy是一个枚举类型，
        1.RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
   2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
        */
public @interface RequiresRoles {

    /**
     * A single String role name or multiple comma-delimitted role names required in order for the method
     * invocation to be allowed.
     */
    String[] value();

    /**
     * The logical operation for the permission check in case multiple roles are specified. AND is the default
     *
     * @since 1.1.0
     */
//    Logical logical() default Logical.OR;
//    Logical logical() default Logical.OR;
}
