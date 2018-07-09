package com.freesoft.graphqlarticlesdemo.repository;

import com.freesoft.graphqlarticlesdemo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
