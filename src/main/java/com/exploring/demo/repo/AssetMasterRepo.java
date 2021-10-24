package com.exploring.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exploring.demo.model.AssetMaster;

@Repository
public interface AssetMasterRepo extends CrudRepository<AssetMaster, String>{

}
