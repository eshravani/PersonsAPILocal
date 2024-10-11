# API Automation Practice Project

This project is designed to help you practice creating POJO classes for API automation and validating API responses. It uses `json-server` to create a local mock API and Rest Assured for testing.

## Table of Contents
- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Usage](#usage)
- [Features](#features)
- [License](#license)

## Overview
In this project, you will:
1. Create POJO classes that map to JSON data structures.
2. Use `json-server` to create a local mock API.
3. Validate API responses to ensure they match expected data structures.

## Prerequisites
- [Node.js](https://nodejs.org) installed on your machine.
- [json-server](https://www.npmjs.com/package/json-server) installed globally.

   ```bash
   npm install -g json-server
## Setup

Download the persons.json file containing mock data for API testing.

Start json-server with persons.json:

Open a terminal and navigate to the directory containing persons.json.
Start the server with the following command:

   ```bash
   json-server --watch persons.json

This will start a local API server at http://localhost:3000.
## Clone this repository:
This will start a local API server at http://localhost:3000.

    ```bash
    git clone https://github.com/username/ApiAutomationPractice.git
Install dependencies: Run the following Maven command to install all necessary dependencies:


    ```bash
    mvn clean install

## Usage
Define POJO Classes

Create Java POJO classes that mirror the structure of persons.json data.
Run Tests Run your tests with:


    ```bash
    mvn test
This will execute the tests defined in ApiTest.java.

Validate API Responses

Ensure that API responses can be deserialized into POJO classes using Jackson Databind, preventing errors like java.lang.IllegalStateException: Cannot parse object because no JSON deserializer found in classpath.
Features
Practice creating POJO classes for complex JSON structures.
Validate JSON API responses against Java object models.
Simulate API testing using a mock server with json-server.
License
This project is for educational purposes.
