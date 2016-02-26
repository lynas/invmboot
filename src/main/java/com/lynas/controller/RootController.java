package com.lynas.controller;

import com.lynas.model.AppUser;
import com.lynas.model.UserRole;
import com.lynas.service.AppUserService;
import com.lynas.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LynAs on 26-Feb-16
 */
@Controller
public class RootController {

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    AppUserService appUserService;

    @RequestMapping("/")
    public String ins() {

        return "greeting";
    }

    @RequestMapping(value = "/login")
    public String login() {
        System.out.println();
        return "login";
    }

    @RequestMapping("/signUp")
    public String signUp() {
        System.out.println();
        return "signUp";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String signUpPost(@RequestParam String userName,
                             @RequestParam String password,
                             @RequestParam String fullName) {
        UserRole userRole = userRoleService.readUserRoleByName("ROLE_USER");
        List<UserRole> roles = new ArrayList<>();
        roles.add(userRole);
        AppUser appUser = new AppUser(
                userName,
                new BCryptPasswordEncoder().encode(password),
                fullName,
                roles);
        appUserService.save(appUser);
        return "redirect:/login";
    }
}
