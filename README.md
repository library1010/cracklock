# Crack the lock
Just solved a puzzle in internet

![Alt text](https://cloud.githubusercontent.com/assets/6070520/24503343/a968e500-158c-11e7-9b10-5fd8664fa591.jpg "Crack the lock puzzle")


## How to build
After cloning this project, you can build it by using maven, or import it to eclipse (via import maven project)

### Build by maven
Run the following command in terminal

`mvn clean install`

### Build by Eclipse
Do as following instructions
* Download Project Lombok, import it to Eclipse (please refer to the **Reference**).
* Right click to `Package Explorer` and choose `Import`.
* In import wizard, choose `Existing Maven Projects`, then click Next button.
* Browse to the project directory (which contains `pom.xml` file), select the `pom.xml` file and click Next button.

## How to run
### Build by maven
After builded the project, you can run it by maven by using the following command

`mvn -q exec:java`

Or you can combine the building and running phase by using the following command

`mvn -q -DskipTests clean install exec:java`

### Run by Eclipse
Go to `library.cracklock.App` class, right click to the main method, and choose `Run As` > `Java Application`.

## Reference
### Project Lombok
Home page URL: 
> https://projectlombok.org/

How to import Project lombok to Eclipse IDE: 
> http://stackoverflow.com/questions/22310414/how-to-configure-lombok-in-eclipse-luna
