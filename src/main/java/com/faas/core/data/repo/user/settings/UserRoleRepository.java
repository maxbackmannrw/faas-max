package com.faas.core.data.repo.user.settings;

import com.faas.core.data.db.user.settings.UserRoleDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends PagingAndSortingRepository<UserRoleDBModel, Long> {

    List<UserRoleDBModel> findByStatus(int status);

    List<UserRoleDBModel> findByUserRole(String userRole);
}
