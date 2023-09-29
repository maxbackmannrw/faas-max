package com.faas.core.base.framework.utils.settings;

import com.faas.core.base.model.db.client.session.SessionDBModel;
import com.faas.core.base.repo.scenario.temp.ActionTempRepository;
import com.faas.core.base.repo.assets.content.AssetRepository;
import com.faas.core.base.repo.campaign.content.CampaignRepository;
import com.faas.core.base.repo.campaign.details.CampaignAgentRepository;
import com.faas.core.base.repo.client.content.ClientRepository;
import com.faas.core.base.repo.client.details.ClientAddressRepository;
import com.faas.core.base.repo.client.details.ClientDataRepository;
import com.faas.core.base.repo.client.details.ClientEmailRepository;
import com.faas.core.base.repo.client.details.ClientPhoneRepository;
import com.faas.core.base.repo.client.flow.ClientFlowRepository;
import com.faas.core.base.repo.client.inquiry.ClientInquiryRepository;
import com.faas.core.base.repo.operation.channel.*;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.base.repo.operation.scenario.OperationScenarioRepository;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.content.*;
import com.faas.core.base.repo.process.details.channel.temp.EmailTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.WappMessageTempRepository;
import com.faas.core.base.repo.process.details.scenario.ProcessScenarioRepository;
import com.faas.core.base.repo.scenario.content.ScenarioRepository;
import com.faas.core.base.repo.client.session.SessionRepository;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UtilsSettingsFramework {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    ClientEmailRepository clientEmailRepository;

    @Autowired
    ClientPhoneRepository clientPhoneRepository;

    @Autowired
    ClientAddressRepository clientAddressRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    EmailMessageRepository emailMessageRepository;

    @Autowired
    PushMessageRepository pushMessageRepository;

    @Autowired
    SipCallRepository sipCallRepository;

    @Autowired
    SmsMessageRepository smsMessageRepository;

    @Autowired
    WappCallRepository wappCallRepository;

    @Autowired
    WappMessageRepository wappMessageRepository;

    @Autowired
    ClientInquiryRepository clientInquiryRepository;

    @Autowired
    ClientFlowRepository clientFlowRepository;

    @Autowired
    ActionTempRepository actionTempRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    CampaignAgentRepository campaignAgentRepository;

    @Autowired
    OperationScenarioRepository operationScenarioRepository;

    @Autowired
    ProcessEmailChannelRepository processEmailChannelRepository;

    @Autowired
    ProcessPushChannelRepository processPushChannelRepository;

    @Autowired
    ProcessSipChannelRepository processSipChannelRepository;

    @Autowired
    ProcessSmsChannelRepository processSmsChannelRepository;

    @Autowired
    ProcessWappChannelRepository processWappChannelRepository;

    @Autowired
    EmailTempRepository emailTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    WappMessageTempRepository wappMessageTempRepository;

    @Autowired
    ProcessScenarioRepository processScenarioRepository;

    @Autowired
    ScenarioRepository scenarioRepository;

    @Autowired
    ProcessRepository processRepository;


    public void removeAllClientsService() {

        clientRepository.deleteAll();
        clientDataRepository.deleteAll();
        clientEmailRepository.deleteAll();
        clientPhoneRepository.deleteAll();
        clientAddressRepository.deleteAll();
        sessionRepository.deleteAll();
        operationRepository.deleteAll();
        emailMessageRepository.deleteAll();
        pushMessageRepository.deleteAll();
        sipCallRepository.deleteAll();
        smsMessageRepository.deleteAll();
        wappCallRepository.deleteAll();
        wappMessageRepository.deleteAll();
    }


    public void removeAllSessionsService() {

        List<SessionDBModel> sessionDBModels = sessionRepository.findByStatus(1);
        for (SessionDBModel sessionDBModel : sessionDBModels) {

            operationRepository.deleteAll(operationRepository.findBySessionId(sessionDBModel.getId()));
            emailMessageRepository.deleteAll(emailMessageRepository.findBySessionId(sessionDBModel.getId()));
            pushMessageRepository.deleteAll(pushMessageRepository.findBySessionId(sessionDBModel.getId()));
            sipCallRepository.deleteAll(sipCallRepository.findBySessionId(sessionDBModel.getId()));
            smsMessageRepository.deleteAll(smsMessageRepository.findBySessionId(sessionDBModel.getId()));
            wappCallRepository.deleteAll(wappCallRepository.findBySessionId(sessionDBModel.getId()));
            wappMessageRepository.deleteAll(wappMessageRepository.findBySessionId(sessionDBModel.getId()));

       //     flowRepository.deleteAll(flowRepository.findBySessionId(sessionDBModel.getId()));
       //     inquiryRepository.deleteAll(inquiryRepository.findBySessionId(sessionDBModel.getId()));
            sessionRepository.delete(sessionDBModel);
        }
    }


    public void removeAllFlowsService() {

      /*  List<FlowDBModel> flowDBModels = flowRepository.findByStatus(1);
        for (FlowDBModel flowDBModel : flowDBModels) {

            operationRepository.deleteAll(operationRepository.findBySessionId(flowDBModel.getId()));
            emailMessageRepository.deleteAll(emailMessageRepository.findBySessionId(flowDBModel.getId()));
            pushMessageRepository.deleteAll(pushMessageRepository.findBySessionId(flowDBModel.getId()));
            sipCallRepository.deleteAll(sipCallRepository.findBySessionId(flowDBModel.getId()));
            smsMessageRepository.deleteAll(smsMessageRepository.findBySessionId(flowDBModel.getId()));
            wappCallRepository.deleteAll(wappCallRepository.findBySessionId(flowDBModel.getId()));
            wappMessageRepository.deleteAll(wappMessageRepository.findBySessionId(flowDBModel.getId()));

            Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(flowDBModel.getSessionId());
            sessionDBModel.ifPresent(dbModel -> sessionRepository.delete(dbModel));

            flowRepository.delete(flowDBModel);
        }

       */
    }


    public void removeAllInquiriesService() {

        /*
        List<InquiryDBModel> inquiryDBModels = inquiryRepository.findByStatus(1);
        for (InquiryDBModel inquiryDBModel : inquiryDBModels) {

            operationRepository.deleteAll(operationRepository.findBySessionId(inquiryDBModel.getId()));
            emailMessageRepository.deleteAll(emailMessageRepository.findBySessionId(inquiryDBModel.getId()));
            pushMessageRepository.deleteAll(pushMessageRepository.findBySessionId(inquiryDBModel.getId()));
            sipCallRepository.deleteAll(sipCallRepository.findBySessionId(inquiryDBModel.getId()));
            smsMessageRepository.deleteAll(smsMessageRepository.findBySessionId(inquiryDBModel.getId()));
            wappCallRepository.deleteAll(wappCallRepository.findBySessionId(inquiryDBModel.getId()));
            wappMessageRepository.deleteAll(wappMessageRepository.findBySessionId(inquiryDBModel.getId()));

            Optional<SessionDBModel> sessionDBModel = sessionRepository.findById(inquiryDBModel.getSessionId());
            sessionDBModel.ifPresent(dbModel -> sessionRepository.delete(dbModel));

            inquiryRepository.delete(inquiryDBModel);
        }

         */
    }




    public void removeSelectedTablesService(String selected) {

        if (selected.equalsIgnoreCase(AppConstant.SCENARIO_TABLES)){
            scenarioRepository.deleteAll();
        }
        if (selected.equalsIgnoreCase(AppConstant.CAMPAIGN_TABLES)){
            campaignRepository.deleteAll();
        }
        if (selected.equalsIgnoreCase(AppConstant.PROCESS_SCENARIO_TABLES)){
            processScenarioRepository.deleteAll();
        }
    }


    public void cleanSystemTablesService() {

        clientInquiryRepository.deleteAll();
        actionTempRepository.deleteAll();
        assetRepository.deleteAll();
        processRepository.deleteAll();
        campaignRepository.deleteAll();
        campaignAgentRepository.deleteAll();
        operationScenarioRepository.deleteAll();
        processEmailChannelRepository.deleteAll();
        processPushChannelRepository.deleteAll();
        processSipChannelRepository.deleteAll();
        processSmsChannelRepository.deleteAll();
        processWappChannelRepository.deleteAll();
        emailTempRepository.deleteAll();
        pushTempRepository.deleteAll();
        smsMessageTempRepository.deleteAll();
        wappMessageTempRepository.deleteAll();
        processScenarioRepository.deleteAll();
        scenarioRepository.deleteAll();

    }


}
