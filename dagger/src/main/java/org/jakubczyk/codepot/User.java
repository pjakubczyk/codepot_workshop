package org.jakubczyk.codepot;

public class User {

    public String name;
    public String fromPackage;

    @Override
    public String toString() {
        return "name=" + name + " " + "fromPackage=" + fromPackage;
    }
}
