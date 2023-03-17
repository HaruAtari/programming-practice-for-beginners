package com.haruatari.task20;

import java.util.Objects;

public final class Friend {

    public final String name;
    public final boolean isBusy;

    public Friend(String name, boolean isBusy) {
        this.name = name;
        this.isBusy = isBusy;
    }

    @Override
    public String toString() {
        return "Friend(name: " + name + "; isBusy" + isBusy + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Friend && this.name.equals(((Friend) obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
