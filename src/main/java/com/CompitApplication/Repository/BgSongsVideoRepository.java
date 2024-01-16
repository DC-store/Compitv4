package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CompitApplication.BgMusicModel.BgSongsModel;

@Repository
public interface BgSongsVideoRepository extends JpaRepository<BgSongsModel, Long> {

	public BgSongsModel findByBgSongId(long muiscId);
}
