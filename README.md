# Demo-Cucumber-Test-Suite


This is a project based on Cucumber JVM, Junit5 and Spring. It contains some feature files for a demo application. The purpose of the test-suite is not to perform any real testing, but it can be used to test some java cucumber related functionality and generate test reports.

## Test-Suite Configuration
The following properties are available:

| Property Name | Default Value  | Description |
|--|--|--|
| demo-cucumber.suite.failThreashold | 10 | It defines a percentage that is the probability of a validation step to fail, based on a random-util class. Value of 0 means no failures and value of 100 that all validation steps will fail |
| demo-cucumber.suite.minStepDurationDelay | 100L | It defines the minimum step delay that will be applied on a step. Value is in milliseconds |
| demo-cucumber.suite.maxStepDurationDelay | 1000L | It defines the maximum step delay that will be applied on a step. Value is in milliseconds |

## Attachments
Based on some tags, it is possible to generate attachments and add them on a scenario in an AfterHook step.
In order to add an attachment, tag `@attach` needs to be added and then based on the following tags, an attachment is added (if multiple are used, then all the related attachments are added)
| Tag | Description |
| --|--|
| @attach-json | adds a random json file |
| @attach-text | adds a random uuid as text |
| @attach-image | adds a random image |

## Logging
By default logging is not enabled. Set one of the following spring profiles to enable logging
| Property | Description |
| --|--|
| spring.profiles.active=fileLogs | logging is appended only in the log file under "test-output" folder |
| spring.profiles.active=allLogs | logging is appended both in the log file under "test-output" folder and in console |

## Running the tests

You can use maven from command like to trigger the test.

- Run all tests:

      mvn clean verify
- Run based on some tags:

      mvn clean verify -Dcucumber.filter.tags="@grocery-app and @cart"
- Run with some updated properties:

      mvn clean verify -Ddemo-cucumber.suite.fail-threashold=50

You can run the tests from an IDE, if you add the correct configuration.

