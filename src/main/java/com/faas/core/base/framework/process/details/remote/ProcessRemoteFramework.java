package com.faas.core.base.framework.process.details.remote;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.remote.ProcessRemoteDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.remote.ProcessRemoteRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utils.config.UrlRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.process.ProcessHelper;
import com.faas.core.utils.helpers.remote.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessRemoteFramework {

    @Autowired
    ProcessHelper processHelper;

    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    ProcessRepository processRepository;

    @Autowired
    ProcessRemoteRepository processRemoteRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessRemoteWSDTO> getProcessRemotesService(long userId, String processId) {

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByProcessId(processId);
        for (ProcessRemoteDBModel processRemoteDBModel : processRemoteDBModels) {
            processRemoteWSDTOS.add(processHelper.mapProcessRemoteWSDTO(processRemoteDBModel));
        }
        return processRemoteWSDTOS;
    }

    public List<ProcessRemoteWSDTO> getProcessRemotesByCategoryService(long userId, String processId,String remoteCategory) {

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByProcessIdAndRemoteCategory(processId,remoteCategory);
        for (ProcessRemoteDBModel processRemoteDBModel : processRemoteDBModels) {
            processRemoteWSDTOS.add(processHelper.mapProcessRemoteWSDTO(processRemoteDBModel));
        }
        return processRemoteWSDTOS;
    }

    public ProcessRemoteWSDTO getProcessRemoteService(long userId,String processId,String processRemoteId) {

        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByIdAndProcessId(processRemoteId,processId);
        if (!processRemoteDBModels.isEmpty()) {
            return processHelper.mapProcessRemoteWSDTO(processRemoteDBModels.get(0));
        }
        return null;
    }

    public ProcessRemoteWSDTO createProcessRemoteService(long userId,String processId,String remoteId,String remoteCategory) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (processDBModel.isPresent() && remoteDBModel.isPresent()) {
            return processHelper.mapProcessRemoteWSDTO(remoteHelper.createProcessRemoteDBModel(processDBModel.get(),remoteDBModel.get(),remoteCategory));
        }
        return null;
    }

    public ProcessRemoteWSDTO removeProcessRemoteService(long userId,String processId,String processRemoteId) {

        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByIdAndProcessId(processRemoteId,processId);
        if (!processRemoteDBModels.isEmpty()) {
            processRemoteRepository.delete(processRemoteDBModels.get(0));
            return processHelper.mapProcessRemoteWSDTO(processRemoteDBModels.get(0));
        }
        return null;
    }



}
