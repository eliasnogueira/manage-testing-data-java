# Manage Testing Data with Java

This project belongs to a series of posts on my blog about this subject.
Please feel free to contribute and send your pull requests with either better or new ways to manage data.

## Run this project
As it is a testing project you don't need too much. You will need the following:

* an IDE (I suggest IntelliJ IDEA)
* Java JDK 17+
* Maven

## Managing  data through a property file

| Approach                               | Test class                         | Support classes                                                       | 
|----------------------------------------|------------------------------------|-----------------------------------------------------------------------|
| Local solution to read a property file | `PropertiesFileTest.java`          | `ReadProperties.java` and `data.properties`                           |
| Solution using Owner library           | `PropertiesFileWithOwnerTest.java` | `PropertiesManager.java`, `PropertiesFile.java` and `data.properties` |

## Data Driven with JUnit

| Approach                                                        | Test class                           | Support classes / files             | 
|-----------------------------------------------------------------|--------------------------------------|-------------------------------------|
| Using the @ValueSource annotation                               | `JUnitValueSourceTest`               |                                     |
| Using the @MethodSource annotation with internal data methods   | `JUnitInternalMethodSourceTest.java` |                                     |
| Using the @MethodSource annotation with external data methods   | `JUnitExternalMethodSourceTest.java` | `JUnitExternalData.java`            |
| Using the @ArgumentsSource annotation with an argument provider | `JUnitArgumentProviderTest.java`     | `ProductsDataArgumentProvider.java` |
| Using the @CsvFileSource annotation with an external csv file   | `JUnitCSVSourceTest.class`           | `products.csv`                      |

## Data Driven with TestNG

| Approach                         | Test class                            | Support classes / files      | 
|----------------------------------|---------------------------------------|------------------------------|
| Using the @Parameters annotation | `TestNGParametersTest.java`           | `testng_data_parameters.xml` |
| Using the local @DataProvider    | `TestNGLocalDataProviderTest.java`    |                              |
| Using an external @DataProvider  | `TestNGExternalDataProviderTest.java` | `TestNGDataProvider.java`    |
