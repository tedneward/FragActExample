package edu.uw.ischool.activityandfragmentexample;

/**
 * Created by tedneward on 2/8/17.
 */

public class Dwarf {
    private String name;

    public String getName()
    {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    public String toString() {
        return "[Dwarf: name=" + name + "]";
    }
}
