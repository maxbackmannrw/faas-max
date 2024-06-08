package com.faas.core.base.repo.utils.asset.settings;

import com.faas.core.base.model.db.utils.asset.settings.AssetTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetTypeRepository extends PagingAndSortingRepository<AssetTypeDBModel, Long> {

    List<AssetTypeDBModel> findByStatus(int status);

    List<AssetTypeDBModel> findByAssetType(String assetType);
}
