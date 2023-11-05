package com.faas.core.base.model.db.client.details;

import com.faas.core.base.model.db.channel.account.dao.AccountDataDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "client_remote_table")
public class ClientRemoteDBModel {

    @Id
    private String id;
    private String account;
    private String remoteType;
    private long uDate;
    private long cDate;
    private int status;

    public ClientRemoteDBModel() {
    }


}
