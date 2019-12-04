package com.mercury.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.beans.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer> {

}
