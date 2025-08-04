# 🏦 ParaBank Test Automation Suite

Automated functional testing framework for the [ParaBank demo banking application](https://parabank.parasoft.com/). 
Built using **Java**, **TestNG**, and **Selenium WebDriver**. 
This project is designed to validate account creation, login, and bill payment features based on the condition that accounts on ParaBank will expire after a set duration.
Utilizing a scalable and maintainable test architecture.

---

## 📁 Project Structure
```plaintext
ParaBank/
├── src/test/           # Test classes and suites
├── xml/                # TestNG suite configuration files
├── reports/            # Test execution reports
├── screenshots/        # Screenshots captured during test failures
├── logs/               # Log files for debugging
├── test-output/        # TestNG default output
├── pom.xml             # Maven build configuration
└── run.bat             # Batch script to execute tests (edit with Notepad to customize it based on your local project's repo location)
```

---

## ⚙️ Tech Stack

- **Java 8+**
- **TestNG** – test framework
- **Selenium WebDriver** – browser automation
- **Maven** – build and dependency management
- **Eclipse IDE** – development environment
- **Excel Automation** – for account data management
- **Custom Builders** – for workflow optimization

---

## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/PikaPrasetya/ParaBank.git
2. Navigate to the project directory:
   ```bash
   cd ParaBank
3. Run test using Maven
   ```bash
   mvn clean test
4. Or use the batch file
   ```bash
   run.bat

## 📊 Features- ✅ Login and account operations
- ✅ Excel-based account creation
- ✅ Screenshot capture on failure
- ✅ Custom test reports and logs

Screenshots & Reports Test failures automatically generate screenshots saved in /screenshots. Execution reports are stored in /reports and /test-output.
    
