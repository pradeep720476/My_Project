package com.mypharamacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypharamacy.entity.Image;

@Repository
public interface UploadRepository extends JpaRepository<Image, Long> {

}
