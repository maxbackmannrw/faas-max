package com.faas.core.base.model.db.operation.content.dao;

import java.util.List;


public class OperationScenarioDAO {

    private String id;
    private String scenarioId;
    private String scenario;
    private String scenarioType;
    private List<OperationScenarioExecutionDAO> scenarioExecutions;
    private String scenarioState;
    private long uDate;
    private long cDate;
    private int status;

    public OperationScenarioDAO() {
    }


}
