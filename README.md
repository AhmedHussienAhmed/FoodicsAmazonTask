Selenium Automation for Amazon Egypt
This project automates a series of steps on the Amazon Egypt website using Selenium and Java. The scenario involves logging in, navigating through product categories, applying filters, adding products to the cart, providing address details, and verifying the total amount.

Prerequisites
Before running the automation script, make sure you have the following set up:

Java Development Kit (JDK) installed on your machine.
Selenium WebDriver configured with a compatible browser driver (e.g., ChromeDriver).
Make sure to install Google chrome version (114-0-5735-199) to be compatable with chromeDriver
Dependencies and libraries added to your Java project for Selenium.



Usage
Clone or download this repository to your local machine.
Open the project in your preferred Java development environment (e.g., Eclipse, IntelliJ).
Configure Selenium WebDriver with the appropriate browser driver. Update the path to your driver in the automation script.
Open the AmazonAutomation.java file and review/update the following variables:
URL - Replace with the Amazon Egypt URL.
username and password - Your Amazon login credentials.
Other elements' locators may need adjustment depending on the website structure and any changes Amazon makes.
Run the AmazonAutomation.java script to execute the automation scenario.


Scenario Steps
The automation script performs the following steps:

Opens the Amazon Egypt website.
Logs in with the provided credentials.
Navigates to the "All" menu from the left side.
Clicks on "Video Games" and chooses "All Video Games."
Adds filters for "Free Shipping" and "Condition: New" from the left side.
Opens the sort menu and sorts by price: high to low.
Adds all products with a cost below 15,000 EGP to the cart.
Provides the address details and selects cash as the payment method.
Verifies that the total amount of all items is correct, including shipping fees if applicable.


Notes
Ensure that your internet connection is stable during the automation process.
The script may require adjustments if Amazon's website structure changes in the future.


Author
Ahmed Hussien
