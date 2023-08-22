package com.faas.core.base.repo.assets.content;

import com.faas.core.base.model.db.assets.content.AssetDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends PagingAndSortingRepository<AssetDBModel, Long> {

    List<AssetDBModel> findByStatus(int status);

    List<AssetDBModel> findByAssetType(String assetType);

}
