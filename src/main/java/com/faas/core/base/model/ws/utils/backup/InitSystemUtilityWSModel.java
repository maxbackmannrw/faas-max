package com.faas.core.base.model.ws.utils.backup;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.backup.dto.InitSystemUtilityWSDTO;

public class InitSystemUtilityWSModel {

    private GeneralWSModel general;
    private InitSystemUtilityWSDTO initSystemUtility;

    public InitSystemUtilityWSModel() {
    }

    public InitSystemUtilityWSModel(GeneralWSModel general, InitSystemUtilityWSDTO initSystemUtility) {
        this.general = general;
        this.initSystemUtility = initSystemUtility;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public InitSystemUtilityWSDTO getInitSystemUtility() {
        return initSystemUtility;
    }

    public void setInitSystemUtility(InitSystemUtilityWSDTO initSystemUtility) {
        this.initSystemUtility = initSystemUtility;
    }
}
