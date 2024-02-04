# Manage Testing Data with Java

This project belongs to a series of posts on my blog about this subject.
Please feel free to contribute and send your pull requests with either better or new ways to manage data.

## Run this project
As it is a testing project you don't need too much. You will need the following:

* IDE of your choice
* Java JDK 21+
* Maven

## Managing  data through a property file

| Approach | Test class | Support classes | 
|--|--|--
| Local solution to read a property file | [PropertiesFileTest.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/properties/plain/PropertiesFileTest.java) | [ReadProperties.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/main/java/com/eliasnogueira/properties/plain/ReadProperties.java), and [data.properties](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/resources/data.properties) |
| Solution using Owner library | [PropertiesFileWithOwnerTest.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/properties/owner/PropertiesFileWithOwnerTest.java) | [PropertiesManager.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/main/java/com/eliasnogueira/properties/owner/PropertiesManager.java), [PropertiesFile.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/main/java/com/eliasnogueira/properties/owner/PropertiesFile.java), and [data.properties](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/resources/data.properties) |

## Data Driven with JUnit

| Approach | Test class | Support classes / files | 
|--|--|--|
| Using the `@ValueSource` annotation | [JUnitValueSourceTest](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/datadriven/junit/JUnitValueSourceTest.java) | |
| Using the `@MethodSource` annotation with internal data methods | [JUnitInternalMethodSourceTest.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/datadriven/junit/JUnitInternalMethodSourceTest.java) | |
| Using the `@MethodSource` annotation with external data methods | [JUnitExternalMethodSourceTest.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/datadriven/junit/JUnitExternalMethodSourceTest.java) | [JUnitExternalData.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/main/java/com/eliasnogueira/datadriven/JUnitExternalData.java) |
| Using the `@ArgumentsSource` annotation with an argument provider | [JUnitArgumentProviderTest.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/datadriven/junit/JUnitArgumentProviderTest.java) | [ProductsDataArgumentProvider.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/main/java/com/eliasnogueira/datadriven/ProductsDataArgumentProvider.java) |
| Using the `@CsvFileSource` annotation with an external csv file | [JUnitCSVSourceTest.class](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/datadriven/junit/JUnitCSVSourceTest.java) | [products.csv](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/resources/products.csv) |

## Data Driven with TestNG

| Approach | Test class | Support classes / files | 
|--|--|--|
| Using the `@Parameters` annotation | [TestNGParametersTest.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/datadriven/testng/TestNGParametersTest.java) | [testng_data_parameters.xml](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/resources/testng_data_parameter.xml) |
| Using the local `@DataProvider` | [TestNGLocalDataProviderTest.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/datadriven/testng/TestNGLocalDataProviderTest.java) | |
| Using an external `@DataProvider` | [TestNGExternalDataProviderTest.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/test/java/com/eliasnogueira/datadriven/testng/TestNGExternalDataProviderTest.java) | [TestNGDataProvider.java](https://github.com/eliasnogueira/manage-testing-data-java/blob/main/src/main/java/com/eliasnogueira/datadriven/TestNGDataProvider.java) |
