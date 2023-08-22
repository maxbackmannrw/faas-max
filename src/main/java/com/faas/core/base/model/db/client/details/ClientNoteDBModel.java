package com.faas.core.base.model.db.client.details;

import javax.persistence.*;

@Entity
@Table(name = "client_note_table")
public class ClientNoteDBModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "session_id")
    private long sessionId;

    @Column(name = "creator_id")
    private long creatorId;

    @Column(name = "note_title")
    private String noteTitle;

    @Column(name = "note_text",columnDefinition = "TEXT")
    private String noteText;

    @Column(name = "note_asset",columnDefinition = "TEXT")
    private String noteAsset;

    @Column(name = "u_date")
    private long uDate;

    @Column(name = "c_date")
    private long cDate;

    @Column(name = "status")
    private int status;

    public ClientNoteDBModel() {
    }

    public ClientNoteDBModel(long id, long clientId, long sessionId, long creatorId, String noteTitle, String noteText, String noteAsset, long uDate, long cDate, int status) {
        this.id = id;
        this.clientId = clientId;
        this.sessionId = sessionId;
        this.creatorId = creatorId;
        this.noteTitle = noteTitle;
        this.noteText = noteText;
        this.noteAsset = noteAsset;
        this.uDate = uDate;
        this.cDate = cDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
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
