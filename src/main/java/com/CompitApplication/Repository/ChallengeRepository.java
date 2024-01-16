package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CompitApplication.Model.ChallengeModel;

public interface ChallengeRepository  extends JpaRepository<ChallengeModel, Long>{

	public ChallengeModel findByChallengeId(long id);
	
}
