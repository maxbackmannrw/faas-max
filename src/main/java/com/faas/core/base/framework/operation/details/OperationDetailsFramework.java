package com.faas.core.base.framework.operation.details;

import com.faas.core.base.model.db.operation.content.OperationDBModel;
import com.faas.core.base.model.ws.operation.content.dto.OperationWSDTO;
import com.faas.core.base.repo.operation.content.OperationRepository;
import com.faas.core.utils.config.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OperationDetailsFramework {

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public OperationWSDTO fillOperationWSDTO(OperationDBModel operationDBModel) {

        OperationWSDTO operationWSDTO = new OperationWSDTO();
        operationWSDTO.setOperation(operationDBModel);
        return operationWSDTO;
    }


}
