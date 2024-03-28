package com.faas.core.base.framework.process.details.flow;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
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
                    processDBModel.get().getProcessFlow().setuDate(appUtils.getCurrentTimeStamp());

                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessDataWSDTO(processDBModel.get().getProcessFlow().getFlowDatas().get(i));
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
                    processDBModel.get().getProcessFlow().setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessDataWSDTO(processDataDAO);
                }
            }
        }
        return null;
    }



}
