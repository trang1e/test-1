package com.test.dao.mapper;

import com.test.model.Hello;

public interface TestMapper { // 类名需与写sql的xml文件名一致

    Hello sayHi(); // 方法名需与xml文件标签方法一致

    Long insert(Hello hello);
}
