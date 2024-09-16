package com.faas.core.data.repo.asset.content;

import com.faas.core.data.db.asset.content.AssetDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends PagingAndSortingRepository<AssetDBModel, Long> {

    List<AssetDBModel> findByStatus(int status);

    List<AssetDBModel> findByAssetType(String assetType);

}
