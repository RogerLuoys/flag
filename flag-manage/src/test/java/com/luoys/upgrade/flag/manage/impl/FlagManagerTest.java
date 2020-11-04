package com.luoys.upgrade.flag.manage.impl;

import com.luoys.upgrade.flag.api.bo.FlagBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlagManagerTest {

    @Autowired
    FlagManagerImpl flagManager;

    @Test
    public void addFlag() {
        List<FlagBO> result = flagManager.queryFlags("1");
        System.out.println(result);
    }
}
