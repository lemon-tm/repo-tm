package com.lemon.dao;

import com.lemon.entity.LemonUser;

public interface LemonUserDao extends BaseDao<LemonUser, String> {

	LemonUser findLemonUser(LemonUser user);

	LemonUser getUser(LemonUser user);

	LemonUser findByUsername(String username);

}
