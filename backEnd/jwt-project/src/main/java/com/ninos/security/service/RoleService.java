package com.ninos.security.service;

import com.ninos.security.dao.RoleDao;
import com.ninos.security.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleService {

    private final RoleDao roleDao;

    // create new role
    public Role createNewRole(Role role){
      return roleDao.save(role);
    }


}
