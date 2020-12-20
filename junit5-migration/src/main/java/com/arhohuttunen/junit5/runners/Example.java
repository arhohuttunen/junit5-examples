package com.arhohuttunen.junit5.runners;

public class Example {

    private final Dependency dependency;

    public Example(Dependency dependency) {
        this.dependency = dependency;
    }

    public void doSomething() {
        dependency.doSomethingElse();
    }
}
