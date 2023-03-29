# Interoperability of information Systems

This is a Java Spring Boot MVC project which consists of several modules that provide a RestAPI for saving and validating XML files using XSD and RNG schemas, a SOAP web service, JAXB XML validation, an XML-RPC module for searching cities and their temperatures and a user interface to connect them all.

## Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher

## Installation and Usage

1. Clone the project repository using the following command:

```
git clone https://github.com/dautovicalan/iis-project.git
```

2. Navigate to the project directory:

```
cd iis-project
```

3. Build the project:

```
mvn clean package
```

4. Run the project:

```
java -jar target/iis-project-0.0.1-SNAPSHOT.jar
```

5. Access the user interface at **http://localhost:8080**

## Modules

### XML Validation Module

The XML validation module provides a RestAPI for saving and validating XML files using XSD and RNG schemas.

### SOAP Web Service Module

The SOAP web service module provides a SOAP web service that can be used to search NBA Teams over their Code. Service will create XML and search the following with XPATH and return the result to end user. Also created XML will be saved.

### JAXB Module

Simple module that validates generated XML from SOAP Web Service with XSD Schema.

### XML-RPC Module

The XML-RPC module provides an XML-RPC Client and Server to search for cities and their temperatures. The data is fetched and parsed from an external API.

### User Interface

The user interface provides a graphical user interface to interact with the RestAPI, SOAP web service, and XML-RPC module.

## Technologies Used

- Java
- Spring Boot
- JAXB
- XSD
- RNG
- SOAP
- XPATH
- XML-RPC
- Maven

## License

This project is licensed under the MIT License.
