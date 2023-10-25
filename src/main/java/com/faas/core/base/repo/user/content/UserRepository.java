package com.faas.core.base.repo.user.content;

import com.faas.core.base.model.db.user.content.UserDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDBModel, Long> {

    List<UserDBModel> findByUserEmailAndPassword(String userEmail, String password);

    List<UserDBModel> findByUserEmailAndPasswordAndUserType(String userEmail, String password, String userType);

    List<UserDBModel> findByUserEmailAndPasswordAndUserTypeAndValidUser(String userEmail, String password, String userType, boolean validUser);

    List<UserDBModel> findByUserEmail(String userEmail);

    List<UserDBModel> findByStatus(int status);

    List<UserDBModel> findByUserTypeAndStatus(String userType, int status);

    List<UserDBModel>findByUserType(String userType);

    List<UserDBModel> findByUserRoleAndUserTypeAndStatus(String userRole,String userType,int status);

    long countByUserType(String userType);

}
