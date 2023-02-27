package com.esprit.veltun.services;

import com.esprit.veltun.model.User;
import com.esprit.veltun.services.base.BaseService;

public interface UserService extends BaseService<User> {

    boolean remove(String cin);
    User findByCin(String id);

    User findByEmail(String email);
}
