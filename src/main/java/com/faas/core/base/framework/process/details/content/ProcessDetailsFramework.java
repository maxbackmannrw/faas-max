package com.faas.core.base.framework.process.details.content;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.process.content.dao.CallScriptDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessUrlDAO;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessUrlWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.CallScriptWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessDetailsFramework {

    @Autowired
    ProcessHelper processHelper;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessDetailsWSDTO getProcessDetailsService(String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        return processDBModel.map(dbModel -> processHelper.createProcessDetailsWSDTO(dbModel)).orElse(null);
    }


    public ProcessDetailsWSDTO getManualProcessService(String processId) {

        return null;
    }


    public ProcessDetailsWSDTO getInquiryProcessService(String processId) {

        return null;
    }


    public ProcessDetailsWSDTO getAutomaticProcessService(String processId) {

        return null;
    }


    public ProcessDataWSDTO fillProcessDataWSDTO(ProcessDataDAO processDataDAO) {

        ProcessDataWSDTO processDataWSDTO = new ProcessDataWSDTO();
        processDataWSDTO.setProcessData(processDataDAO);
        return processDataWSDTO;
    }


    public ProcessDataDAO createProcessDataService(String processId, long dataTypeId, String value) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (processDBModel.isPresent() && dataTypeDBModel.isPresent()) {

            ProcessDataDAO processDataDAO = new ProcessDataDAO();
            processDataDAO.setDataId(appUtils.generateUUID());
            processDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            processDataDAO.setValue(value);
            processDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            processDataDAO.setStatus(1);

            processDBModel.get().getProcessDatas().add(processDataDAO);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return processDataDAO;
        }
        return null;
    }


    public ProcessDataDAO updateProcessDataService(String processId, String dataId, long dataTypeId, String value) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dataTypeId);
        if (processDBModel.isPresent() && dataTypeDBModel.isPresent()) {
            for (int i = 0; i < processDBModel.get().getProcessDatas().size(); i++) {
                if (processDBModel.get().getProcessDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {

                    processDBModel.get().getProcessDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    processDBModel.get().getProcessDatas().get(i).setValue(value);
                    processDBModel.get().getProcessDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return processDBModel.get().getProcessDatas().get(i);
                }
            }
        }
        return null;
    }


    public ProcessDataDAO removeProcessDataService(String processId, String dataId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessDatas() != null) {
            for (int i = 0; i < processDBModel.get().getProcessDatas().size(); i++) {
                if (processDBModel.get().getProcessDatas().get(i).getDataId().equalsIgnoreCase(dataId)) {
                    ProcessDataDAO processDataDAO = processDBModel.get().getProcessDatas().get(i);
                    processDBModel.get().getProcessDatas().remove(processDataDAO);
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return processDataDAO;
                }
            }
        }
        return null;
    }


    public ProcessUrlWSDTO fillProcessUrlWSDTO(ProcessUrlDAO processUrlDAO) {

        ProcessUrlWSDTO processUrlWSDTO = new ProcessUrlWSDTO();
        processUrlWSDTO.setProcessUrl(processUrlDAO);
        return processUrlWSDTO;
    }


    public ProcessUrlDAO createProcessUrlService(String processId, String urlType, String url) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()) {

            ProcessUrlDAO processUrlDAO = new ProcessUrlDAO();
            processUrlDAO.setUrlId(appUtils.generateUUID());
            processUrlDAO.setUrlType(urlType);
            processUrlDAO.setUrl(url);
            processUrlDAO.setcDate(appUtils.getCurrentTimeStamp());
            processUrlDAO.setStatus(1);

            processDBModel.get().getProcessUrls().add(processUrlDAO);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return processUrlDAO;
        }
        return null;
    }


    public ProcessUrlDAO updateProcessUrlService(String processId, String urlId, String urlType, String url) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()) {
            for (int i = 0; i < processDBModel.get().getProcessUrls().size(); i++) {
                if (processDBModel.get().getProcessUrls().get(i).getUrlId().equalsIgnoreCase(urlId)) {
                    processDBModel.get().getProcessUrls().get(i).setUrlType(urlType);
                    processDBModel.get().getProcessUrls().get(i).setUrl(url);
                    processDBModel.get().getProcessUrls().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return processDBModel.get().getProcessUrls().get(i);
                }
            }
        }
        return null;
    }


    public ProcessUrlDAO removeProcessUrlService(String processId, String urlId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessUrls() != null) {
            for (int i = 0; i < processDBModel.get().getProcessUrls().size(); i++) {
                if (processDBModel.get().getProcessUrls().get(i).getUrlId().equalsIgnoreCase(urlId)) {
                    ProcessUrlDAO processUrlDAO = processDBModel.get().getProcessUrls().get(i);
                    processDBModel.get().getProcessUrls().remove(processUrlDAO);
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return processUrlDAO;
                }
            }
        }
        return null;
    }


    public List<CallScriptWSDTO> getCallScriptsService(String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getCallScripts() != null) {
            List<CallScriptWSDTO> callScriptWSDTOS = new ArrayList<>();
            for (int i=0;i<processDBModel.get().getCallScripts().size();i++){
                callScriptWSDTOS.add(new CallScriptWSDTO(processDBModel.get().getCallScripts().get(i)));
            }
            return callScriptWSDTOS;
        }
        return null;
    }


    public CallScriptWSDTO getCallScriptService(String processId, String scriptId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getCallScripts() != null) {
            for (int i=0;i<processDBModel.get().getCallScripts().size();i++){
                if (processDBModel.get().getCallScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)){
                    return new CallScriptWSDTO(processDBModel.get().getCallScripts().get(i));
                }
            }
        }
        return null;
    }


    public CallScriptWSDTO createCallScriptService(String processId, int scriptOrder, String scriptTitle, String scriptBody) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()) {

            CallScriptDAO callScriptDAO = new CallScriptDAO();
            callScriptDAO.setScriptId(appUtils.generateUUID());
            callScriptDAO.setScriptOrder(scriptOrder);
            callScriptDAO.setScriptTitle(scriptTitle);
            callScriptDAO.setScriptBody(scriptBody);
            callScriptDAO.setcDate(appUtils.getCurrentTimeStamp());
            callScriptDAO.setStatus(1);

            if (processDBModel.get().getCallScripts() != null){
                processDBModel.get().getCallScripts().add(callScriptDAO);
            }else {
                List<CallScriptDAO> callScriptDAOS = new ArrayList<>();
                callScriptDAOS.add(callScriptDAO);
                processDBModel.get().setCallScripts(callScriptDAOS);
            }
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return new CallScriptWSDTO(callScriptDAO);
        }
        return null;
    }


    public CallScriptWSDTO updateCallScriptService(String processId, String scriptId, int scriptOrder, String scriptTitle, String scriptBody) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getCallScripts() != null) {
            for (int i=0;i<processDBModel.get().getCallScripts().size();i++){
                if (processDBModel.get().getCallScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)){

                    processDBModel.get().getCallScripts().get(i).setScriptOrder(scriptOrder);
                    processDBModel.get().getCallScripts().get(i).setScriptTitle(scriptTitle);
                    processDBModel.get().getCallScripts().get(i).setScriptBody(scriptBody);
                    processDBModel.get().getCallScripts().get(i).setcDate(appUtils.getCurrentTimeStamp());

                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new CallScriptWSDTO(processDBModel.get().getCallScripts().get(i));
                }
            }
        }
        return null;
    }


    public CallScriptWSDTO removeCallScriptService(String processId, String scriptId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getCallScripts() != null) {
            for (int i=0;i<processDBModel.get().getCallScripts().size();i++){
                if (processDBModel.get().getCallScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)){

                    CallScriptDAO callScriptDAO = processDBModel.get().getCallScripts().get(i);
                    processDBModel.get().getCallScripts().remove(callScriptDAO);
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new CallScriptWSDTO(callScriptDAO);
                }
            }
        }
        return null;
    }


}
