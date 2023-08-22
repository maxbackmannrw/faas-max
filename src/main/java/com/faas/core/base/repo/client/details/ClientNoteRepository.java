package com.faas.core.base.repo.client.details;

import com.faas.core.base.model.db.client.details.ClientNoteDBModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientNoteRepository extends PagingAndSortingRepository<ClientNoteDBModel, Long> {

    List<ClientNoteDBModel>findByClientId(long clientId);
    List<ClientNoteDBModel>findByIdAndClientId(long dataId,long clientId);
    List<ClientNoteDBModel>findBySessionIdAndClientId(long sessionId,long clientId);
    List<ClientNoteDBModel>findByIdAndSessionId(long noteId,long sessionId);
    List<ClientNoteDBModel>findByIdAndSessionIdAndClientId(long noteId,long sessionId,long clientId);

}
