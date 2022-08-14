package com.chnk.chnk_discord_web_moderation.repositories;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NumbersRepository extends JpaRepository<ChnkNumber, UUID> {
    List<ChnkNumber> getAllByValue(Integer value);
}
