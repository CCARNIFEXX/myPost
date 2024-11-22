package com.micro.mypost.postgres.users;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostgresRepository extends JpaRepository<DBUser, UUID> {
    DBUser findByNickname(@NotNull String nickname);
}
