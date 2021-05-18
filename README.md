# sampleProject
Midtrans web application automation using java and TestNG

Maven project with Page Object Model approach is been followed for this project which includes pages, tests, utility classes by using TestNG framework methodologies and TestNG reporting sysytem.

Project package structure follows:
![image](https://user-images.githubusercontent.com/45011356/118628983-c5946880-b7ea-11eb-934d-735a47b3361d.png)
Packages structure is:

src/test/java:
             Pages:
                   HomePage.java
                   OrderSummaryPage.java
                   OTPPage.java
                   PaymentPage.java
                   PaymentValidation.page
             testCases:
                   TC1_success_test.java
                   TC2_failure_test.java
             utilities:
                   BrowserManager.java
                   
                   
Created individual page web objects and page mothds for each and every page in the website by using PageFactory packae initialization.
Reporting Syatem : Followed Test NG standard reporting system for this test case , default reports wil be generated under test-output folder.
Execution :
Clone the project:
using HTTP link:https://github.com/RambabuVuyyuri/sampleProject.git
and Import project as maven.
POM.xml contains all the required dependencies require for this test cases to run.
TestNGRunner.xml:
You can achive cross browser testing by passing different arguments in <parameter>section as browser name="firefox' that would instanciate FireFox() browser.
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">

<suite name="SampleProject" verbose="1">
    <parameter name="browser" value="chrome" />
    <parameter name="url" value="https://demo.midtrans.com" />
    <test name="SuccessTest">
        <classes>
            <class name="testcases.TC1_success_test" />
        </classes>
    </test>
</suite>
                       
