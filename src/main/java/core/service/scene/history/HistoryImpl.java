package core.service.scene.history;

import core.Config;
import core.service.scene.structure.StructureContainer;

public class HistoryImpl implements History<StructureContainer> {
    private Version currentVersion;
    private Version firstVersion;
    private int size;

    @Override
    public void add(StructureContainer data) {
        if (size >= Config.MAX_HISTORY_SIZE) {
            firstVersion = firstVersion.next;
            if (firstVersion != null) {
                firstVersion.last = null;
            }
        } else {
            size++;
        }
        if (currentVersion != null) {
            currentVersion.next = Version.create(data,
                    currentVersion, null);
        } else {
            firstVersion = currentVersion = Version.create(data, null, null);
        }
    }

    @Override
    public StructureContainer next() {
        if (currentVersion == null) {
            return null;
        }
        if (currentVersion.next != null) {
            currentVersion = currentVersion.next;
        }
        return currentVersion.data;
    }

    @Override
    public StructureContainer last() {
        if (currentVersion == null) {
            return null;
        }
        if (currentVersion.last != null) {
            currentVersion = currentVersion.last;
        }
        return currentVersion.data;
    }

    @Override
    public StructureContainer current() {
        return currentVersion != null ? currentVersion.data : null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean clear() {
        if (size == 0) {
            return false;
        }
        Version version = firstVersion;
        while (version.next != null) {
            version = version.next;
            version.last = null;
        }
        currentVersion = null;
        size = 0;
        return true;
    }

    private static class Version {
        private StructureContainer data;
        private Version last;
        private Version next;

        private Version(StructureContainer data, Version last, Version next) {
            this.data = data;
            this.last = last;
            this.next = next;
        }

        public static Version create(StructureContainer data, Version last, Version next) {
            return new Version(data.clone(), last, next);
        }
    }
}
