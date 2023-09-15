package com.faas.core.base.framework.process.details.inquiry;

import com.faas.core.base.model.db.process.details.inquiry.ProcessInquiryDBModel;
import com.faas.core.base.model.db.process.details.inquiry.dao.InquiryDataDAO;
import com.faas.core.base.model.db.process.details.inquiry.dao.InquiryUrlDAO;
import com.faas.core.base.model.db.utils.datatype.DataTypeDBModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.InquiryDataWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.dto.InquiryUrlWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryWSDTO;
import com.faas.core.base.repo.process.details.inquiry.ProcessInquiryRepository;
import com.faas.core.base.repo.utils.datatype.DataTypeRepository;
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

    public ProcessInquiryWSDTO createProcessInquiryService(long userId, String processId,String processInquiry,String inquiryType) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (processInquiryDBModels.isEmpty()){

            ProcessInquiryDBModel processInquiryDBModel = new ProcessInquiryDBModel();
            processInquiryDBModel.setProcessId(processId);
            processInquiryDBModel.setProcessInquiry(processInquiry);
            processInquiryDBModel.setInquiryUrls(new ArrayList<>());
            processInquiryDBModel.setInquiryDatas(new ArrayList<>());
            processInquiryDBModel.setInquiryType(inquiryType);
            processInquiryDBModel.setcDate(appUtils.getCurrentTimeStamp());
            processInquiryDBModel.setuDate(appUtils.getCurrentTimeStamp());
            processInquiryDBModel.setStatus(1);

            return new ProcessInquiryWSDTO(processInquiryRepository.save(processInquiryDBModel));
        }
        return null;
    }

    public ProcessInquiryWSDTO updateProcessInquiryService(long userId, String processId,String processInquiry,String inquiryType) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty()){

            processInquiryDBModels.get(0).setProcessId(processId);
            processInquiryDBModels.get(0).setProcessInquiry(processInquiry);
            processInquiryDBModels.get(0).setInquiryType(inquiryType);
            processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            processInquiryDBModels.get(0).setStatus(1);

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



    public List<InquiryDataWSDTO> getProcessInquiryDatasService(long userId, String processId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryDatas() != null){
            List<InquiryDataWSDTO>inquiryDataWSDTOS = new ArrayList<>();
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryDatas().size();i++){
                inquiryDataWSDTOS.add(new InquiryDataWSDTO(processInquiryDBModels.get(0).getInquiryDatas().get(i)));
            }
            return inquiryDataWSDTOS;
        }
        return null;
    }

    public InquiryDataWSDTO getProcessInquiryDataService(long userId, String processId,String dataId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryDatas() != null){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryDatas().size();i++){
                if (processInquiryDBModels.get(0).getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){
                    return new InquiryDataWSDTO(processInquiryDBModels.get(0).getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public InquiryDataWSDTO createProcessInquiryDataService(long userId, String processId,long dateTypeId,String value) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dateTypeId);
        if (!processInquiryDBModels.isEmpty() && dataTypeDBModel.isPresent()){

            InquiryDataDAO inquiryDataDAO = new InquiryDataDAO();
            inquiryDataDAO.setDataId(appUtils.generateUUID());
            inquiryDataDAO.setDataType(dataTypeDBModel.get().getDataType());
            inquiryDataDAO.setValue(value);
            inquiryDataDAO.setcDate(appUtils.getCurrentTimeStamp());
            inquiryDataDAO.setStatus(1);

            if (processInquiryDBModels.get(0).getInquiryDatas() != null){
                processInquiryDBModels.get(0).getInquiryDatas().add(inquiryDataDAO);
            }else {
                List<InquiryDataDAO>inquiryDataDAOS = new ArrayList<>();
                inquiryDataDAOS.add(inquiryDataDAO);
                processInquiryDBModels.get(0).setInquiryDatas(inquiryDataDAOS);
            }
            processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            processInquiryRepository.save(processInquiryDBModels.get(0));

            return new InquiryDataWSDTO(inquiryDataDAO);
        }
        return null;
    }

    public InquiryDataWSDTO updateProcessInquiryDataService(long userId,String processId,String dataId,long dateTypeId,String value) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        Optional<DataTypeDBModel> dataTypeDBModel = dataTypeRepository.findById(dateTypeId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryDatas() != null && dataTypeDBModel.isPresent()){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryDatas().size();i++){
                if (processInquiryDBModels.get(0).getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processInquiryDBModels.get(0).getInquiryDatas().get(i).setDataType(dataTypeDBModel.get().getDataType());
                    processInquiryDBModels.get(0).getInquiryDatas().get(i).setValue(value);
                    processInquiryDBModels.get(0).getInquiryDatas().get(i).setcDate(appUtils.getCurrentTimeStamp());
                    processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processInquiryRepository.save(processInquiryDBModels.get(0));

                    return new InquiryDataWSDTO(processInquiryDBModels.get(0).getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }

    public InquiryDataWSDTO removeProcessInquiryDataService(long userId, String processId, String dataId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryDatas() != null){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryDatas().size();i++){
                if (processInquiryDBModels.get(0).getInquiryDatas().get(i).getDataId().equalsIgnoreCase(dataId)){

                    processInquiryDBModels.get(0).getInquiryDatas().remove(processInquiryDBModels.get(0).getInquiryDatas().get(i));
                    processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processInquiryRepository.save(processInquiryDBModels.get(0));

                    return new InquiryDataWSDTO(processInquiryDBModels.get(0).getInquiryDatas().get(i));
                }
            }
        }
        return null;
    }



    public List<InquiryUrlWSDTO> getProcessInquiryUrlsService(long userId, String processId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryUrls() != null){
            List<InquiryUrlWSDTO>inquiryUrlWSDTOS = new ArrayList<>();
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryUrls().size();i++){
                inquiryUrlWSDTOS.add(new InquiryUrlWSDTO(processInquiryDBModels.get(0).getInquiryUrls().get(i)));
            }
            return inquiryUrlWSDTOS;
        }
        return null;
    }

    public InquiryUrlWSDTO getProcessInquiryUrlService(long userId,String processId,String urlId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryUrls() != null){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryUrls().size();i++){
                if (processInquiryDBModels.get(0).getInquiryUrls().get(i).getUrlId().equalsIgnoreCase(urlId)){
                    return new InquiryUrlWSDTO(processInquiryDBModels.get(0).getInquiryUrls().get(i));
                }
            }
        }
        return null;
    }

    public InquiryUrlWSDTO createProcessInquiryUrlService(long userId,String processId,String urlType,String url) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty()){

            InquiryUrlDAO inquiryUrlDAO = new InquiryUrlDAO();
            inquiryUrlDAO.setUrlId(appUtils.generateUUID());
            inquiryUrlDAO.setUrlType(urlType);
            inquiryUrlDAO.setUrl(url);
            inquiryUrlDAO.setcDate(appUtils.getCurrentTimeStamp());
            inquiryUrlDAO.setStatus(1);

            if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryUrls() != null){
                processInquiryDBModels.get(0).getInquiryUrls().add(inquiryUrlDAO);
            }else {
                List<InquiryUrlDAO>inquiryUrlDAOS = new ArrayList<>();
                inquiryUrlDAOS.add(inquiryUrlDAO);
                processInquiryDBModels.get(0).setInquiryUrls(inquiryUrlDAOS);
            }
            processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
            processInquiryRepository.save(processInquiryDBModels.get(0));

            return new InquiryUrlWSDTO(inquiryUrlDAO);
        }
        return null;
    }

    public InquiryUrlWSDTO updateProcessInquiryUrlService(long userId, String processId,String urlId,String urlType,String url) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryUrls() != null){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryUrls().size();i++){
                if (processInquiryDBModels.get(0).getInquiryUrls().get(i).getUrlId().equalsIgnoreCase(urlId)){

                    processInquiryDBModels.get(0).getInquiryUrls().get(i).setUrlType(urlType);
                    processInquiryDBModels.get(0).getInquiryUrls().get(i).setUrl(url);
                    processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processInquiryRepository.save(processInquiryDBModels.get(0));

                    return new InquiryUrlWSDTO(processInquiryDBModels.get(0).getInquiryUrls().get(i));
                }
            }
        }
        return null;
    }

    public InquiryUrlWSDTO removeProcessInquiryUrlService(long userId, String processId,String urlId) {

        List<ProcessInquiryDBModel> processInquiryDBModels = processInquiryRepository.findByProcessId(processId);
        if (!processInquiryDBModels.isEmpty() && processInquiryDBModels.get(0).getInquiryUrls() != null){
            for (int i=0;i<processInquiryDBModels.get(0).getInquiryUrls().size();i++){
                if (processInquiryDBModels.get(0).getInquiryUrls().get(i).getUrlId().equalsIgnoreCase(urlId)){

                    processInquiryDBModels.get(0).getInquiryUrls().remove(processInquiryDBModels.get(0).getInquiryUrls().get(i));
                    processInquiryDBModels.get(0).setuDate(appUtils.getCurrentTimeStamp());
                    processInquiryRepository.save(processInquiryDBModels.get(0));

                    return new InquiryUrlWSDTO(processInquiryDBModels.get(0).getInquiryUrls().get(i));
                }
            }
        }
        return null;
    }



}
