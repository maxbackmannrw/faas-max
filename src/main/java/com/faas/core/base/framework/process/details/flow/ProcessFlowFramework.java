package com.faas.core.base.framework.process.details.flow;

import com.faas.core.base.model.db.process.details.flow.ProcessFlowDBModel;
import com.faas.core.base.model.db.process.details.flow.dao.ProcessFlowDataDAO;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowDataWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;
import com.faas.core.base.repo.process.details.flow.ProcessFlowRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessFlowFramework {

    @Autowired
    ProcessFlowRepository processFlowRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessFlowWSDTO getProcessFlowService(long userId, String processId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty()){
            return new ProcessFlowWSDTO(processFlowDBModels.get(0));
        }
        return null;
    }

    public ProcessFlowWSDTO updateProcessFlowService(long userId,String processId,String processFlow,String flowDesc) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty()){

            processFlowDBModels.get(0).setProcessFlow(processFlow);
            processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessFlowWSDTO(processFlowRepository.save(processFlowDBModels.get(0)));
        }
        return null;
    }

    public ProcessFlowWSDTO removeProcessFlowService(long userId, String processId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty()){
            processFlowRepository.delete(processFlowDBModels.get(0));
            return new ProcessFlowWSDTO(processFlowRepository.save(processFlowDBModels.get(0)));
        }
        return null;
    }



    public List<ProcessFlowDataWSDTO> getProcessFlowDatasService(long userId, String processId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowDatas() != null){
            List<ProcessFlowDataWSDTO> processFlowDataWSDTOS = new ArrayList<>();
            for (int i=0;i<processFlowDBModels.get(0).getFlowDatas().size();i++){
                processFlowDataWSDTOS.add(new ProcessFlowDataWSDTO(processFlowDBModels.get(0).getFlowDatas().get(i)));
            }
            return processFlowDataWSDTOS;
        }
        return null;
    }

    public ProcessFlowDataWSDTO getProcessFlowDataService(long userId, String processId, String dataId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowDatas() != null){
            for (int i=0;i<processFlowDBModels.get(0).getFlowDatas().size();i++){
                if (processFlowDBModels.get(0).getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new ProcessFlowDataWSDTO(processFlowDBModels.get(0).getFlowDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessFlowDataWSDTO createProcessFlowDataService(long userId, String processId, long typeId, String value) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!processFlowDBModels.isEmpty() && dataTypeDBModel.isPresent()){

            ProcessFlowDataDAO processFlowDataDAO = new ProcessFlowDataDAO();
            processFlowDataDAO.setDataId(appUtils.generateUUID());
            processFlowDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            processFlowDataDAO.setValue(value);
            processFlowDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            processFlowDataDAO.setStatus(1);

            processFlowDBModels.get(0).getFlowDatas().add(processFlowDataDAO);
            processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            processFlowRepository.save(processFlowDBModels.get(0));

            return new ProcessFlowDataWSDTO(processFlowDataDAO);
        }
        return null;
    }

    public ProcessFlowDataWSDTO updateProcessFlowDataService(long userId, String processId, String dataId, long typeId, String value) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<processFlowDBModels.get(0).getFlowDatas().size();i++){
                if (processFlowDBModels.get(0).getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processFlowDBModels.get(0).getFlowDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    processFlowDBModels.get(0).getFlowDatas().get(i).setValue(value);
                    processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processFlowRepository.save(processFlowDBModels.get(0));

                    return new ProcessFlowDataWSDTO(processFlowDBModels.get(0).getFlowDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessFlowDataWSDTO removeProcessFlowDataService(long userId, String processId, String dataId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowDatas() != null){
            for (int i=0;i<processFlowDBModels.get(0).getFlowDatas().size();i++){
                if (processFlowDBModels.get(0).getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processFlowDBModels.get(0).getFlowDatas().remove(i);
                    processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processFlowRepository.save(processFlowDBModels.get(0));

                    return new ProcessFlowDataWSDTO(processFlowDBModels.get(0).getFlowDatas().get(i));
                }
            }
        }
        return null;
    }


}
