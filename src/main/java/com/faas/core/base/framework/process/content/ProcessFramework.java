package com.faas.core.base.framework.process.content;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessUrlDAO;
import com.faas.core.base.model.db.process.details.flow.ProcessFlowDBModel;
import com.faas.core.base.model.db.process.details.inquiry.ProcessInquiryDBModel;
import com.faas.core.base.model.db.process.settings.ProcessTypeDBModel;
import com.faas.core.base.model.ws.process.content.dto.ProcessWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.channel.temp.SmsMessageTempRepository;
import com.faas.core.base.repo.process.details.channel.temp.PushTempRepository;
import com.faas.core.base.repo.process.details.flow.ProcessFlowRepository;
import com.faas.core.base.repo.process.details.inquiry.ProcessInquiryRepository;
import com.faas.core.base.repo.process.settings.ProcessTypeRepository;
import com.faas.core.utils.config.AppConstant;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessFramework {

    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessInquiryRepository processInquiryRepository;

    @Autowired
    ProcessFlowRepository processFlowRepository;

    @Autowired
    ProcessTypeRepository processTypeRepository;

    @Autowired
    SmsMessageTempRepository smsMessageTempRepository;

    @Autowired
    PushTempRepository pushTempRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessWSDTO fillProcessWSDTO(ProcessDBModel processDBModel) {

        ProcessWSDTO processWSDTO = new ProcessWSDTO();
        processWSDTO.setProcess(processDBModel);
        if (processDBModel.getProcessType().equalsIgnoreCase(AppConstant.INQUIRY_PROCESS)){
            List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processDBModel.getId());
            if (!processInquiryDBModels.isEmpty()){
                processWSDTO.setProcessInquiry(processInquiryDBModels.get(0));
            }
        }
        if (processDBModel.getProcessType().equalsIgnoreCase(AppConstant.AUTOMATIC_PROCESS)){
            List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processDBModel.getId());
            if (!processFlowDBModels.isEmpty()){
                processWSDTO.setProcessFlow(processFlowDBModels.get(0));
            }
        }
        return processWSDTO;
    }

    public ProcessWSDTO createProcessService(String process,String processDesc,String pwaUrl,long processTypeId,String processCategory,String processState) {

        ProcessDBModel processDBModel = new ProcessDBModel();
        processDBModel.setProcess(process);
        processDBModel.setProcessDesc(processDesc);
        Optional<ProcessTypeDBModel> processTypeDBModel = processTypeRepository.findById(processTypeId);
        if (processTypeDBModel.isPresent()){
            processDBModel.setProcessTypeId(processTypeId);
            processDBModel.setProcessType(processTypeDBModel.get().getProcessType());
        }
        processDBModel.setProcessCategory(processCategory);
        List<ProcessUrlDAO>processUrls = new ArrayList<>();
        if (pwaUrl != null){
            processUrls.add(createProcessUrlDAO(AppConstant.PWA_URL,pwaUrl));
        }
        processDBModel.setProcessUrls(processUrls);
        processDBModel.setProcessDatas(new ArrayList<>());
        processDBModel.setProcessState(processState);
        processDBModel.setProcessScripts(new ArrayList<>());
        processDBModel.setuDate(appUtils.getCurrentTimeStamp());
        processDBModel.setcDate(appUtils.getCurrentTimeStamp());
        processDBModel.setStatus(1);

        processDBModel =processRepository.save(processDBModel);

        if (processDBModel.getProcessCategory().equalsIgnoreCase(AppConstant.INQUIRY_PROCESS)){
            ProcessInquiryDBModel processInquiryDBModel = processHelper.createProcessInquiryHelper(processDBModel);
            return new ProcessWSDTO(processDBModel,null,processInquiryDBModel);
        }
        if (processDBModel.getProcessCategory().equalsIgnoreCase(AppConstant.AUTOMATIC_PROCESS)){
            ProcessFlowDBModel processFlowDBModel = processHelper.createProcessFlowHelper(processDBModel);
            return new ProcessWSDTO(processDBModel, processFlowDBModel, null);
        }
        return fillProcessWSDTO(processDBModel);
    }


    public ProcessUrlDAO createProcessUrlDAO(String urlType,String processUrl){

        ProcessUrlDAO processUrlDAO = new ProcessUrlDAO();
        processUrlDAO.setUrlId(appUtils.generateUUID());
        processUrlDAO.setUrlType(urlType);
        processUrlDAO.setUrl(processUrl);
        processUrlDAO.setcDate(appUtils.getCurrentTimeStamp());
        processUrlDAO.setStatus(1);

        return processUrlDAO;
    }


    public ProcessWSDTO updateProcessService(String processId,String process,String processDesc,String processState) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()){

            processDBModel.get().setProcess(process);
            processDBModel.get().setProcessDesc(processDesc);
            processDBModel.get().setProcessState(processState);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processDBModel.get().setStatus(1);

            return fillProcessWSDTO(processRepository.save(processDBModel.get()));
        }
       return null;
    }


    public ProcessWSDTO removeProcessService(String processId) {

        Optional<ProcessDBModel> process = processRepository.findById(processId);
        if (process.isPresent()) {
            processRepository.delete(process.get());
            return fillProcessWSDTO(process.get());
        }
        return null;
    }


}
