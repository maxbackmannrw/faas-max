package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;

public class RemoteDataWSDTO {

    private RemoteDataDAO remoteData;

    public RemoteDataWSDTO() {
    }

    public RemoteDataWSDTO(RemoteDataDAO remoteData) {
        this.remoteData = remoteData;
    }

    public RemoteDataDAO getRemoteData() {
        return remoteData;
    }

    public void setRemoteData(RemoteDataDAO remoteData) {
        this.remoteData = remoteData;
    }
}

