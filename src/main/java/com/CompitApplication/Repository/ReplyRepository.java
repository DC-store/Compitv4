package com.CompitApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CompitApplication.Model.ReplyModel;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyModel, Integer> {

}
