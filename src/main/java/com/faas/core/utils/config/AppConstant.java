package com.faas.core.utils.config;

public class AppConstant {

    public static final String API_VERSION = "/v1";

    public static final int GENERAL_SUCCESS_CODE = 200;
    public static final int GENERAL_FAIL_CODE = 201;
    public static final String GENERAL_SUCCESS_STATUS = "SUCCESS";
    public static final String GENERAL_FAIL_STATUS = "FAIL";


    public static final String MANAGER_USER = "MANAGER_USER";
    public static final String BASIC_MANAGER = "BASIC_MANAGER";
    public static final String SUPER_MANAGER = "SUPER_MANAGER";

    public static final String DEFAULT_MANAGER_NAME = "manager";
    public static final String DEFAULT_MANAGER_EMAIL = "manager";
    public static final String DEFAULT_MANAGER_PASSWORD = "45781296";


    public static final String AGENT_USER = "AGENT_USER";
    public static final String BASIC_AGENT = "BASIC_AGENT";
    public static final String SUPER_AGENT = "SUPER_AGENT";
    public static final String AUTO_AGENT = "AUTO_AGENT";


    public static final long BASIC_AGENT_OPERATION_LIMIT = 5;
    public static final long SUPER_AGENT_OPERATION_LIMIT = 20;

    public static final String NONE = "NONE";

    public static final String MAIN_TYPE = "MAIN_TYPE";
    public static final String SUB_TYPE = "SUB_TYPE";



    public static final String PROCESS_DATA_TYPE = "PROCESS";

    public static final String SOURCE_URL = "SOURCE_URL";
    public static final String PWA_URL = "PWA_URL";
    public static final String NATIVE_URL = "NATIVE_URL";


    public static final String MANUAL_SESSION = "MANUAL";
    public static final String INQUIRY_SESSION = "INQUIRY";
    public static final String AUTOMATIC_SESSION = "AUTOMATIC";

    public static final String MANUAL_OPERATION = "MANUAL";
    public static final String INQUIRY_OPERATION = "INQUIRY";
    public static final String AUTOMATIC_OPERATION = "AUTOMATIC";
    public static final String ALL_OPERATIONS = "ALL_OPERATIONS";


    public static final String MANUAL_CAMPAIGN = "MANUAL";
    public static final String INQUIRY_CAMPAIGN = "INQUIRY";
    public static final String AUTOMATIC_CAMPAIGN = "AUTOMATIC";
    public static final String ALL_CAMPAIGNS = "ALL";


    public static final String MANUAL_PROCESS = "MANUAL";
    public static final String INQUIRY_PROCESS = "INQUIRY";
    public static final String AUTOMATIC_PROCESS = "AUTOMATIC";


    public static final String CLIENTS = "CLIENTS";
    public static final String READY_CLIENT = "READY_CLIENT";
    public static final String BUSY_CLIENT = "BUSY_CLIENT";


    public static final String NO_VALUE = "NO_VALUE";

    public static final String NO_STATE = "NO_STATE";
    public static final String NEW_STATE = "NEW_STATE";
    public static final String READY_STATE = "READY_STATE";
    public static final String ACTIVE_STATE = "ACTIVE_STATE";
    public static final String PASSIVE_STATE = "PASSIVE_STATE";
    public static final String COMPLETED_STATE = "COMPLETED_STATE";

    public static final String ALL_STATES = "ALL_STATES";


    public static final String NEW_REMOTE = "NEW_REMOTE";
    public static final String READY_REMOTE = "READY_REMOTE";
    public static final String FAILED_REMOTE = "FAILED_REMOTE";


    public static final String OP_SUCCESS = "OP_SUCCESS";
    public static final String OP_REJECTED = "OP_REJECTED";
    public static final String OP_NOT_AVAILABLE = "OP_NOT_AVAILABLE";
    public static final String OP_DATA_FALSE = "OP_DATA_FALSE";



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


    public static final String AGENT_READY_OPERATIONS_SUMMARY = "AGENT_READY_OPERATIONS_SUMMARY";
    public static final String AGENT_ACTIVE_OPERATIONS_SUMMARY = "AGENT_ACTIVE_OPERATIONS_SUMMARY";
    public static final String AGENT_ALL_OPERATIONS_SUMMARY = "AGENT_ALL_OPERATIONS_SUMMARY";

    public static final String AGENT_ALL_CAMPAIGNS_SUMMARY = "AGENT_ALL_CAMPAIGNS_SUMMARY";


    public static final String PWA_REMOTE = "PWA_REMOTE";
    public static final String IOS_REMOTE = "IOS_REMOTE";
    public static final String ANDROID_REMOTE = "ANDROID_REMOTE";
    public static final String ALL_REMOTES = "ALL_REMOTES";


    public static final String USER_TYPE= "USER_TYPE";
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

    public static final String CLIENT_NAME_TAG = "{clientName}";
    public static final String PWA_URL_TAG = "{pwaUrl}";
    public static final String NATIVE_URL_TAG = "{nativeUrl}";



    public static final String FIRST_TIME_INIT = "FIRST_TIME_INIT";

    public static final String CLIENT_UTILS = "CLIENT_UTILS";
    public static final String SESSION_UTILS = "SESSION_UTILS";
    public static final String OPERATION_UTILS = "OPERATION_UTILS";

    public static final String CAMPAIGN_UTILS = "CAMPAIGN_UTILS";
    public static final String PROCESS_UTILS = "PROCESS_UTILS";
    public static final String SCENARIO_UTILS = "SCENARIO_UTILS";

    public static final String USER_UTILS = "USER_UTILS";
    public static final String AGENT_UTILS = "AGENT_UTILS";
    public static final String ASSET_UTILS = "ASSET_UTILS";

}
