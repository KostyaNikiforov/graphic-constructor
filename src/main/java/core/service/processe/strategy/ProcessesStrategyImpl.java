package core.service.processe.strategy;

import core.lib.Service;
import core.service.processe.DefaultProcess;
import core.service.processe.ImageExtracting;
import core.service.processe.PictureCreating;
import core.service.processe.ProcessHandler;
import core.service.processe.StructureCreating;
import core.session.enums.CreatingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProcessesStrategyImpl implements ProcessesStrategy {
    private static final ProcessHandler DEFAULT_PROCESS_HANDLER = new DefaultProcess();
    private final Map<CreatingMode, ProcessHandler> map;

    {
        StructureCreating structureCreating = new StructureCreating();
        map = new HashMap<>();
        map.put(CreatingMode.CIRCLE, structureCreating);
        map.put(CreatingMode.RECT, structureCreating);
        map.put(CreatingMode.LINE, structureCreating);
        map.put(CreatingMode.TEXT, structureCreating);
        map.put(CreatingMode.LAYER, structureCreating);
        map.put(CreatingMode.PICTURE, new PictureCreating());
        map.put(CreatingMode.IMAGE_EXTRACT, new ImageExtracting());

    }

    @Override
    public ProcessHandler getProcessHandler(CreatingMode creatingMode) {
        return map.getOrDefault(creatingMode, DEFAULT_PROCESS_HANDLER);
    }
}
