package com.faas.core.data.db.client.details.dao;

public class ClientNoteDAO {

    private String id;
    private long creatorId;
    private String noteTitle;
    private String noteText;
    private String noteAsset;
    private long uDate;
    private long cDate;
    private int status;

    public ClientNoteDAO() {
    }

    public ClientNoteDAO(String id, long creatorId, String noteTitle, String noteText, String noteAsset, long uDate, long cDate, int status) {
        this.id = id;
        this.creatorId = creatorId;
        this.noteTitle = noteTitle;
        this.noteText = noteText;
        this.noteAsset = noteAsset;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNoteAsset() {
        return noteAsset;
    }

    public void setNoteAsset(String noteAsset) {
        this.noteAsset = noteAsset;
    }

    public long getuDate() {
        return uDate;
    }

    public void setuDate(long uDate) {
        this.uDate = uDate;
    }

    public long getcDate() {
        return cDate;
    }

    public void setcDate(long cDate) {
        this.cDate = cDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
