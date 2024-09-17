package com.faas.core.base.model.ws.channel.settings.dto;

import com.faas.core.data.db.channel.settings.WappServerDBModel;

public class WappServerWSDTO {

    private WappServerDBModel wappServer;

    public WappServerWSDTO() {
    }

    public WappServerWSDTO(WappServerDBModel wappServer) {
        this.wappServer = wappServer;
    }

    public WappServerDBModel getWappServer() {
        return wappServer;
    }

    public void setWappServer(WappServerDBModel wappServer) {
        this.wappServer = wappServer;
    }
}
