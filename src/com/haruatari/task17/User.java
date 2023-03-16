package com.haruatari.task17;

public final class User {
    public final int age;
    public final boolean isConfirmed;
    public final String name;

    public User(String name, int age, boolean isConfirmed) {
        this.name = name;
        this.age = age;
        this.isConfirmed = isConfirmed;
    }

    @Override
    public String toString() {
        return "User(name: " + name + "; age: " + age + "; isConfirmed: " + isConfirmed + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        var other = (User) obj;

        return this.name.equals(other.name);
    }
}
