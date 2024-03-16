package com.faas.core.base.model.db.user.details;

import com.faas.core.base.model.db.user.details.dao.UserDataDAO;
import com.faas.core.base.model.db.user.details.dao.UserSipChannelDAO;
import com.faas.core.base.model.db.user.details.dao.UserWappChannelDAO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user_details_table")
public class UserDetailsDBModel {

    @Id
    private String id;
    private long userId;
    private List<UserDataDAO>userDatas;
    private UserSipChannelDAO sipChannel;
    private UserWappChannelDAO wappChannel;
    private int operationLimit;
    private long uDate;
    private long cDate;
    private int status;

    public UserDetailsDBModel() {
    }

    public UserDetailsDBModel(String id, long userId, List<UserDataDAO> userDatas, UserSipChannelDAO sipChannel, UserWappChannelDAO wappChannel, int operationLimit, long uDate, long cDate, int status) {
        this.id = id;
        this.userId = userId;
        this.userDatas = userDatas;
        this.sipChannel = sipChannel;
        this.wappChannel = wappChannel;
        this.operationLimit = operationLimit;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<UserDataDAO> getUserDatas() {
        return userDatas;
    }

    public void setUserDatas(List<UserDataDAO> userDatas) {
        this.userDatas = userDatas;
    }

    public UserSipChannelDAO getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(UserSipChannelDAO sipChannel) {
        this.sipChannel = sipChannel;
    }

    public UserWappChannelDAO getWappChannel() {
        return wappChannel;
    }

    public void setWappChannel(UserWappChannelDAO wappChannel) {
        this.wappChannel = wappChannel;
    }

    public int getOperationLimit() {
        return operationLimit;
    }

    public void setOperationLimit(int operationLimit) {
        this.operationLimit = operationLimit;
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
