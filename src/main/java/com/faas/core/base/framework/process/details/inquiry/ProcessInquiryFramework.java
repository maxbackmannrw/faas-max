package com.faas.core.base.framework.process.details.inquiry;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessDataDAO;
import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.db.utility.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryWSDTO;
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
public class ProcessInquiryFramework {

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


    public ProcessInquiryWSDTO getProcessInquiryService(long userId, String processId) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() &&  processDBModel.get().getProcessInquiry() != null){
            return new ProcessInquiryWSDTO(processDBModel.get().getProcessInquiry());
        }
        return null;
    }

    public ProcessInquiryWSDTO updateProcessInquiryService(long userId, String processId,String processInquiry) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() &&  processDBModel.get().getProcessInquiry() != null){

            processDBModel.get().getProcessInquiry().setProcessInquiry(processInquiry);
            processDBModel.get().getProcessInquiry().setuDate(appUtils.getCurrentTimeStamp());
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return new ProcessInquiryWSDTO(processDBModel.get().getProcessInquiry());
        }
        return null;
    }



    public List<ProcessDataWSDTO> getProcessInquiryDatasService(long userId, String processId) {

        List<ProcessDataWSDTO>processDataWSDTOS = new ArrayList<>();
        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() &&  processDBModel.get().getProcessInquiry() != null){
            for (int i=0;i<processDBModel.get().getProcessInquiry().getInquiryDatas().size();i++){
                processDataWSDTOS.add(new ProcessDataWSDTO(processDBModel.get().getProcessInquiry().getInquiryDatas().get(i)));
            }
        }
        return processDataWSDTOS;
    }

    public ProcessDataWSDTO getProcessInquiryDataService(long userId, String processId, String dataId) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() &&  processDBModel.get().getProcessInquiry() != null){
            for (int i=0;i<processDBModel.get().getProcessInquiry().getInquiryDatas().size();i++){
                if (processDBModel.get().getProcessInquiry().getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new ProcessDataWSDTO(processDBModel.get().getProcessInquiry().getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessDataWSDTO createProcessInquiryDataService(long userId, String processId, long typeId, String value) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent() && processDBModel.isPresent() &&  processDBModel.get().getProcessInquiry() != null){

            ProcessDataDAO processDataDAO = new ProcessDataDAO();
            processDataDAO.setDataId(appUtils.generateUUID());
            processDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            processDataDAO.setValue(value);
            processDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            processDataDAO.setStatus(1);

            processDBModel.get().getProcessInquiry().getInquiryDatas().add(processDataDAO);
            processDBModel.get().getProcessInquiry().setuDate(appUtils.getCurrentTimeStamp());
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return  new ProcessDataWSDTO(processDataDAO);
        }
        return null;
    }

    public ProcessDataWSDTO updateProcessInquiryDataService(long userId, String processId, String dataId, long typeId, String value) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(typeId);
        if (dataTypeDBModel.isPresent() && processDBModel.isPresent() &&  processDBModel.get().getProcessInquiry() != null){
            for (int i=0;i<processDBModel.get().getProcessInquiry().getInquiryDatas().size();i++){
                if (processDBModel.get().getProcessInquiry().getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processDBModel.get().getProcessInquiry().getInquiryDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    processDBModel.get().getProcessInquiry().getInquiryDatas().get(i).setValue(value);
                    processDBModel.get().getProcessInquiry().getInquiryDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().getProcessInquiry().getInquiryDatas().get(i).setStatus(1);

                    processDBModel.get().getProcessInquiry().setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessDataWSDTO(processDBModel.get().getProcessInquiry().getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public ProcessDataWSDTO removeProcessInquiryDataService(long userId, String processId, String dataId) {

        Optional<ProcessDBModel>processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() &&  processDBModel.get().getProcessInquiry() != null){
            for (int i=0;i<processDBModel.get().getProcessInquiry().getInquiryDatas().size();i++){
                if (processDBModel.get().getProcessInquiry().getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    ProcessDataDAO processDataDAO = processDBModel.get().getProcessInquiry().getInquiryDatas().get(i);
                    processDBModel.get().getProcessInquiry().getInquiryDatas().remove(processDataDAO);

                    processDBModel.get().getProcessInquiry().setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessDataWSDTO(processDataDAO);
                }
            }
        }
        return null;
    }


    public List<ProcessRemoteWSDTO> getProcessInquiryRemotesService(long userId, String processId) {

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessInquiry() != null && processDBModel.get().getProcessInquiry().getInquiryRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessInquiry().getInquiryRemotes().size();i++){
                processRemoteWSDTOS.add(new ProcessRemoteWSDTO(processDBModel.get().getProcessInquiry().getInquiryRemotes().get(i)));
            }
        }
        return processRemoteWSDTOS;
    }

    public ProcessRemoteWSDTO getProcessInquiryRemoteService(long userId, String processId, String inquiryRemoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessInquiry() != null && processDBModel.get().getProcessInquiry().getInquiryRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessInquiry().getInquiryRemotes().size();i++){
                if (processDBModel.get().getProcessInquiry().getInquiryRemotes().get(i).getId().equalsIgnoreCase(inquiryRemoteId)){
                    return new ProcessRemoteWSDTO(processDBModel.get().getProcessInquiry().getInquiryRemotes().get(i));
                }
            }
        }
        return null;
    }

    public ProcessRemoteWSDTO createProcessInquiryRemoteService(long userId,String processId,String remoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessInquiry() != null && remoteDBModel.isPresent()) {

            ProcessRemoteDAO processRemoteDAO = remoteHelper.createInquiryProcessRemoteDAO(remoteDBModel.get());
            processDBModel.get().getProcessInquiry().getInquiryRemotes().add(processRemoteDAO);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return new ProcessRemoteWSDTO(processRemoteDAO);
        }
        return null;
    }


    public ProcessRemoteWSDTO removeProcessInquiryRemoteService(long userId, String processId, String inquiryRemoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessInquiry() != null && processDBModel.get().getProcessInquiry().getInquiryRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessInquiry().getInquiryRemotes().size();i++){
                if (processDBModel.get().getProcessInquiry().getInquiryRemotes().get(i).getId().equalsIgnoreCase(inquiryRemoteId)){

                    ProcessRemoteDAO processRemoteDAO =processDBModel.get().getProcessInquiry().getInquiryRemotes().get(i);
                    processDBModel.get().getProcessInquiry().getInquiryRemotes().remove(processRemoteDAO);
                    processDBModel.get().getProcessInquiry().setuDate(appUtils.getCurrentTimeStamp());
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessRemoteWSDTO(processRemoteDAO);
                }
            }
        }
        return null;
    }


}
