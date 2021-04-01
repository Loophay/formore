package com.loock.thinkmore.test.reflect;

import com.loock.thinkmore.test.entity.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * 反射的测试
 */
public class ReflectTest {

    @Test
    public void test1() throws IllegalAccessException {
        User user = new User();

        user.setAge(18);
        user.setGender(1);
        user.setUserName("张三");
        user.setPassword("1234567890");

        Object obj = user;
        final Class<?> clz = obj.getClass();
        System.out.println(clz.getTypeName());

        Field[] declaredFields = clz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            System.out.println(field.getName() + "的类型是:" + field.getType());
            String s = field.get(obj).toString();
            System.out.println(s);
            System.out.println(s.getBytes());
        }
    }
}
