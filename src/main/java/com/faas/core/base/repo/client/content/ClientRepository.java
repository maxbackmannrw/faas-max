package com.faas.core.base.repo.client.content;

import com.faas.core.base.model.db.client.content.ClientDBModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends PagingAndSortingRepository<ClientDBModel, Long> {

    List<ClientDBModel>findByStatus(int status);
    List<ClientDBModel>findByIdAndStatus(long clientId,int status);
    List<ClientDBModel>findByClientState(String clientState);
    List<ClientDBModel>findByPhoneNumber(String phoneNumber);
    List<ClientDBModel>findByIdAndClientState(long id,String clientState);
    List<ClientDBModel>findByRemote(boolean isRemote);
    Page<ClientDBModel>findAllByStatus(int status,Pageable pageable);
    Page<ClientDBModel>findAllByClientState(String clientState,Pageable pageable);
    Page<ClientDBModel>findAllByClientStateAndStatus(String clientState,int status,Pageable pageable);
    Page<ClientDBModel>findAllByClientCountryAndClientState(String country,String clientState, Pageable pageable);
    Page<ClientDBModel>findAllByClientCountryAndClientCityContainingIgnoreCaseAndClientState(String country,String city,String clientState,Pageable pageable);
    Page<ClientDBModel>findAllByRemoteAndStatus(boolean isRemote,int status,Pageable pageable);
}
