package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CompitApplication.BgMusicModel.DefaultMusicModel;

@Repository
public interface DefaultMusicRepository extends JpaRepository<DefaultMusicModel, Long> {

}
