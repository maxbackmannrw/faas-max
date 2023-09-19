package com.faas.core.base.framework.process.details.flow;

import com.faas.core.base.model.db.process.details.flow.ProcessFlowDBModel;
import com.faas.core.base.model.db.process.details.flow.dao.FlowDataDAO;
import com.faas.core.base.model.db.process.details.flow.dao.FlowUrlDAO;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.flow.dto.FlowDataWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.FlowUrlWSDTO;
import com.faas.core.base.model.ws.process.details.flow.dto.ProcessFlowWSDTO;
import com.faas.core.base.repo.process.details.flow.ProcessFlowRepository;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
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

    public ProcessFlowWSDTO createProcessFlowService(long userId,String processId,String processFlow,String flowDesc,String flowType) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (processFlowDBModels.isEmpty()){

            ProcessFlowDBModel processFlowDBModel = new ProcessFlowDBModel();
            processFlowDBModel.setProcessId(processId);
            processFlowDBModel.setProcessFlow(processFlow);
            processFlowDBModel.setFlowDesc(flowDesc);
            processFlowDBModel.setFlowUrls(new ArrayList<>());
            processFlowDBModel.setFlowDatas(new ArrayList<>());
            processFlowDBModel.setFlowType(flowType);
            processFlowDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processFlowDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processFlowDBModel.setStatus(1);

            return new ProcessFlowWSDTO(processFlowRepository.save(processFlowDBModel));
        }else {
            processFlowDBModels.get(0).setProcessFlow(processFlow);
            processFlowDBModels.get(0).setFlowDesc(flowDesc);
            processFlowDBModels.get(0).setFlowType(flowType);
            processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessFlowWSDTO(processFlowRepository.save(processFlowDBModels.get(0)));
        }
    }

    public ProcessFlowWSDTO removeProcessFlowService(long userId, String processId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty()){
            processFlowRepository.delete(processFlowDBModels.get(0));
            return new ProcessFlowWSDTO(processFlowRepository.save(processFlowDBModels.get(0)));
        }
        return null;
    }



    public List<FlowDataWSDTO> getProcessFlowDatasService(long userId, String processId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowDatas() != null){
            List<FlowDataWSDTO>flowDataWSDTOS = new ArrayList<>();
            for (int i=0;i<processFlowDBModels.get(0).getFlowDatas().size();i++){
                flowDataWSDTOS.add(new FlowDataWSDTO(processFlowDBModels.get(0).getFlowDatas().get(i)));
            }
            return flowDataWSDTOS;
        }
        return null;
    }

    public FlowDataWSDTO getProcessFlowDataService(long userId,String processId,String dataId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowDatas() != null){
            for (int i=0;i<processFlowDBModels.get(0).getFlowDatas().size();i++){
                if (processFlowDBModels.get(0).getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new FlowDataWSDTO(processFlowDBModels.get(0).getFlowDatas().get(i));
                }
            }
        }
        return null;
    }

    public FlowDataWSDTO createProcessFlowDataService(long userId,String processId,long typeId,String value) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!processFlowDBModels.isEmpty() && dataTypeDBModel.isPresent()){

            FlowDataDAO flowDataDAO = new FlowDataDAO();
            flowDataDAO.setDataId(appUtils.generateUUID());
            flowDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            flowDataDAO.setValue(value);
            flowDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            flowDataDAO.setStatus(1);

            processFlowDBModels.get(0).getFlowDatas().add(flowDataDAO);
            processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            processFlowRepository.save(processFlowDBModels.get(0));

            return new FlowDataWSDTO(flowDataDAO);
        }
        return null;
    }

    public FlowDataWSDTO updateProcessFlowDataService(long userId, String processId,String dataId,long typeId,String value) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);

        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<processFlowDBModels.get(0).getFlowDatas().size();i++){
                if (processFlowDBModels.get(0).getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processFlowDBModels.get(0).getFlowDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    processFlowDBModels.get(0).getFlowDatas().get(i).setValue(value);
                    processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processFlowRepository.save(processFlowDBModels.get(0));

                    return new FlowDataWSDTO(processFlowDBModels.get(0).getFlowDatas().get(i));
                }
            }
        }
        return null;
    }

    public FlowDataWSDTO removeProcessFlowDataService(long userId, String processId,String dataId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowDatas() != null){
            for (int i=0;i<processFlowDBModels.get(0).getFlowDatas().size();i++){
                if (processFlowDBModels.get(0).getFlowDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    processFlowDBModels.get(0).getFlowDatas().remove(i);
                    processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

                    return new FlowDataWSDTO(processFlowDBModels.get(0).getFlowDatas().get(i));
                }
            }
        }
        return null;
    }


    public List<FlowUrlWSDTO> getProcessFlowUrlsService(long userId, String processId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowUrls() != null){
            List<FlowUrlWSDTO>flowUrlWSDTOS = new ArrayList<>();
            for (int i=0;i<processFlowDBModels.get(0).getFlowUrls().size();i++){
                flowUrlWSDTOS.add(new FlowUrlWSDTO(processFlowDBModels.get(0).getFlowUrls().get(i)));
            }
            return flowUrlWSDTOS;
        }
        return null;
    }

    public FlowUrlWSDTO getProcessFlowUrlService(long userId, String processId,String urlId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowUrls() != null){
            for (int i=0;i<processFlowDBModels.get(0).getFlowUrls().size();i++){
                if (processFlowDBModels.get(0).getFlowUrls().get(i).getUrlId().equalsIgnoreCase(urlId)){
                    return new FlowUrlWSDTO(processFlowDBModels.get(0).getFlowUrls().get(i));
                }
            }
        }
        return null;
    }

    public FlowUrlWSDTO createProcessFlowUrlService(long userId, String processId,String urlType,String url) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowUrls() != null){
            FlowUrlDAO flowUrlDAO = new FlowUrlDAO();
            flowUrlDAO.setUrlId(appUtils.generateUUID());
            flowUrlDAO.setUrlType(urlType);
            flowUrlDAO.setUrl(url);
            flowUrlDAO.setcDate(appUtils.getCurrentTimeStamp());
            flowUrlDAO.setStatus(1);

            processFlowDBModels.get(0).getFlowUrls().add(flowUrlDAO);
            processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new FlowUrlWSDTO(flowUrlDAO);
        }
        return null;
    }

    public FlowUrlWSDTO updateProcessFlowUrlService(long userId,String processId,String urlId,String urlType,String url) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowUrls() != null){
            for (int i=0;i<processFlowDBModels.get(0).getFlowUrls().size();i++){
                if (processFlowDBModels.get(0).getFlowUrls().get(i).getUrlId().equalsIgnoreCase(urlId)){
                    processFlowDBModels.get(0).getFlowUrls().get(i).setUrlType(urlType);
                    processFlowDBModels.get(0).getFlowUrls().get(i).setUrl(url);
                    processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

                    return new FlowUrlWSDTO(processFlowDBModels.get(0).getFlowUrls().get(i));
                }
            }
        }
        return null;
    }

    public FlowUrlWSDTO removeProcessFlowUrlService(long userId, String processId,String urlId) {

        List<ProcessFlowDBModel> processFlowDBModels = processFlowRepository.findByProcessId(processId);
        if (!processFlowDBModels.isEmpty() && processFlowDBModels.get(0).getFlowUrls() != null){
            for (int i=0;i<processFlowDBModels.get(0).getFlowUrls().size();i++){
                if (processFlowDBModels.get(0).getFlowUrls().get(i).getUrlId().equalsIgnoreCase(urlId)){
                    processFlowDBModels.get(0).getFlowUrls().remove(i);
                    processFlowDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

                    return new FlowUrlWSDTO(processFlowDBModels.get(0).getFlowUrls().get(i));
                }
            }
        }
        return null;
    }



}
