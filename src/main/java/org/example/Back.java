package org.example;

public class Back {
    private int capacity;

    public Back(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "рюкзак емкостью " + capacity + " литров ";
    }
}
