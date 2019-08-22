package com.imooc.sm.service;

import com.imooc.sm.entity.Staff;

public interface SelfService {

    /**
     * 校验账号、密码是否匹配。若匹配，则返回staff对象；若不匹配，则返回null
     * @param account
     * @param password
     * @return
     */
    Staff login(String account, String password);

    /**
     * 通过id，修改员工的密码
     * @param id
     * @param password
     */
    void changePassword(Integer id, String password);

}
