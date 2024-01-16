package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CompitApplication.BgMusicModel.BackGroundMusicModel;

@Repository
public interface BackgroundMusicRepository  extends JpaRepository<BackGroundMusicModel, Long>{

}
