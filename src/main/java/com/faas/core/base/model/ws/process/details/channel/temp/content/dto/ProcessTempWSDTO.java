package com.faas.core.base.model.ws.process.details.channel.temp.content.dto;

import com.faas.core.base.model.ws.process.details.channel.temp.details.dto.ProcessEmailTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.details.dto.ProcessPushTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.details.dto.ProcessSmsTempWSDTO;
import com.faas.core.base.model.ws.process.details.channel.temp.details.dto.ProcessWappMessageTempWSDTO;

import java.util.List;

public class ProcessTempWSDTO {

    private List<ProcessEmailTempWSDTO> processEmailTemps;
    private List<ProcessPushTempWSDTO>processPushTemps;
    private List<ProcessSmsTempWSDTO>processSmsTemps;
    private List<ProcessWappMessageTempWSDTO>processWappMessageTemps;

    public ProcessTempWSDTO() {
    }

    public ProcessTempWSDTO(List<ProcessEmailTempWSDTO> processEmailTemps, List<ProcessPushTempWSDTO> processPushTemps, List<ProcessSmsTempWSDTO> processSmsTemps, List<ProcessWappMessageTempWSDTO> processWappMessageTemps) {
        this.processEmailTemps = processEmailTemps;
        this.processPushTemps = processPushTemps;
        this.processSmsTemps = processSmsTemps;
        this.processWappMessageTemps = processWappMessageTemps;
    }

    public List<ProcessEmailTempWSDTO> getProcessEmailTemps() {
        return processEmailTemps;
    }

    public void setProcessEmailTemps(List<ProcessEmailTempWSDTO> processEmailTemps) {
        this.processEmailTemps = processEmailTemps;
    }

    public List<ProcessPushTempWSDTO> getProcessPushTemps() {
        return processPushTemps;
    }

    public void setProcessPushTemps(List<ProcessPushTempWSDTO> processPushTemps) {
        this.processPushTemps = processPushTemps;
    }

    public List<ProcessSmsTempWSDTO> getProcessSmsTemps() {
        return processSmsTemps;
    }

    public void setProcessSmsTemps(List<ProcessSmsTempWSDTO> processSmsTemps) {
        this.processSmsTemps = processSmsTemps;
    }

    public List<ProcessWappMessageTempWSDTO> getProcessWappMessageTemps() {
        return processWappMessageTemps;
    }

    public void setProcessWappMessageTemps(List<ProcessWappMessageTempWSDTO> processWappMessageTemps) {
        this.processWappMessageTemps = processWappMessageTemps;
    }
}
