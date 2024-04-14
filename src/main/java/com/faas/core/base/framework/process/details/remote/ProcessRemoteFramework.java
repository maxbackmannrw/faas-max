package com.faas.core.base.framework.process.details.remote;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.details.remote.ProcessRemoteDBModel;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
import com.faas.core.base.repo.process.details.remote.ProcessRemoteRepository;
import com.faas.core.base.repo.remote.content.RemoteRepository;
import com.faas.core.base.repo.utility.DataTypeRepository;
import com.faas.core.utils.config.AppUtils;
import com.faas.core.utils.helpers.ProcessHelper;
import com.faas.core.utils.helpers.RemoteHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
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
    AppUtils appUtils;


    public List<ProcessRemoteWSDTO> getProcessRemotesService(long userId, String processId) {

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByProcessId(processId);
        for (ProcessRemoteDBModel processRemoteDBModel : processRemoteDBModels) {
            processRemoteWSDTOS.add(new ProcessRemoteWSDTO(processRemoteDBModel));
        }
        return processRemoteWSDTOS;
    }

    public List<ProcessRemoteWSDTO> getProcessRemotesByCategoryService(long userId, String processId,String remoteCategory) {

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByProcessIdAndRemoteCategory(processId,remoteCategory);
        for (ProcessRemoteDBModel processRemoteDBModel : processRemoteDBModels) {
            processRemoteWSDTOS.add(new ProcessRemoteWSDTO(processRemoteDBModel));
        }
        return processRemoteWSDTOS;
    }

    public ProcessRemoteWSDTO getProcessRemoteService(long userId,String processId,String processRemoteId) {

        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByIdAndProcessId(processRemoteId,processId);
        if (!processRemoteDBModels.isEmpty()) {
            return new ProcessRemoteWSDTO(processRemoteDBModels.get(0));
        }
        return null;
    }

    public ProcessRemoteWSDTO createProcessRemoteService(long userId,String processId,String remoteId,String remoteCategory) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (processDBModel.isPresent() && remoteDBModel.isPresent()) {
            return new ProcessRemoteWSDTO(remoteHelper.createProcessRemoteDBModel(processDBModel.get(),remoteDBModel.get(),remoteCategory));
        }
        return null;
    }

    public ProcessRemoteWSDTO removeProcessRemoteService(long userId,String processId,String processRemoteId) {

        List<ProcessRemoteDBModel> processRemoteDBModels = processRemoteRepository.findByIdAndProcessId(processRemoteId,processId);
        if (!processRemoteDBModels.isEmpty()) {
            processRemoteRepository.delete(processRemoteDBModels.get(0));
            return new ProcessRemoteWSDTO(processRemoteDBModels.get(0));
        }
        return null;
    }


}
