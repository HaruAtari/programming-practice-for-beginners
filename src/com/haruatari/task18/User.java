package com.haruatari.task18;

final class User {
    public final int age;
    public final String name;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User(name: " + name + "; age: " + age + ")";
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
