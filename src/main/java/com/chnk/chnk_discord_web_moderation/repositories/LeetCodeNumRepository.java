package com.chnk.chnk_discord_web_moderation.repositories;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeetCodeNumRepository extends JpaRepository<ChnkLeetCodeNum, UUID> {

}
