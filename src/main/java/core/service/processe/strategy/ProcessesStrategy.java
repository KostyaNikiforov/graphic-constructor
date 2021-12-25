package core.service.processe.strategy;

import core.service.processe.ProcessHandler;
import core.session.enums.CreatingMode;

public interface ProcessesStrategy {
    ProcessHandler getProcessHandler(CreatingMode creatingMode);
}
