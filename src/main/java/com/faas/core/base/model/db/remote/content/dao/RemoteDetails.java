package com.faas.core.base.model.db.remote.content.dao;

public class RemoteDetails {

    private PWARemoteDAO pwaRemote;
    private AndroidRemoteDAO androidRemote;
    private IOSRemoteDAO iosRemote;

    public RemoteDetails() {
    }

    public RemoteDetails(PWARemoteDAO pwaRemote, AndroidRemoteDAO androidRemote, IOSRemoteDAO iosRemote) {
        this.pwaRemote = pwaRemote;
        this.androidRemote = androidRemote;
        this.iosRemote = iosRemote;
    }

    public PWARemoteDAO getPwaRemote() {
        return pwaRemote;
    }

    public void setPwaRemote(PWARemoteDAO pwaRemote) {
        this.pwaRemote = pwaRemote;
    }

    public AndroidRemoteDAO getAndroidRemote() {
        return androidRemote;
    }

    public void setAndroidRemote(AndroidRemoteDAO androidRemote) {
        this.androidRemote = androidRemote;
    }

    public IOSRemoteDAO getIosRemote() {
        return iosRemote;
    }

    public void setIosRemote(IOSRemoteDAO iosRemote) {
        this.iosRemote = iosRemote;
    }
}
