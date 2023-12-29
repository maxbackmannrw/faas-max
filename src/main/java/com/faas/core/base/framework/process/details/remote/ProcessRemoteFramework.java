package com.faas.core.base.framework.process.details.remote;

import com.faas.core.base.model.db.process.content.ProcessDBModel;
import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;
import com.faas.core.base.model.db.remote.content.RemoteDBModel;
import com.faas.core.base.model.ws.process.details.remote.dto.ProcessRemoteWSDTO;
import com.faas.core.base.repo.process.content.ProcessRepository;
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
    DataTypeRepository dataTypeRepository;

    @Autowired
    RemoteRepository remoteRepository;

    @Autowired
    AppUtils appUtils;


    public List<ProcessRemoteWSDTO> getProcessRemotesService(long userId, String processId) {

        List<ProcessRemoteWSDTO> processRemoteWSDTOS = new ArrayList<>();
        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessRemotes().size();i++){
                processRemoteWSDTOS.add(new ProcessRemoteWSDTO(processDBModel.get().getProcessRemotes().get(i)));
            }
        }
        return processRemoteWSDTOS;
    }

    public ProcessRemoteWSDTO getProcessRemoteService(long userId,String processId,String remoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessRemotes().size();i++){
                if (processDBModel.get().getProcessRemotes().get(i).getRemoteId().equalsIgnoreCase(remoteId)){
                    return new ProcessRemoteWSDTO(processDBModel.get().getProcessRemotes().get(i));
                }
            }
        }
        return null;
    }

    public ProcessRemoteWSDTO createProcessRemoteService(long userId,String processId,String remoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        Optional<RemoteDBModel> remoteDBModel = remoteRepository.findById(remoteId);
        if (processDBModel.isPresent() && remoteDBModel.isPresent()) {

            ProcessRemoteDAO processRemoteDAO = remoteHelper.createProcessRemoteDAO(remoteDBModel.get());
            processDBModel.get().getProcessRemotes().add(processRemoteDAO);
            processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
            processRepository.save(processDBModel.get());

            return new ProcessRemoteWSDTO(processRemoteDAO);
        }
        return null;
    }

    public ProcessRemoteWSDTO removeProcessRemoteService(long userId,String processId,String remoteId) {

        Optional<ProcessDBModel> processDBModel = processRepository.findById(processId);
        if (processDBModel.isPresent() && processDBModel.get().getProcessRemotes() != null) {
            for (int i=0;i<processDBModel.get().getProcessRemotes().size();i++){
                if (processDBModel.get().getProcessRemotes().get(i).getRemoteId().equalsIgnoreCase(remoteId)){

                    ProcessRemoteDAO processRemoteDAO = processDBModel.get().getProcessRemotes().get(i);
                    processDBModel.get().getProcessRemotes().remove(processRemoteDAO);
                    processDBModel.get().setuDate(appUtils.getCurrentTimeStamp());
                    processRepository.save(processDBModel.get());

                    return new ProcessRemoteWSDTO(processRemoteDAO);
                }
            }
        }
        return null;
    }


}
