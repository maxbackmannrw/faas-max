package com.faas.core.base.middleware.process.details.inquiry;

import com.faas.core.base.framework.process.details.inquiry.ProcessInquiryFramework;
import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.InquiryDataWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.InquiryUrlWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.ProcessInquiryWSModel;
import com.faas.core.base.model.ws.process.details.inquiry.dto.InquiryDataWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.dto.InquiryUrlWSDTO;
import com.faas.core.base.model.ws.process.details.inquiry.dto.ProcessInquiryWSDTO;
import com.faas.core.utils.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProcessInquiryMiddleware {


    @Autowired
    ProcessInquiryFramework processInquiryFramework;


    public ProcessInquiryWSModel getProcessInquiry(long userId, String processId) {

        ProcessInquiryWSModel response = new ProcessInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessInquiryWSDTO processInquiryWSDTO = processInquiryFramework.getProcessInquiryService(userId,processId);
        if (processInquiryWSDTO != null){
            response.setProcessInquiry(processInquiryWSDTO);
        }

        general.setOperation("getProcessInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public ProcessInquiryWSModel createProcessInquiry(long userId, String processId,String processInquiry,String inquiryType) {

        ProcessInquiryWSModel response = new ProcessInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessInquiryWSDTO processInquiryWSDTO = processInquiryFramework.createProcessInquiryService(userId,processId,processInquiry,inquiryType);
        if (processInquiryWSDTO != null){
            response.setProcessInquiry(processInquiryWSDTO);
        }

        general.setOperation("createProcessInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public ProcessInquiryWSModel removeProcessInquiry(long userId, String processId) {

        ProcessInquiryWSModel response = new ProcessInquiryWSModel();
        GeneralWSModel general = new GeneralWSModel();

        ProcessInquiryWSDTO processInquiryWSDTO = processInquiryFramework.removeProcessInquiryService(userId,processId);
        if (processInquiryWSDTO != null){
            response.setProcessInquiry(processInquiryWSDTO);
        }

        general.setOperation("removeProcessInquiry");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public InquiryDataWSModel getProcessInquiryDatas(long userId, String processId) {

        InquiryDataWSModel response = new InquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryDataWSDTO> inquiryDataWSDTOS = processInquiryFramework.getProcessInquiryDatasService(userId,processId);
        if (inquiryDataWSDTOS != null){
            response.setInquiryDatas(inquiryDataWSDTOS);
        }

        general.setOperation("getProcessInquiryDatas");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryDataWSModel getProcessInquiryData(long userId, String processId,String dataId) {

        InquiryDataWSModel response = new InquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryDataWSDTO>inquiryDataWSDTOS = new ArrayList<>();

        InquiryDataWSDTO inquiryDataWSDTO = processInquiryFramework.getProcessInquiryDataService(userId,processId,dataId);
        if (inquiryDataWSDTO != null){
            inquiryDataWSDTOS.add(inquiryDataWSDTO);
        }

        response.setInquiryDatas(inquiryDataWSDTOS);
        general.setOperation("getProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryDataWSModel createProcessInquiryData(long userId, String processId,long dateTypeId,String value) {

        InquiryDataWSModel response = new InquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryDataWSDTO>inquiryDataWSDTOS = new ArrayList<>();

        InquiryDataWSDTO inquiryDataWSDTO = processInquiryFramework.createProcessInquiryDataService(userId,processId,dateTypeId,value);
        if (inquiryDataWSDTO != null){
            inquiryDataWSDTOS.add(inquiryDataWSDTO);
        }

        response.setInquiryDatas(inquiryDataWSDTOS);
        general.setOperation("createProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryDataWSModel updateProcessInquiryData(long userId,String processId,String dataId,long dateTypeId,String value) {

        InquiryDataWSModel response = new InquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryDataWSDTO>inquiryDataWSDTOS = new ArrayList<>();

        InquiryDataWSDTO InquiryDataWSDTO = processInquiryFramework.updateProcessInquiryDataService(userId,processId,dataId,dateTypeId,value);
        if (InquiryDataWSDTO != null){
            inquiryDataWSDTOS.add(InquiryDataWSDTO);
        }

        response.setInquiryDatas(inquiryDataWSDTOS);
        general.setOperation("updateProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryDataWSModel removeProcessInquiryData(long userId, String processId, String dataId) {

        InquiryDataWSModel response = new InquiryDataWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryDataWSDTO>inquiryDataWSDTOS = new ArrayList<>();

        InquiryDataWSDTO InquiryDataWSDTO = processInquiryFramework.removeProcessInquiryDataService(userId,processId,dataId);
        if (InquiryDataWSDTO != null){
            inquiryDataWSDTOS.add(InquiryDataWSDTO);
        }

        response.setInquiryDatas(inquiryDataWSDTOS);
        general.setOperation("removeProcessInquiryData");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



    public InquiryUrlWSModel getProcessInquiryUrls(long userId, String processId) {

        InquiryUrlWSModel response = new InquiryUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();

        List<InquiryUrlWSDTO> inquiryUrlWSDTOS = processInquiryFramework.getProcessInquiryUrlsService(userId,processId);
        if (inquiryUrlWSDTOS != null){
            response.setInquiryUrls(inquiryUrlWSDTOS);
        }

        response.setInquiryUrls(inquiryUrlWSDTOS);
        general.setOperation("getProcessInquiryUrls");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryUrlWSModel getProcessInquiryUrl(long userId,String processId,String urlId) {

        InquiryUrlWSModel response = new InquiryUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryUrlWSDTO>inquiryUrlWSDTOS = new ArrayList<>();

        InquiryUrlWSDTO inquiryUrlWSDTO = processInquiryFramework.getProcessInquiryUrlService(userId,processId,urlId);
        if (inquiryUrlWSDTO != null){
            inquiryUrlWSDTOS.add(inquiryUrlWSDTO);
        }

        response.setInquiryUrls(inquiryUrlWSDTOS);
        general.setOperation("getProcessInquiryUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryUrlWSModel createProcessInquiryUrl(long userId,String processId,String urlType,String url) {

        InquiryUrlWSModel response = new InquiryUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryUrlWSDTO>inquiryUrlWSDTOS = new ArrayList<>();

        InquiryUrlWSDTO inquiryUrlWSDTO = processInquiryFramework.createProcessInquiryUrlService(userId,processId,urlType,url);
        if (inquiryUrlWSDTO != null){
            inquiryUrlWSDTOS.add(inquiryUrlWSDTO);
        }

        response.setInquiryUrls(inquiryUrlWSDTOS);
        general.setOperation("createProcessInquiryUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }

    public InquiryUrlWSModel updateProcessInquiryUrl(long userId, String processId,String urlId,String urlType,String url) {

        InquiryUrlWSModel response = new InquiryUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryUrlWSDTO>inquiryUrlWSDTOS = new ArrayList<>();

        InquiryUrlWSDTO inquiryUrlWSDTO = processInquiryFramework.updateProcessInquiryUrlService(userId,processId,urlId,urlType,url);
        if (inquiryUrlWSDTO != null){
            inquiryUrlWSDTOS.add(inquiryUrlWSDTO);
        }

        response.setInquiryUrls(inquiryUrlWSDTOS);
        general.setOperation("updateProcessInquiryUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }


    public InquiryUrlWSModel removeProcessInquiryUrl(long userId, String processId,String urlId) {

        InquiryUrlWSModel response = new InquiryUrlWSModel();
        GeneralWSModel general = new GeneralWSModel();
        List<InquiryUrlWSDTO> inquiryUrlWSDTOS = new ArrayList<>();

        InquiryUrlWSDTO inquiryUrlWSDTO = processInquiryFramework.removeProcessInquiryUrlService(userId,processId,urlId);
        if (inquiryUrlWSDTO != null){
            inquiryUrlWSDTOS.add(inquiryUrlWSDTO);
        }

        response.setInquiryUrls(inquiryUrlWSDTOS);
        general.setOperation("removeProcessInquiryUrl");
        general.setStatus(AppConstant.GENERAL_SUCCESS_STATUS);
        general.setStatusCode(AppConstant.GENERAL_SUCCESS_CODE);
        general.setResult(AppConstant.GENERAL_SUCCESS_STATUS);
        response.setGeneral(general);

        return response;
    }



}
