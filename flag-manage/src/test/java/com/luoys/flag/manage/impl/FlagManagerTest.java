package com.luoys.flag.manage.impl;

import com.luoys.flag.dao.po.FlagPO;
import com.luoys.flag.manage.FlagManager;
import com.luoys.flag.manage.impl.FlagManagerImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest
public class FlagManagerTest {
//    @Autowired
//    FlagManager flagManager;

    @Autowired
    FlagManagerImpl flagManagerImpl;

    @Test
    public void pageTest1() {
        List<FlagPO> result = flagManagerImpl.page();
        System.out.print(result);
    }
}
