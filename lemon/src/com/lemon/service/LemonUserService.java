package com.lemon.service;

import com.lemon.entity.LemonUser;

public interface LemonUserService extends BaseService<LemonUser,String> {


	LemonUser findLemonUser(LemonUser user);

}