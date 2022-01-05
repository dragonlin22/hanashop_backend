package com.dragonlin.hanashopapi.repositories;

import com.dragonlin.hanashopapi.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepo extends JpaRepository<AccountEntity,String> {
    AccountEntity findByEmailAndStatus(String email,Boolean status);
    AccountEntity findByEmail(String email);

}
