package com.faas.core.base.framework.process.details.inquiry;

import com.faas.core.base.model.db.process.details.inquiry.ProcessInquiryDBModel;
import com.faas.core.base.model.db.process.details.inquiry.dao.ProcessInquiryDataDAO;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryDataWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryWSDTO;
import com.faas.core.base.repo.process.details.inquiry.ProcessInquiryRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProcessInquiryFramework {

    @Autowired
    ProcessInquiryRepository processInquiryRepository;

    @Autowired
    DataTypeRepository dataTypeRepository;

    @Autowired
    AppUtils appUtils;


    public ProcessInquiryWSDTO getProcessInquiryService(long userId, String processId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty()){
            return new ProcessInquiryWSDTO(processInquiryDBModels.get(0));
        }
        return null;
    }

    public ProcessInquiryWSDTO updateProcessInquiryService(long userId, String processId,String processInquiry,String inquiryDesc) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty()){

            processInquiryDBModels.get(0).setProcessInquiry(processInquiry);
            processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());

            return new ProcessInquiryWSDTO(processInquiryRepository.save(processInquiryDBModels.get(0)));
        }
        return null;
    }


    public ProcessInquiryWSDTO removeProcessInquiryService(long userId, String processId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty()){
            processInquiryRepository.delete(processInquiryDBModels.get(0));
            return new ProcessInquiryWSDTO(processInquiryDBModels.get(0));
        }
        return null;
    }



    public List<ProcessInquiryDataWSDTO> getProcessInquiryDatasService(long userId, String processId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryDatas() != null){
            List<ProcessInquiryDataWSDTO> processInquiryDataWSDTOS = new ArrayList<>();
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryDatas().size();i++){
                processInquiryDataWSDTOS.add(new ProcessInquiryDataWSDTO(processInquiryDBModels.get(0).getInquiryDatas().get(i)));
            }
            return processInquiryDataWSDTOS;
        }
        return null;
    }

    public ProcessInquiryDataWSDTO getProcessInquiryDataService(long userId, String processId, String dataId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryDatas() != null){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryDatas().size();i++){
                if (processInquiryDBModels.get(0).getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new ProcessInquiryDataWSDTO(processInquiryDBModels.get(0).getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessInquiryDataWSDTO createProcessInquiryDataService(long userId, String processId, long typeId, String value) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!processInquiryDBModels.isEmpty() && dataTypeDBModel.isPresent()){

            ProcessInquiryDataDAO processInquiryDataDAO = new ProcessInquiryDataDAO();
            processInquiryDataDAO.setDataId(appUtils.generateUUID());
            processInquiryDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            processInquiryDataDAO.setValue(value);
            processInquiryDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            processInquiryDataDAO.setStatus(1);

            processInquiryDBModels.get(0).getInquiryDatas().add(processInquiryDataDAO);
            processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            processInquiryRepository.save(processInquiryDBModels.get(0));

            return new ProcessInquiryDataWSDTO(processInquiryDataDAO);
        }
        return null;
    }


    public ProcessInquiryDataWSDTO updateProcessInquiryDataService(long userId, String processId, String dataId, long typeId, String value) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryDatas().size();i++){
                if (processInquiryDBModels.get(0).getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processInquiryDBModels.get(0).getInquiryDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    processInquiryDBModels.get(0).getInquiryDatas().get(i).setValue(value);
                    processInquiryDBModels.get(0).getInquiryDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processInquiryRepository.save(processInquiryDBModels.get(0));

                    return new ProcessInquiryDataWSDTO(processInquiryDBModels.get(0).getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessInquiryDataWSDTO removeProcessInquiryDataService(long userId, String processId, String dataId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryDatas() != null){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryDatas().size();i++){
                if (processInquiryDBModels.get(0).getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processInquiryDBModels.get(0).getInquiryDatas().remove(processInquiryDBModels.get(0).getInquiryDatas().get(i));
                    processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processInquiryRepository.save(processInquiryDBModels.get(0));

                    return new ProcessInquiryDataWSDTO(processInquiryDBModels.get(0).getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }



}
