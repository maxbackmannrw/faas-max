package com.faas.core.misc.config;

public class AppConstant {

    public static final String API_VERSION = "/v1";

    public static final int GENERAL_SUCCESS_CODE = 200;
    public static final int GENERAL_FAIL_CODE = 201;
    public static final String GENERAL_SUCCESS_STATUS = "SUCCESS";
    public static final String GENERAL_FAIL_STATUS = "FAIL";

    public static final String NONE = "NONE";

    public static final String MANAGER_USER = "MANAGER_USER";
    public static final String BASIC_MANAGER = "BASIC_MANAGER";
    public static final String SUPER_MANAGER = "SUPER_MANAGER";

    public static final String AGENT_USER = "AGENT_USER";
    public static final String BASIC_AGENT = "BASIC_AGENT";
    public static final String SUPER_AGENT = "SUPER_AGENT";
    public static final String AUTO_AGENT = "AUTO_AGENT";


    public static final String DEFAULT_MANAGER_NAME = "manager";
    public static final String DEFAULT_MANAGER_EMAIL = "manager";
    public static final String DEFAULT_MANAGER_PASSWORD = "45781296";

    public static final String DEFAULT_AGENT_NAME = "sagent";
    public static final String DEFAULT_AGENT_EMAIL = "sagent";
    public static final String DEFAULT_AGENT_PASSWORD = "45781296";

    public static final int BASIC_MANAGER_OPERATION_LIMIT = 25;
    public static final int SUPER_MANAGER_OPERATION_LIMIT = 25;
    public static final int BASIC_AGENT_OPERATION_LIMIT = 5;
    public static final int SUPER_AGENT_OPERATION_LIMIT = 25;


    public static final String MAIN_TYPE = "MAIN_TYPE";
    public static final String SUB_TYPE = "SUB_TYPE";


    public static final String MANUAL_OPERATION = "MANUAL";
    public static final String INQUIRY_OPERATION = "INQUIRY";
    public static final String AUTOMATIC_OPERATION = "AUTOMATIC";


    public static final String MANUAL_CAMPAIGN = "MANUAL";
    public static final String INQUIRY_CAMPAIGN = "INQUIRY";
    public static final String AUTOMATIC_CAMPAIGN = "AUTOMATIC";
    public static final String ALL_CAMPAIGNS = "ALL";


    public static final String CLIENTS = "CLIENTS";
    public static final String READY_CLIENT = "READY_CLIENT";
    public static final String BUSY_CLIENT = "BUSY_CLIENT";


    public static final String NO_STATE = "NO_STATE";
    public static final String READY_STATE = "READY_STATE";
    public static final String ACTIVE_STATE = "ACTIVE_STATE";
    public static final String PASSIVE_STATE = "PASSIVE_STATE";
    public static final String COMPLETED_STATE = "COMPLETED_STATE";

    public static final String ALL_STATES = "ALL_STATES";


    public static final String READY_CAMPAIGN = "READY_CAMPAIGN";
    public static final String ACTIVE_CAMPAIGN = "ACTIVE_CAMPAIGN";
    public static final String PASSIVE_CAMPAIGN = "PASSIVE_CAMPAIGN";


    public static final String OPERATION_SUCCESS = "OPERATION_SUCCESS";
    public static final String OPERATION_REJECTED = "OPERATION_REJECTED";
    public static final String OPERATION_NO_RESPONSE = "OPERATION_NO_RESPONSE";
    public static final String OPERATION_FALSE_CONTENT = "OPERATION_FALSE_CONTENT";


    public static final String FLASH_MESSAGE = "FLASH_MESSAGE";
    public static final String TEXT_MESSAGE = "TEXT_MESSAGE";
    public static final String IMAGE_MESSAGE = "IMAGE_MESSAGE";
    public static final String VOICE_MESSAGE = "VOICE_MESSAGE";
    public static final String VIDEO_MESSAGE = "VIDEO_MESSAGE";
    public static final String DOC_MESSAGE = "DOC_MESSAGE";

    public static final String STANDARD_EMAIL = "STANDARD_EMAIL";

    public static final String TEXT_PUSH = "TEXT_PUSH";


    public static final String MESSAGE_READY = "MESSAGE_READY";
    public static final String MESSAGE_SENDING = "MESSAGE_SENDING";
    public static final String MESSAGE_SENT = "MESSAGE_SENT";
    public static final String MESSAGE_FAILED = "MESSAGE_FAILED";


    public static final String READY_CALL = "READY_CALL";
    public static final String ACTIVE_CALL = "ACTIVE_CALL";
    public static final String FINISHED_CALL = "FINISHED_CALL";


    public static final String AGENT_READY_OPERATION_SUMMARY = "AGENT_READY_OPERATION_SUMMARY";
    public static final String AGENT_ACTIVE_OPERATION_SUMMARY = "AGENT_ACTIVE_OPERATION_SUMMARY";
    public static final String AGENT_TOTAL_OPERATION_SUMMARY = "AGENT_TOTAL_OPERATION_SUMMARY";

    public static final String AGENT_TOTAL_CAMPAIGN_SUMMARY = "AGENT_TOTAL_CAMPAIGN_SUMMARY";


    public static final String USER_TYPE = "USER_TYPE";
    public static final String CLIENT_TYPE = "CLIENT_TYPE";


    public static final String CREATE_OPERATION_ACTIVITY = "CREATE_OPERATION_ACTIVITY";
    public static final String CREATE_OPERATION_ACTIVITY_DESC = "operation created by";

    public static final String LAUNCH_OPERATION_ACTIVITY = "LAUNCH_OPERATION_ACTIVITY";
    public static final String LAUNCH_OPERATION_ACTIVITY_DESC = "operation launched by";

    public static final String FINISH_OPERATION_ACTIVITY = "FINISH_OPERATION_ACTIVITY";
    public static final String FINISH_OPERATION_ACTIVITY_DESC = "operation finished by";


    public static final String URL_SHORTENER_API_URL = "https://tyny.to/linkApi";
    public static final String URL_SHORTENER_API_KEY = "b94afb4c-549d-4e40-9891-9aceb6155b31";


    public static final String SMS_PROVIDER_API_URL = "https://api.1s2u.io/bulksms";
    public static final String SMS_PROVIDER_USER_NAME = "wrwrozengint023";
    public static final String SMS_PROVIDER_PASSWORD = "web97898";


    public static final String PWA_REMOTE = "PWA_REMOTE";
    public static final String IOS_REMOTE = "IOS_REMOTE";
    public static final String ANDROID_REMOTE = "ANDROID_REMOTE";
    public static final String ALL_REMOTES = "ALL_REMOTES";

    public static final String BASE_REMOTE = "BASE_REMOTE";
    public static final String INQUIRY_REMOTE = "INQUIRY_REMOTE";
    public static final String FLOW_REMOTE = "FLOW_REMOTE";


    public static final String CONN_WAITING = "CONN_WAITING";
    public static final String CONN_ACTIVE = "CONN_ACTIVE";
    public static final String CONN_FAILED = "CONN_FAILED";


    public static final String REMOTE_URL = "REMOTE_URL";

    public static final String SMS_TEMP_URL = "SMS_TEMP_URL";
    public static final String WAPP_MESSAGE_TEMP_URL = "WAPP_MESSAGE_TEMP_URL";
    public static final String EMAIL_TEMP_URL = "EMAIL_TEMP_URL";
    public static final String PUSH_TEMP_URL = "PUSH_TEMP_URL";

    public static final String SMS_TRIGGER_URL = "SMS_TRIGGER_URL";
    public static final String WAPP_MESSAGE_TRIGGER_URL = "WAPP_MESSAGE_TEMP_URL";
    public static final String EMAIL_TRIGGER_URL = "EMAIL_TEMP_URL";
    public static final String AI_TRIGGER_URL = "AI_TRIGGER_URL";


    public static final String BASE_URL = "BASE_URL";
    public static final String REDIRECT_URL = "REDIRECT_URL";
    public static final String SOCKET_URL = "SOCKET_URL";


    public static final String CLIENT_NAME_TAG = "[clientName]";
    public static final String REMOTE_URL_TAG = "[remoteUrl]";
    public static final String TEMP_URL_TAG = "[tempUrl]";


    public static final String FIRST_TIME_INIT = "FIRST_TIME_INIT";

    public static final String CLIENT_CONTENTS = "CLIENT_CONTENTS";
    public static final String SESSION_CONTENTS = "SESSION_CONTENTS";
    public static final String OPERATION_CONTENTS = "OPERATION_CONTENTS";

    public static final String CAMPAIGN_CONTENTS = "CAMPAIGN_CONTENTS";

    public static final String USER_CONTENTS = "USER_CONTENTS";
    public static final String AGENT_CONTENTS = "AGENT_CONTENTS";
    public static final String ASSET_CONTENTS = "ASSET_CONTENTS";

}

