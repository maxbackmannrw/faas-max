package com.faas.core.base.repo.campaign.settings;

import com.faas.core.base.model.db.campaign.settings.InquiryTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryTypeRepository extends PagingAndSortingRepository<InquiryTypeDBModel, Long> {

    List<InquiryTypeDBModel> findByStatus(int status);

}
