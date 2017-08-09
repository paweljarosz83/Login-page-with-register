package com.paweljarosz.security.repos;

import org.springframework.data.repository.CrudRepository;

import com.paweljarosz.security.user.Role;

public interface RoleRepository extends CrudRepository<Role,Long>{
	
	Role findById(Long id);

}
