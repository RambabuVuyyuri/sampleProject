# sampleProject
Midtrans web application automation using java and TestNG

Page Object Model is the approach is followed for this project which includes pages, tests, utility classes by using TestNG framework methodologies and TestNG reporting sysytem.

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
Close this project 
                       
