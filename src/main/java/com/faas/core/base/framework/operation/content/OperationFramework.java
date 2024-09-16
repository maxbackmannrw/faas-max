package com.faas.core.base.framework.operation.content;

import com.faas.core.data.db.operation.content.OperationDBModel;
import com.faas.core.data.ws.base.operation.content.dto.OperationListWSDTO;
import com.faas.core.data.ws.base.operation.content.dto.OperationWSDTO;
import com.faas.core.data.repo.operation.content.OperationRepository;
import com.faas.core.misc.config.AppUtils;
import com.faas.core.misc.helpers.operation.OperationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OperationFramework {


    @Autowired
    OperationHelpers operationHelpers;

    @Autowired
    OperationRepository operationRepository;

    @Autowired
    AppUtils appUtils;


    public OperationListWSDTO getOperationsService(long userId, String operationState, int reqPage, int reqSize) {

        Page<OperationDBModel> operationModelPage = operationRepository.findAllByOperationState(operationState, PageRequest.of(reqPage, reqSize));
        if (operationModelPage != null) {
            return operationHelpers.getOperationListWSDTO(operationModelPage);
        }
        return null;
    }

    public OperationListWSDTO getOperationsByCategoryService(long userId, String operationCategory, String operationState, int reqPage, int reqSize) {

        Page<OperationDBModel> operationModelPage = operationRepository.findAllByOperationCategoryAndOperationState(operationCategory, operationState, PageRequest.of(reqPage, reqSize));
        if (operationModelPage != null) {
            return operationHelpers.getOperationListWSDTO(operationModelPage);
        }
        return null;
    }

    public OperationWSDTO getOperationService(long userId, String operationId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        if (operationDBModel.isPresent()) {
            return operationHelpers.getOperationWSDTO(operationDBModel.get());
        }
        return null;
    }


    public OperationWSDTO createOperationService(long userId) {

        return null;
    }


    public OperationWSDTO updateOperationService(long userId, String operationId) {

        return null;
    }

    public OperationWSDTO removeOperationService(long userId, String operationId) {

        Optional<OperationDBModel> operationDBModel = operationRepository.findById(operationId);
        if (operationDBModel.isPresent()) {
            operationHelpers.removeOperationHelper(operationDBModel.get());
            return operationHelpers.getOperationWSDTO(operationDBModel.get());
        }
        return null;
    }


    public OperationListWSDTO getOperationDetailsService(long userId, String sessionType, String sessionState, int reqPage, int reqSize) {

        return null;
    }

}
