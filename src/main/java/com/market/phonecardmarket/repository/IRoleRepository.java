package com.market.phonecardmarket.repository;

import com.market.phonecardmarket.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Short> {

    Role findByName(String name);
}
