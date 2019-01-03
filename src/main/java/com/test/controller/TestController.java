package com.test.controller;

import com.test.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.test.service.TestService;
import com.test.vo.ResultVo;

/**
 * 最佳实践controller
 *
 * @author wulha
 * @date 2019-01-03
 */
@RestController // springmvc注解，使用此类注解表示此类下的接口都是rest风格的，只能返回json、xml等类型数据，不能返回html、jsp等视图，若需返回视图，使用@Controller
@RequestMapping("/test") // springmvc注解，url与此相同即可映射
public class TestController {

    @Autowired // @Autowired为spring注解，声明后按类型注入需要的类，spring框架启动时扫描此类注解，初始化有这些注解的类，之后可以直接使用
    private TestService testService;

    @RequestMapping(value = "sayHi", method = RequestMethod.GET) // springmvc注解，url与此相同即可映射
    public ResultVo<String> sayHi () {
        return ResultVo.success("Hello world!");
    }

    @RequestMapping(value = "sayHi1", method = RequestMethod.GET)
    public ResultVo<Hello> sayHi1 () {
        // 直接使用 testService，不需要new
        return testService.sayHi();
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ResultVo insertHelloStatement(@RequestBody Hello hello) {
        try {
            return testService.insert(hello);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(null);
        }
    }
}
