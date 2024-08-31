Here's a README file tailored for your Naaptol project that involves Selenium, Maven, TestNG, and Extent Reports:

---

# Naaptol Website Automation Project

This project is focused on automating the Naaptol website using Selenium WebDriver, Java, Maven, TestNG, and Extent Reports. The automation includes testing various categories like Home Linen & Furniture, Furniture, Home and Wellness, and Brands.

## Table of Contents

- [Project Objective](#project-objective)
- [Tech Stack](#tech-stack)
- [Project Setup](#project-setup)
- [Directory Structure](#directory-structure)
- [Test Scenarios](#test-scenarios)
- [Execution](#execution)
- [Reporting](#reporting)
- [Features Implemented](#features-implemented)
- [Future Enhancements](#future-enhancements)
- [About Me](#about-me)
- [Feedback](#feedback)

## Project Objective

The main objective of this project is to automate the navigation and purchasing process on the Naaptol website, ensuring the reliability and functionality of various categories. The project also aims to generate detailed reports and capture screenshots for failed test cases.

## Tech Stack

- **Programming Language:** Java
- **Build Tool:** Maven
- **Testing Framework:** TestNG
- **Automation Tool:** Selenium WebDriver
- **Reporting Tool:** Extent Reports
- **Version Control:** Git, GitHub
- **IDE:** IntelliJ IDEA / Eclipse

## Project Setup

### Prerequisites

1. **Java Development Kit (JDK):** Install JDK 8 or above.
2. **Maven:** Ensure Maven is installed and configured.
3. **IDE:** Install IntelliJ IDEA or Eclipse.
4. **Git:** Install Git for version control.

### Installation Steps

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/Naaptol-Automation.git
   ```

2. **Import the Project:**
   - Open your IDE and import the Maven project.
   - Wait for Maven to resolve all dependencies.

3. **Update `pom.xml`:**
   - Ensure all necessary dependencies are included:
     - Selenium Java
     - TestNG
     - Extent Reports
     - WebDriverManager

4. **Configure TestNG:**
   - Set up the `testng.xml` file to define test suites and test classes.

## Directory Structure

```plaintext
Naaptol_Automation/
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ com/
│  │  │      └─ naaptol/
│  │  │          └─ pages/
│  │  │          └─ tests/
│  │  │          └─ utils/
│  ├─ test/
│  │  ├─ java/
│  │  │  └─ com/
│  │  │      └─ naaptol/
│  │  │          └─ tests/
├─ resources/
│  ├─ config/
│  │  └─ config.properties
│  ├─ testng.xml
├─ pom.xml
└─ README.md
```

### Key Folders and Files:

- **pages/**: Contains Page Object Model (POM) classes.
- **tests/**: Contains TestNG test classes.
- **utils/**: Utility classes like WebDriver setup, screenshot capture, etc.
- **config.properties**: Configuration file for storing URL, browser type, and other settings.
- **testng.xml**: TestNG suite configuration file.

## Test Scenarios

1. **Home Linen & Furniture:**
   - Navigate to the category.
   - Add items to the cart.
   - Validate the cart contents.
   - Proceed to checkout.

2. **Furniture:**
   - Browse and select furniture items.
   - Add items to the wishlist.
   - Validate the wishlist.

3. **Home and Wellness:**
   - Search for wellness products.
   - Add products to the cart.
   - Verify pricing and product details.

4. **Brands:**
   - Navigate to a specific brand.
   - Validate the list of products available under the brand.
   - Check the availability of filters.

## Execution

1. **Run the Tests:**
   - Use the following Maven command to execute the tests:

   ```bash
   mvn clean test
   ```

2. **Running Specific Test Suites:**
   - Edit the `testng.xml` file to include or exclude specific tests.
   - Use the following command to run a specific suite:

   ```bash
   mvn test -DsuiteXmlFile=testng.xml
   ```

## Reporting

- **Extent Reports:**
  - After the test execution, a detailed report is generated in the `test-output` folder.
  - Open the `ExtentReport.html` file in a browser to view the results.

## Features Implemented

- **Page Object Model (POM):** Structured page classes for modular and maintainable code.
- **Assertions:** Implemented assertions for validation.
- **Screenshots:** Captured screenshots for failed test cases.
- **Reporting:** Generated HTML reports using Extent Reports.

## Future Enhancements

- **Data-Driven Testing:** Implement data-driven testing using Apache POI to read test data from Excel files.
- **Parallel Execution:** Configure TestNG for parallel execution of tests to reduce test execution time.
- **CI/CD Integration:** Integrate with Jenkins for continuous integration and continuous deployment.

## About Me

I have expertise in Selenium, Java, TestNG, and Maven. My focus is on building robust automation frameworks and ensuring comprehensive test coverage for web applications.

## Feedback

If you have any feedback or suggestions, feel free to reach out to me at [your-email@example.com](mailto:your-email@example.com).

---

This README should provide a clear overview of your Naaptol project, including setup instructions, test scenarios, and other essential details.
