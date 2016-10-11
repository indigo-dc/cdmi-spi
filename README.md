# INDIGO-DataCloud CDMI Java SPI
Java Service Provider Interface for CDMI storage back-ends

## Maven
### Latest Release (Stable)
v0.3

### Release notes v0.3
- added structure to CdmiObjectStatus to hold CDMI export attributes

### Usage

**Using cdmi-spi from KIT SCC repository**
```xml
<repositories>
	<repository>
		<releases>
		  <enabled>true</enabled>
		  <updatePolicy>always</updatePolicy>
		  <checksumPolicy>fail</checksumPolicy>
		</releases>
		<id>SCC-KIT</id>
		<name>SCC</name>
		<url>http://cdmi-qos.data.kit.edu/maven/</url>
	  <layout>default</layout>
  </repository>
</repositories>
```

```xml
<dependency>
	<groupId>edu.kit.scc</groupId>
	<artifactId>cdmi-spi</artifactId>
	<version>0.2</version>
</dependency>
```

## Requirements

* JDK 1.8+
* [Maven 3+](https://maven.apache.org/)

## Build & Usage
The project uses the Maven build automation tool.

You can build the project with
```
mvn clean package
```
