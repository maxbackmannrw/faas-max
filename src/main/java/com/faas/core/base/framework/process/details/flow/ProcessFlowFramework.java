package com.faas.core.base.framework.process.details.flow;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessRemoteWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessFlowFramework {

    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessFlowWSDTO getProcessFlowService(long userId, String processId) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null){
            return new ProcessFlowWSDTO(processDBModel.get().getProcessFlow());
        }
        return null;
    }

    public ProcessFlowWSDTO updateProcessFlowService(long userId,String processId,String processFlow) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null){

            processDBModel.get().getProcessFlow().setProcessFlow(processFlow);
            processDBModel.get().getProcessFlow().setuDate(appUtils.getCurrentTimeStamp());
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return new ProcessFlowWSDTO(processDBModel.get().getProcessFlow());
        }
        return null;
    }


    public List<ProcessDataWSDTO> getProcessFlowDatasService(long userId, String processId) {

        List<ProcessDataWSDTO> processDataWSDTOS = new ArrayList<>();
        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null){
            for (int i=0;i<processDBModel.get().getProcessFlow().getFlowDatas().size();i++){
                processDataWSDTOS.add(new ProcessDataWSDTO(processDBModel.get().getProcessFlow().getFlowDatas().get(i)));
            }
        }
        return processDataWSDTOS;
    }

    public ProcessDataWSDTO getProcessFlowDataService(long userId, String processId, String dataId) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null){
            for (int i=0;i<processDBModel.get().getProcessFlow().getFlowDatas().size();i++){
                if (processDBModel.get().getProcessFlow().getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new ProcessDataWSDTO(processDBModel.get().getProcessFlow().getFlowDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessDataWSDTO createProcessFlowDataService(long userId, String processId, long typeId, String value) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent() && processDBModel.isPresent() &&  processDBModel.get().getProcessFlow() != null){

            ProcessDataDAO processDataDAO = new ProcessDataDAO();
            processDataDAO.setDataId(appUtils.generateUUID());
            processDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            processDataDAO.setValue(value);
            processDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            processDataDAO.setStatus(1);

            processDBModel.get().getProcessFlow().getFlowDatas().add(processDataDAO);
            processDBModel.get().getProcessFlow().setuDate(appUtils.getCurrentTimeStamp());
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return  new ProcessDataWSDTO(processDataDAO);
        }
        return null;
    }

    public ProcessDataWSDTO updateProcessFlowDataService(long userId, String processId, String dataId, long typeId, String value) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent() && processDBModel.isPresent() &&  processDBModel.get().getProcessFlow() != null){
            for (int i=0;i<processDBModel.get().getProcessFlow().getFlowDatas().size();i++){
                if (processDBModel.get().getProcessFlow().getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processDBModel.get().getProcessFlow().getFlowDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    processDBModel.get().getProcessFlow().getFlowDatas().get(i).setValue(value);
                    processDBModel.get().getProcessFlow().getFlowDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().getProcessFlow().getFlowDatas().get(i).setStatus(1);

                    processDBModel.get().getProcessInquiry().setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessDataWSDTO(processDBModel.get().getProcessInquiry().getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessDataWSDTO removeProcessFlowDataService(long userId, String processId, String dataId) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() &&  processDBModel.get().getProcessFlow() != null){
            for (int i=0;i<processDBModel.get().getProcessFlow().getFlowDatas().size();i++){
                if (processDBModel.get().getProcessFlow().getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    ProcessDataDAO processDataDAO = processDBModel.get().getProcessFlow().getFlowDatas().get(i);
                    processDBModel.get().getProcessFlow().getFlowDatas().remove(processDataDAO);

                    processDBModel.get().getProcessInquiry().setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessDataWSDTO(processDataDAO);
                }
            }
        }
        return null;
    }


    public List<ProcessRemoteWSDTO> getProcessFlowRemotesService(long userId, String processId) {

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null && processDBModel.get().getProcessFlow().getFlowRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessFlow().getFlowRemotes().size();i++){
                processRemoteWSDTOS.add(new ProcessRemoteWSDTO(processDBModel.get().getProcessFlow().getFlowRemotes().get(i)));
            }
        }
        return processRemoteWSDTOS;
    }

    public ProcessRemoteWSDTO getProcessFlowRemoteService(long userId, String processId, String flowRemoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null && processDBModel.get().getProcessFlow().getFlowRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessFlow().getFlowRemotes().size();i++){
                if (processDBModel.get().getProcessFlow().getFlowRemotes().get(i).getId().equalsIgnoreCase(flowRemoteId)){
                    return new ProcessRemoteWSDTO(processDBModel.get().getProcessFlow().getFlowRemotes().get(i));
                }
            }
        }
        return null;
    }

    public ProcessRemoteWSDTO createProcessFlowRemoteService(long userId,String processId,String remoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null && remoteDBModel.isPresent()) {

            ProcessRemoteDAO processRemoteDAO = remoteHelper.createFlowProcessRemoteDAO(processDBModel.get(),remoteDBModel.get());
            processDBModel.get().getProcessFlow().getFlowRemotes().add(processRemoteDAO);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return new ProcessRemoteWSDTO(processRemoteDAO);
        }
        return null;
    }

    public ProcessRemoteWSDTO updateProcessFlowRemoteService(long userId,String processId,String flowRemoteId,String remoteState) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null && processDBModel.get().getProcessFlow().getFlowRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessFlow().getFlowRemotes().size();i++){
                if (processDBModel.get().getProcessFlow().getFlowRemotes().get(i).getId().equalsIgnoreCase(flowRemoteId)){

                    processDBModel.get().getProcessFlow().getFlowRemotes().get(i).setRemoteState(remoteState);
                    processDBModel.get().getProcessFlow().getFlowRemotes().get(i).setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().getProcessFlow().setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessRemoteWSDTO(processDBModel.get().getProcessFlow().getFlowRemotes().get(i));
                }
            }
        }
        return null;
    }

    public ProcessRemoteWSDTO removeProcessFlowRemoteService(long userId, String processId, String flowRemoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessFlow() != null && processDBModel.get().getProcessFlow().getFlowRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessFlow().getFlowRemotes().size();i++){
                if (processDBModel.get().getProcessFlow().getFlowRemotes().get(i).getId().equalsIgnoreCase(flowRemoteId)){

                    ProcessRemoteDAO processRemoteDAO =processDBModel.get().getProcessFlow().getFlowRemotes().get(i);
                    processDBModel.get().getProcessFlow().getFlowRemotes().remove(processRemoteDAO);
                    processDBModel.get().getProcessFlow().setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessRemoteWSDTO(processRemoteDAO);
                }
            }
        }
        return null;
    }

}
