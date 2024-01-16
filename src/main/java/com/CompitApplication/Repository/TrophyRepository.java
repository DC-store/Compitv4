package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CompitApplication.Model.TrophyModel;

@Repository
public interface TrophyRepository extends JpaRepository<TrophyModel, Long> {

}
