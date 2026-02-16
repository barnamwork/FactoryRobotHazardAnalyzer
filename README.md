# Factory Robot Hazard Analyzer

A Java console application that evaluates the hazard risk score of factory robots based on arm precision, worker density, and machinery state.

## Overview

This project demonstrates:
- Object-Oriented Programming principles
- Custom Exception Handling
- UC-wise development approach
- GitFlow methodology

## Features

- Input validation for robot parameters
- Hazard risk calculation using weighted formula
- Custom exception handling (`RobotSafetyException`)
- Modular class design

## Formula
```
Hazard Risk = ((1.0 - armPrecision) × 15.0) + (workerDensity × machineRiskFactor)
```

**Machinery Risk Factors:**
- Worn: 1.3
- Faulty: 2.0
- Critical: 3.0

## Usage
```
Enter Arm Precision (0.0 - 1.0):
0.5
Enter Worker Density (1 - 20):
10
Enter Machinery State (Worn/Faulty/Critical):
Critical

Robot Hazard Risk Score: 37.5
```

## Input Parameters

- **Arm Precision**: 0.0 - 1.0 (double)
- **Worker Density**: 1 - 20 (int)
- **Machinery State**: Worn/Faulty/Critical (String, case-sensitive)


## Development Process

Developed using 8 Use Cases (UC1-UC8):

**UC1: Display Static Message**
- Prints a static message indicating the system's purpose using basic class structure and main method.

**UC2: Accept Inputs**
- Collects user inputs for arm precision, worker density, and machinery state using Scanner.

**UC3: Basic Calculation**
- Implements the hazard risk formula without validation to calculate the risk score.

**UC4: Add Validation**
- Introduces conditional logic to validate input ranges and display error messages for invalid inputs.

**UC5: Refactor to Method**
- Extracts validation and calculation logic into a separate method for better code organization.

**UC6: Custom Exception**
- Implements RobotSafetyException class and replaces error returns with proper exception throwing.

**UC7: Risk Mapping**
- Uses constants and switch statements to map machinery states to their risk factors.

**UC8: OOPS Design**
- Separates concerns into distinct classes (RobotSafetyException, RobotHazardAuditor, Program) following OOPS principles.

## GitFlow

Feature branches:
- feature/UC1 to feature/UC8
- All merged into develop branch

## Test Cases

**Test 1 - Valid Input:**
```
Input: 0.5, 10, Critical
Output: Robot Hazard Risk Score: 37.5
```

**Test 2 - Invalid Arm Precision:**
```
Input: 1.3, 4, Worn
Output: Error: Arm precision must be 0.0-1.0
```

**Test 3 - Invalid Worker Density:**
```
Input: 0.7, 26, Critical
Output: Error: Worker density must be 1-20
```

**Test 4 - Invalid Machinery State:**
```
Input: 0.3, 14, Optimal
Output: Error: Unsupported machinery state
```

## OOPS Principles

- **Encapsulation**: Logic in RobotHazardAuditor class
- **Abstraction**: Clean method interfaces
- **Single Responsibility**: Each class has one role
- **Extensibility**: Easy to add new machinery states
