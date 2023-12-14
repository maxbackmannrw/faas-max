package com.faas.core.base.framework.process.details.content;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDetailsWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessRemoteWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
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
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessDetailsWSDTO getProcessDetailsService(String processId) {
        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        return processDBModel.map(dbModel -> processHelper.createProcessDetailsWSDTO(dbModel)).orElse(null);
    }


    public ProcessDataWSDTO fillProcessDataWSDTO(ProcessDataDAO processDataDAO) {

        ProcessDataWSDTO processDataWSDTO = new ProcessDataWSDTO();
        processDataWSDTO.setProcessData(processDataDAO);
        return processDataWSDTO;
    }

    public ProcessDataDAO createProcessDataService(String processId, long typeId, String value) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
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

    public ProcessDataDAO updateProcessDataService(String processId, String dataId, long typeId, String value) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
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



    public List<ProcessRemoteWSDTO> getProcessRemotesService(long userId, String processId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessRemotes() != null) {
            List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
            for (int i=0;i<processDBModel.get().getProcessRemotes().size();i++){
                processRemoteWSDTOS.add(new ProcessRemoteWSDTO(processDBModel.get().getProcessRemotes().get(i)));
            }
            return processRemoteWSDTOS;
        }
        return null;
    }

    public ProcessRemoteWSDTO getProcessRemoteService(long userId,String processId,String processRemoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessRemotes().size();i++){

            }
        }
        return null;
    }

    public ProcessRemoteWSDTO createProcessRemoteService(long userId,String processId,String remoteId) {


        return null;
    }

    public ProcessRemoteWSDTO updateProcessRemoteService(long userId,String processId,String processRemoteId,String remoteState) {


        return null;
    }

    public ProcessRemoteWSDTO removeProcessRemoteService(long userId,String processId,String processRemoteId) {

        return null;
    }


}
