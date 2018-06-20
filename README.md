[![Build Status](https://travis-ci.org/CAU-DOSC/DevSet9.svg?branch=master)](https://travis-ci.org/CAU-DOSC/DevSet9)
![npm](https://img.shields.io/badge/lang-java-orange.svg)

# DevSet9
- Team Project #2 in 2018 Open Source Software Project Course, Chung-Ang Univ.

## Objective
- Implementation of integer set data structure in several ways.
    - by using Array structure.
    - by using Bins structure.
    - by using BitVector structure.
    - by using Binary Search Tree sturcture.
    - by using Linked-list structure.
- Measure time complexity & space complexity of implemented sets.

## Team Members

Role   | Name   | Assigned Part | Github ID                                   |
-------|--------|---------------|---------------------------------------------| 
Leader | 신형철 | Simple List, Analysis & Writing Report | [nErumin](https://github.com/nErumin)       |
Member | 김정민 | Array, Bins                    | [minn951120](https://github.com/minn951120) |
Member | 임기찬 | Bit Vector, Binary Search Tree | [dispe1](https://github.com/dispe1)         |

## How to work
- Fork this repository first.
- Clone the copied repository to local.
- Work on the local.
- Push the work to the copied repository.
- Make a pull request to upstream.
    - Must be confirmed that there is no failing tests.

## How to implement
- Create a new implemented set.
- Extend the 'IntSet' class.
    - It provides all needed interfaces and utilities.
- Implement abstract methods in the new implemented set.
- Create a new test class for the new implemented set.
- Write test cases for new implemented set.
    - Make sure that the new implemented set passes all test cases.
- Create a new simulator for the new implemented set.
- Extend the 'IntSetSimulator' class.
    - It provides all utilities for measuring complexity.
- Implement abstract methods in the new simulator.

## Working Environment
- Java 9
- Gradle 4.7
- JUnit
    - Testing Framework
- Travis CI
    - Continuous, Automatic build & test tool
    - Any pull requests cannot be accepted while the Travis checking isn't passed. 

## Build process
- To build the project, move to a root project folder in terminal.
- Enter the below command.
    - Please make sure that the above working environment is ready.
```bash
    gradle jar
```
- If you just need to test all test cases, enter the below command.
```bash
    gradle test
```

## Execute Project
- After the project is built, it can be executed by using the below command in terminal.
    -  ```java -jar {PROJECT_FOLDER}/build/libs/DevSet9.jar```