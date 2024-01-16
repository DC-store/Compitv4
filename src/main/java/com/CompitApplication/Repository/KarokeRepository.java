package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CompitApplication.BgMusicModel.KarokeModel;

@Repository
public interface KarokeRepository  extends JpaRepository<KarokeModel, Long>{

}
