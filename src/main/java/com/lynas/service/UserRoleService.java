package com.lynas.service;

import com.lynas.model.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LynAs on 26-Feb-16
 */
@Component("UserRoleService")
@Transactional
public interface UserRoleService {
    UserRole readUserRoleByName(String name);
}
