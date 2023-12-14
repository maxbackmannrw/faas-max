package com.faas.core.base.model.db.process.content.dao;

import com.faas.core.base.model.db.remote.content.dao.RemoteDataDAO;

import java.util.List;

public class ProcessRemoteDAO {

    private String id;
    private String remoteId;
    private String remote;
    private String remoteDesc;
    private String remoteUrl;
    private String remoteModel;
    private String remoteVersion;
    private List<RemoteDataDAO>datas;
    private long typeId;
    private String remoteType;
    private String baseType;


}
