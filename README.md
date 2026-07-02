#PART 1 — EXPLAIN YOUR FRAMEWORK

"We built a REST API test automation framework from scratch using Java, REST Assured, and TestNG, managed by Maven.

The framework follows the Service Object Model (SOM) pattern — same concept as Page Object Model in UI, but for APIs. The idea is clean separation of concerns:

Base layer — handles HTTP configuration, base URI, headers, auth token setup
Service layer — wraps API endpoints as reusable methods (login, register, fetchUser)
Model layer — request and response POJOs, auto-serialized by Jackson
Test layer — only test logic and assertions, no HTTP code
For test data we use JavaFaker to generate random emails/passwords so tests are independent and don't conflict.

For logging we have a custom REST Assured Filter that intercepts every request and response and logs them via Log4j2 — no code needed in individual tests.

For reporting we use ExtentReports wired through a TestNG ITestListener — pass/fail/skip is auto-captured with failure details in an HTML report.

Suites are driven by TestNG XML files — separate suites for smoke and regression, triggered by Maven Surefire with a -Dsuite parameter, which makes CI integration straightforward.

If I were to improve it: externalize the base URL to config.properties, add JSON Schema validation, data-driven testing with @DataProvider, and plug it into a CI/CD pipeline."

#FrameWork parameters
Framework Type    : REST API Test Automation
Pattern           : Service Object Model (SOM)
Language          : Java 17
Test Framework    : TestNG 7.x
HTTP Library      : REST Assured 5.x
Serialization     : Jackson (ObjectMapper)
Test Data         : JavaFaker
Logging           : Log4j2 + Custom REST Assured Filter
Reporting         : ExtentReports 5.x (via ITestListener)
Build Tool        : Maven + Surefire Plugin
Suite Management  : TestNG XML (Suite.xml / Suite2.xml)
Base URL          : https://api.eventhub.rahulshettyacademy.com
Auth Type         : Bearer Token

