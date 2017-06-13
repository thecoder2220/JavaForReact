package com.claurier.user.modules.user.utils;

import com.claurier.user.modules.user.lightbeans.AssoFunctionRoleLightBean;
import com.claurier.user.modules.user.lightbeans.AssoUserRoleLightBean;
import com.claurier.user.modules.user.lightbeans.FunctionLightBean;
import com.claurier.user.modules.user.lightbeans.RoleLightBean;
import com.claurier.user.modules.user.lightbeans.UrlLightBean;
import com.claurier.user.modules.user.lightbeans.UserLightbean;
import com.claurier.user.modules.user.model.AssoFunctionRole;
import com.claurier.user.modules.user.model.AssoUserRole;
import com.claurier.user.modules.user.model.Function;
import com.claurier.user.modules.user.model.Role;
import com.claurier.user.modules.user.model.Url;
import com.claurier.user.modules.user.model.User;

public class LightBeanToBeanUtils {
    public static AssoFunctionRoleLightBean copyFrom(AssoFunctionRole assofunctionRole) {
        AssoFunctionRoleLightBean assoFunctionRoleLightBean = new AssoFunctionRoleLightBean();
        assoFunctionRoleLightBean.setId(assofunctionRole.getId());
        assoFunctionRoleLightBean.setIdFunction(assofunctionRole.getIdFunction());
        assoFunctionRoleLightBean.setIdRole(assofunctionRole.getIdRole());
        return assoFunctionRoleLightBean;
    }

    public static AssoUserRoleLightBean copyFrom(AssoUserRole assoUserRole) {
        AssoUserRoleLightBean assoUserRoleLightBean = new AssoUserRoleLightBean();
        assoUserRoleLightBean.setId(assoUserRole.getId());
        assoUserRoleLightBean.setIdUser(assoUserRole.getIdUser());
        assoUserRoleLightBean.setIdRole(assoUserRole.getIdRole());
        return assoUserRoleLightBean;
    }

    public static FunctionLightBean copyFrom(Function function) {
        FunctionLightBean functionLightBean = new FunctionLightBean();
        functionLightBean.setId(function.getId());
        functionLightBean.setCode(function.getCode());
        functionLightBean.setDateCreation(function.getDateCreation());
        functionLightBean.setType(function.getType());
        return functionLightBean;
    }

    public static RoleLightBean copyFrom(Role role) {
        RoleLightBean roleLightBean = new RoleLightBean();
        roleLightBean.setId(role.getId());
        roleLightBean.setCode(role.getCode());
        roleLightBean.setDateCreation(role.getDateCreation());
        return roleLightBean;
    }

    public static UrlLightBean copyFrom(Url url) {
        UrlLightBean urlLightBean = new UrlLightBean();
        urlLightBean.setId(url.getId());
        urlLightBean.setUrl(url.getUrl());
        urlLightBean.setCodeLangue(url.getCodeLangue());
        urlLightBean.setIdFunction(url.getIdFunction());
        urlLightBean.setDateCreation(url.getDateCreation());
        return urlLightBean;
    }

    public static UserLightbean copyFrom(User user) {
        UserLightbean userLightbean = new UserLightbean();
        userLightbean.setId(user.getId());
        userLightbean.setLastname(user.getLastname());
        userLightbean.setFirstname(user.getFirstname());
        userLightbean.setEmail(user.getEmail());
        userLightbean.setLogin(user.getLogin());
        userLightbean.setPhoneNumber(user.getPhoneNumber());
        userLightbean.setCompany(user.getCompany());
        userLightbean.setDisabled(user.isDisabled());
        userLightbean.setGroups(user.getGroups());
        return userLightbean;
    }
}

