package org.jakubczyk.codepot;

public class User {

    public String name;
    public String fromPackage;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", fromPackage='" + fromPackage + '\'' +
                '}';
    }
}
