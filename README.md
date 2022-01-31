# Assignment 1

## Objective

The goal of this assignment is primarily to ensure that you have a working dev environment set up.

## Instructions

1) Download the ZIP file containing the assignment project, or clone it from Github
2) Try to build -- the tests will fail.

   On Mac/Linux:
   ```shell
   ./gradlew build
   ```
   On Windows:
   ```shell
    .\gradlew.bat build
   ```
3) In `src/main/java/HelloWorld.java`, follow the instructions marked `TODO`.
4) Build again, the tests should pass.
5) In `build.gradle.kts`, change the `YOUR_NAME` variable to be your name, with `_` instead of spaces
6) Run the `prepareAssignment` task to build a ZIP file to submit.

## What's all this stuff in `build.gradle.kts`?

Starting from the top:
- Plugins add or enable specific functionality in gradle. Here, we're using the `application` plugin, which basically says "this is a Java project and we're going to want to run a particular class"
- Set your name 🙂
- `group` would be used if we were publishing our jar, but we aren't, so we can just leave this.
- `version` gets used in the name of our jar
- `repositories` means "look for our dependencies in [mavenCentral](https://search.maven.org/)"
- The `dependencies` block (unsurprisingly) defines our dependencies. We have dependencies that belong to two different configurations:
  - `testImplementation` are the dependencies we need to *implement* (i.e. build) our tests.
    - `assertj-core` is the library I'm using to make assertions in the tests. JUnit comes with its own assertions library, but AssertJ offers a few more features.
    - `junit-jupiter-api` is the JUnit5 library
  - `testRuntimeOnly` are the dependencies that we need to *run* our tests, btu that we don't actually need at build time. This is just the JUnit5 "engine".
- The `application` block is declaring that the class that should be run from our jar is the `HelloWorld` class.
- The next section configures the `test` task. First, we tell gradle we should be using JUnit to run our tests. Second, we configure the test logging so that it gives detailed errors.
- The next section creates a new gradle task `packageAssignment` 