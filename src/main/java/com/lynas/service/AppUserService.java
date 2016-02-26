package com.lynas.service;

import com.lynas.model.AppUser;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LynAs on 26-Feb-16
 */
@Component("AppUserService")
@Transactional
public interface AppUserService extends Repository<AppUser, Long> {
    AppUser readAppUserByUserName(String userName);
}
