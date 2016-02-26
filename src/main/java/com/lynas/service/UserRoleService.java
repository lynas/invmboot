package com.lynas.service;

import com.lynas.model.UserRole;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LynAs on 26-Feb-16
 */
@Component
@Transactional
public interface UserRoleService extends Repository<UserRole, Long> {
    UserRole readUserRoleByName(String name);
}
