package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CompitApplication.BgMusicModel.BgDailogueModel;

@Repository
public interface BgDailogueRepository extends JpaRepository<BgDailogueModel, Long> {

}
