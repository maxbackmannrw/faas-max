package com.faas.core.base.framework.process.details.asset;

import com.faas.core.base.model.db.process.content.dao.ProcessAssetDAO;
import com.faas.core.base.model.ws.process.details.assets.dto.ProcessAssetWSDTO;
import com.faas.core.utility.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProcessAssetFramework {


    @Autowired
    AppUtils appUtils;


    public ProcessAssetWSDTO fillProcessAssetWSDTO(ProcessAssetDAO processAssetDBModel) {

        ProcessAssetWSDTO processAssetWSDTO = new ProcessAssetWSDTO();
        processAssetWSDTO.setProcessAsset(processAssetDBModel);
        return processAssetWSDTO;
    }




}
