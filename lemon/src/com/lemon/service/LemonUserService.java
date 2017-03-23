package com.lemon.service;

import com.lemon.entity.LemonUser;

public interface LemonUserService extends BaseService<LemonUser,String> {


	LemonUser findLemonUser(LemonUser user);

	LemonUser getUser(LemonUser user);

	LemonUser findByUsername(String username);

}
