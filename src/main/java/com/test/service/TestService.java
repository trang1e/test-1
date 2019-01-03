package com.test.service;

import com.test.model.Hello;
import com.test.vo.ResultVo;

/**
 * 最佳实践-业务处理层
 *
 * @author wulha
 * @date 2019-01-03
 */
public interface TestService {

    ResultVo<Hello> sayHi();

    ResultVo insert(Hello hello) throws Exception;
}
