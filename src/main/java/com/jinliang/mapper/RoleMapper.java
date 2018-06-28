package com.jinliang.mapper;

import com.jinliang.domain.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * description
 *
 * @author liang.jin@hand-china.com 2018/06/28 23:16
 */
@Mapper
public interface RoleMapper {
    Role getRole(Long roleId);
}
