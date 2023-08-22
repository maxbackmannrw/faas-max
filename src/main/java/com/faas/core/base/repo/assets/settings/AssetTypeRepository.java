package com.faas.core.base.repo.assets.settings;

import com.faas.core.base.model.db.assets.settings.AssetTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetTypeRepository extends PagingAndSortingRepository<AssetTypeDBModel, Long> {

    List<AssetTypeDBModel> findByStatus(int status);

    List<AssetTypeDBModel> findByAssetType(String assetType);
}
