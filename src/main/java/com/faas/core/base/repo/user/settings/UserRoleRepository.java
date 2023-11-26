package com.faas.core.base.repo.user.settings;

import com.faas.core.base.model.db.user.settings.UserRoleDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends PagingAndSortingRepository<UserRoleDBModel, Long> {

    List<UserRoleDBModel> findByStatus(int status);
    List<UserRoleDBModel>findByUserRole(String userRole);
}
