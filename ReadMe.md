# gptBudgeter

This project is a simple budgeting web application with a Spring Boot backend and a React/TypeScript frontend. The backend stores data in an in-memory HSQL database.
The backend uses Gradle for builds and `application.yml` for configuration.

## Features
- Add income entries with dates
- Track recurring liabilities (e.g. mortgage, utilities)
- Record credit card payments
- Set an amount to save
- Retrieve a summary showing total income, expenses, savings and remaining balance


## Running the backend
From the `backend` directory run:
```bash
gradle bootRun
```

## Running the frontend
From the `frontend` directory run:
```bash
npm install
npm start
```
This minimal setup starts a placeholder React app that communicates with the backend APIs.
