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

## List of Contributors

### Anna Martensson
1.

### Charlotta Johnsson
1.

### Emil Hultcrantz
1.

### Filippa Nilsson
1.

### Tianning Liang
1. 




