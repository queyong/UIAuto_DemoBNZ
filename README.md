# UIAuto_DemoBNZ

## About

- The repo is a practical demo that demonstrates how to build a Web UI automation solution.
- The test scenarios are from BNZ Demo pages


## Frameworks used 
### [BDD/Cucumber/Gherkin](https://cucumber.io/)

- Behavior-Driven Development is a software development process and collaboration practice for software teams to work that closes the gap between business people and technical people
- Cucumber is a software/collaboration tool that supports behavior-driven development.
- Gherkin is a set of grammar rules that makes plain text structured enough for Cucumber to understand

### [Selenium/WebDriver](https://www.selenium.dev/documentation/en/webdriver/)

- Selenium is an umbrella project for a range of tools and libraries that enable and support the automation of web browsers. （WebDriver, IDE, Grid)
- WebDriver is an API and protocol that defines a language-neutral interface for controlling the behaviour of web browsers. 


### [TestNG](https://testng.org/)

- The TestNG Automation Testing Framework provides the mechanisms needed to run the test logic so the test writer only needs to provide the test-specific logics, inspired from JUnit framework

### [Maven](https://maven.apache.org/)

- Using Apache Maven as a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

### [ExtentReports](http://www.extentreports.com/)

- With integration the ExtentReports library, it can generate beautiful, interactive and detailed reports for the automation tests.

## Automation Features/Patterns
- [Page Object Model](https://martinfowler.com/bliki/PageObject.html)
  - Page Object Model is a design pattern to create an "object repository" for WebUI elements. 
  - The goal of using page objects is to abstract any page information away from the actual tests. Ideally, you should store all selectors or specific instructions that are unique for a certain page in a page object, so that you still can run your test after you've completely redesigned your page
  - here in the demo project, **"Payees"** is the page object class


- WebDriver Singleton Pattern
  - the solution is using the single driver object for all instances where the WebDriver is required
  - **"DriverContext"** class is the WebDriver singleton class

- Reporting
  - the solution is integrating ExtentReports for test reporting and providing sceenshots for any failed steps.
  
- [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) for more easy way of using different webdrivers 


## How To Run Tests

### prerequisites
- Install Java
  * [Java sdk 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
  * set java home in your environment variables

- Install Maven
  - [Maven](https://maven.apache.org/download.cgi)
  - set maven in your environment PATH
 
- Fork / Clone repository or download zip and set it up in your local workspace.  
  
## run under CMD Line
- Go to your local project directory and run following commands
  - **mvn verify**
  - by default the test is running with Chrome broswer
  - you can change to other browser type(firefox) by changing **DriverType** in **src\main\java\com\auto\framework\config\Setting.java**
   
## How to run or debug from IntelliJ IDE
- import the project as a Maven project in IntelliJ IDE
- select "Import Maven projects automatically
- select project SDK (1.8)
- enter a Project Name
- config settings and dependencies: Maven, Java Complier, pom.xml
- you can reivew the source code and debug or add new test scenarios
- several ways to run automated test scenarios from Intellij IDE:
    - TestNG: Right click on testng.xml file, and Run -> This will run all tests attached to specific xml runner

    - [Maven tool window](https://www.jetbrains.com/help/idea/maven-projects-tool-window.html): Double click : UIAuto_DemoBNZ -> Lifecycle -> verify

    - Cucumber:
      - Right click on .feature file, and Run -> This will run .feature file on default settings;
      - Right click on Scenario inside the .feature file, and Run -> scenario, this will run the scenario on default setting;
      - Can use **CucumberOptions -> tags** to control test execution scope, e.g. @Major or @smoke level scenarios.

## Test reporting
- The solution integrates [ExtentReports](http://www.extentreports.com/) 
  - it can generate beautiful, interactive and detailed reports under **..\src\test\Report\cucumber-reports\extent_report.html** after test run
  - The screenshot will be attached at the each failed step, and stored in **src\test\Report\cucumber-reports\screenshots**
  - Test report can be found after test run: **src\test\Report\cucumber-reports**
## CI/CD
- the command line run method can be integrated into CICD pipeline.

## Authors
- [Yong Que](queyong@gmail.com) 



