# Super Simple Stocks
Super simple stocks is an application to manage trades on a set of stocks and it's a technical test as part of 
the hiring process for a very important company.

1. Assignment Description

 Requirements

1.	Provide working source code that will:

    a.	For a given stock:
    
        i.    Calculate the dividend yield.
        ii.   Calculate the P/E Ratio.
        iii.  Record a trade, with timestamp, quantity of shares, buy or sell indicator and price.
        iv.   Calculate Stock Price based on trades recorded in past 15 minutes.

    b.	Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

Constraints & Notes

1.	Written in one of these languages:
    
    * Java, C#, C++, Python.
    
2.	No database or GUI is required, all data need only be held in memory.

3.	Formulas and data provided are simplified representations for the purpose of this exercise.

Global Beverage Corporation Exchange

Stock Symbol  | Type | Last Dividend | Fixed Dividend | Par Value
------------- | ---- | ------------: | :------------: | --------: 
TEA           | Common    | 0  |    | 100
POP           | Common    | 8  |    | 100
ALE           | Common    | 23 |    | 60
GIN           | Preferred | 8  | 2% | 100
JOE           | Common    | 13 |    | 250



2. Solution

Architecture and Assumptions

* Java is used for providing the solution
* Spring coupled with Java is used for the solution as Spring provides many core features like MVC, AOP and IOC
* Maven is used for building and for providing JUNIT test cases for this application
* The application requirements are developed as services independent of each other, this will reduce the dependency
* As the application are writtern as individual service, it is very easy to develop REST resources out of the services
* We can write a simple consumer class and can access the REST resources
* Spring property configurator is used for the loading of the property file and the values are then injected into a Spring bean
* The Spring property bean is used for testing the applications.
* The application testing can be tweaked by updating the properties file and then re running the application
* Apache logging has been used for the logging purpose



How to run and test the application

* The application contains a StockApp standalone java program which runs the entire application and outputs all the data output as per the requirement
* Change the property file values as per the need and then run the StockApp java program


Resources provided

* Class diagram
* README file to know more about the application
* Java doc comments added which can be used to generate the java doc







 

 
