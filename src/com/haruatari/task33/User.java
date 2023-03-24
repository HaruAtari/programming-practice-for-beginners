package com.haruatari.task33;

public class User implements Comparable<User> {
    public final String name;

    public User(String name) {
        this.name = name;
    }

    public void receiveMessage(String message) {
        System.out.println(this + " received message: " + message);
    }

    @Override
    public String toString() {
        return "User(name: " + name + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        var other = (User) obj;

        return this.name.equals(other.name);
    }

    @Override
    public int compareTo(User other) {
        return name.compareTo(other.name);
    }
}
