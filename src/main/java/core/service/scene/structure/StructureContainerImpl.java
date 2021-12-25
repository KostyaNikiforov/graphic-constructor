package core.service.scene.structure;

import core.lib.Service;
import core.model.Structure;
import java.util.LinkedList;
import java.util.List;

@Service
public class StructureContainerImpl implements StructureContainer {
    private final List<Structure> structures;

    public StructureContainerImpl() {
        structures = new LinkedList<>();
    }

    @Override
    public List<Structure> getAllStructures() {
        return structures;
    }

    @Override
    public void add(Structure structure) {
        structures.add(structure);
    }

    @Override
    public void clear() {
        structures.clear();
    }

    @Override
    public boolean isEmpty() {
        return structures.isEmpty();
    }

    @Override
    public int size() {
        return structures.size();
    }
}
