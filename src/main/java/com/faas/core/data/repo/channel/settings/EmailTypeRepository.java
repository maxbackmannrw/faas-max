package com.faas.core.data.repo.channel.settings;

import com.faas.core.data.db.channel.settings.EmailTypeDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailTypeRepository extends PagingAndSortingRepository<EmailTypeDBModel, Long> {

    List<EmailTypeDBModel> findByStatus(int status);


}
