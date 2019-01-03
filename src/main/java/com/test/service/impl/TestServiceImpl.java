package com.test.service.impl;

import com.test.dao.mapper.TestMapper;
import com.test.model.Hello;
import com.test.service.TestService;
import com.test.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 最佳实践-业务处理类实现
 */
@Service // spring注解，使用此注解表示此类在工程启动时需要初始化
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public ResultVo<Hello> sayHi() {
        Hello hello = testMapper.sayHi();
        return ResultVo.success(hello);
    }

    /**
     * 插入，添加事务
     *
     * @param hello
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class) // 开启事务，若执行成功，commit，若执行失败，抛出异常，spring框架捕获到异常自动回滚
    public ResultVo insert(Hello hello) throws Exception{
        Long l = testMapper.insert(hello);
        if (l == 1L) {
            return ResultVo.success(null);
        } else {
            throw new Exception();
        }
    }
}
