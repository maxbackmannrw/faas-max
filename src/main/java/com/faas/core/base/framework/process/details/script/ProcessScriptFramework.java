package com.faas.core.base.framework.process.details.script;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessScriptDAO;
import com.faas.core.base.model.ws.process.details.script.dto.ProcessScriptWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessScriptFramework {


    @Autowired
    ProcessRepository processRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessScriptWSDTO> getProcessScriptsService(String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessScripts() != null) {
            List<ProcessScriptWSDTO> processScriptWSDTOS = new ArrayList<>();
            for (int i=0;i<processDBModel.get().getProcessScripts().size();i++){
                processScriptWSDTOS.add(new ProcessScriptWSDTO(processDBModel.get().getProcessScripts().get(i)));
            }
            return processScriptWSDTOS;
        }
        return null;
    }


    public ProcessScriptWSDTO getProcessScriptService(String processId, String scriptId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessScripts() != null) {
            for (int i=0;i<processDBModel.get().getProcessScripts().size();i++){
                if (processDBModel.get().getProcessScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)){
                    return new ProcessScriptWSDTO(processDBModel.get().getProcessScripts().get(i));
                }
            }
        }
        return null;
    }


    public ProcessScriptWSDTO createProcessScriptService(String processId,String scriptTitle,String scriptBody,int scriptOrder) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent()) {

            ProcessScriptDAO processScriptDAO = new ProcessScriptDAO();
            processScriptDAO.setScriptId(appUtils.generateUUID());
            processScriptDAO.setScriptTitle(scriptTitle);
            processScriptDAO.setScriptBody(scriptBody);
            processScriptDAO.setScriptOrder(scriptOrder);
            processScriptDAO.setcDate(appUtils.getCurrentTimeStamp());
            processScriptDAO.setStatus(1);

            if (processDBModel.get().getProcessScripts() != null){
                processDBModel.get().getProcessScripts().add(processScriptDAO);
            }else {
                List<ProcessScriptDAO> processScriptDAOS = new ArrayList<>();
                processScriptDAOS.add(processScriptDAO);
                processDBModel.get().setProcessScripts(processScriptDAOS);
            }
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return new ProcessScriptWSDTO(processScriptDAO);
        }
        return null;
    }


    public ProcessScriptWSDTO updateProcessScriptService(String processId, String scriptId, String scriptTitle, String scriptBody, int scriptOrder) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessScripts() != null) {
            for (int i=0;i<processDBModel.get().getProcessScripts().size();i++){
                if (processDBModel.get().getProcessScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)){

                    processDBModel.get().getProcessScripts().get(i).setScriptTitle(scriptTitle);
                    processDBModel.get().getProcessScripts().get(i).setScriptBody(scriptBody);
                    processDBModel.get().getProcessScripts().get(i).setScriptOrder(scriptOrder);
                    processDBModel.get().getProcessScripts().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessScriptWSDTO(processDBModel.get().getProcessScripts().get(i));
                }
            }
        }
        return null;
    }


    public ProcessScriptWSDTO removeProcessScriptService(String processId, String scriptId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessScripts() != null) {
            for (int i=0;i<processDBModel.get().getProcessScripts().size();i++){
                if (processDBModel.get().getProcessScripts().get(i).getScriptId().equalsIgnoreCase(scriptId)){

                    ProcessScriptDAO processScriptDAO = processDBModel.get().getProcessScripts().get(i);
                    processDBModel.get().getProcessScripts().remove(processScriptDAO);
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessScriptWSDTO(processScriptDAO);
                }
            }
        }
        return null;
    }



}
