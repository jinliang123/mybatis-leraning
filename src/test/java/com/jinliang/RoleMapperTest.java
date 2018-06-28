package com.jinliang;

import com.jinliang.domain.Role;
import com.jinliang.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description
 *
 * @author liang.jin@hand-china.com 2018/06/28 23:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testFind(){
        System.out.println("开始测试");
        Role role = roleMapper.getRole(1L);
        System.out.println(role);

    }


}
