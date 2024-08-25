package com.aykutbuyukkaya.passayhistoryrule.repository;

import com.aykutbuyukkaya.passayhistoryrule.model.entity.UserPasswords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPasswordsRepository extends JpaRepository<UserPasswords, Integer> {

    List<UserPasswords> findTop3ByUserIdOrderByCreatedDateDesc(Integer userId);

}
