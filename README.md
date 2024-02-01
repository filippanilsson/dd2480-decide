# Launch Interceptor Program: DECIDE

This program aims to generate a boolean signal which determines whether an interceptor should be launched based upon input radar tracking information. 

## Overview

This repository is home to DECIDE, a software application designed for the hypothetical anti-ballistic missile system. The project is organized into two main top folders:

- **src**: Contains the source code of the application.
  - **LIC**: Implements the logic for evaluating Launch Interceptor Conditions.
  - **tests**: Houses unit tests corresponding to different components of the application.
  - **PUM**: Implements the Preliminary Unlocking Matrix.
  - **FUV**: Implements the Final Unlocking Vector (FUV).
  - **parameters**: Centralizes all parameters required for the application in a single object.

- **lib**: Stores external libraries and dependencies.

## What it Does

DECIDE serves as a comprehensive tool for assessing Launch Interceptor Conditions. The primary components and functionalities include:

- **Launch Interceptor Conditions (LIC):**
  - The `LIC` folder contains the core implementation for evaluating Launch Interceptor Conditions. This is the heart of the application, responsible for determining when conditions are met for launching an interceptor.

- **Preliminary Unlocking Matrix (PUM):**
  - The `PUM` module, also in the `src` folder, provides the implementation for the Preliminary Unlocking Matrix. This matrix is an essential component in the overall unlocking mechanism.

- **Final Unlocking Vector (FUV):**
  - The `FUV` module, located in the `src` folder, implements the Final Unlocking Vector. It plays a crucial role in the unlocking process, ensuring the final vector is computed accurately.

- **Parameters Management:**
  - The `parameters` folder consolidates all parameters required by different parts of the application into a single, organized object. This ensures a centralized and easily manageable configuration for the entire system.

This project is designed with modularity and maintainability in mind, allowing users to understand, test, and extend the functionality efficiently.

## Specifications

The application relies on a set of parameters that are managed in the `parameters` folder. These parameters include:

- LENGTH1: Length in LICs 0, 7 ,12
- RADIUS1: Radius in LICs 1, 8 ,13
- EPSILON: Deviation from PI in LICs 2, 9
- AREA1: Area in LICs 3, 10, 14
- Q_PTS: No. of consecutive points in LIC 4
- QUADS: No. of quadrants points in LIC 4
- DIST: Distance in LIC 6
- N_PTS: No. of consecutive points in LIC 6
- K_PTS: No. of consecutive points in LICs 7, 12
- A_PTS: No. of consecutive points in LICs 8, 13
- B_PTS: No. of consecutive points in LICs 8, 13
- C_PTS: No. of consecutive points in LIC 9
- D_PTS: No. of consecutive points in LIC 9
- E_PTS: No. of consecutive points in LICs 10, 14
- F_PTS: No. of consecutive points in LICs 10, 14
- G_PTS: No. of consecutive points in LIC 11
- LENGTH2: Maximum length in LIC 12
- RADIUS2: Maximum radius in LIC 13
- AREA2: Maximum area in LIC 14

## Requirements

+ JDK: 21

## Way of Working
By evaluating the [checklist](https://www.omg.org/spec/Essence/1.2/PDF) (available on p.60), we can come to the conclusion that our team is in stage 2, **In Use**. A more detailed assessment of each point of the checklist for the aforementioned stage can be found below.

1. **The practices and tools are being used to do real work.**

We have decided to utilize GitHub for version control, something that we were all familiar with prior to this course.

We used JUnit 5 to create unit tests for all our Java classes.

Discord has been used as our main communication tool, for both messages and calls.

As for the practices of our work, we have delegated the tasks of the project equally. When new issues were created, we ensured that everyone had a chance to claim them in order to keep the workload even for the whole group.

2. **The use of the practices and tools selected are regularly inspected.**

We continuously inspected each others' work by ensuring that every pull request was reviewed by at least one other person before merging the branch.

3. **The practices and tools are being adapted to the team’s context.**

Around halfway through the development process, we decided to change our merging process by utilizing `merge and squash` instead of regular merging, in order to achieve a clean commit history and the P+ requirement.

4. **The use of the practices and tools is supported by the team.**

All practices and tools have been agreed upon by the entire team before being introduced to the workflow.

5. **Procedures are in place to handle feedback on the team’s way of working.**

We hold regular meetings to discuss our project and any feedback we want to bring forth. 

6. **The practices and tools support team communication and collaboration**

As mentioned above, Discord has been our main form of communication. We have created two separate channels, one for general communication and one for asking for help. 

Furthermore, we have used pair programming as a collaboration method while implementing our code, which has increased the efficiency of the workflow.

## List of Contributors

### Anna Martensson
1.

### Charlotta Johnsson
The initial three points were accomplished in collaboration with Filippa using Live Share.
1. Implemented LIC 0,1,2,3,4,5 
2. Implemented PUM 
3. Developed corresponding tests for LIC 0, 1, 2, 3, 4, 5 and the PUM module.
4. Code reviewing and refactoring.

### Emil Hultcrantz
1.

### Filippa Nilsson
1.

### Tianning Liang
1. Implementated LIC 9,10,11, 
2. Implementated FUV (in collaboration with Anna).
3. Developed corresponding tests for LIC 9, 10, 11, and the FUV module.
4. Draft version of README.md
5. Code reviewing.





