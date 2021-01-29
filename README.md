## JZAP
### ZAP-Java

ZAP Oracles (introduction here)

This repository provides Interface to Zap contracts and tools to use Zap platform with Java projects

Each package is a public maven dependency that serve developer's needs to intergrate Zap platform


# Development

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes

### Prerequisites


##### 1. Install Maven @ https://maven.apache.org/install.html
##### 2. Install Web3j 
```
curl -L get.web3j.io | sh && source ~/.web3j/source.sh
```
Troubleshoot: @ http://docs.web3j.io/latest/quickstart/

##### 3. Install Truffle

```
npm i -g truffle
```

##### 4. (OPTIONAL) Import your desired contracts into contracts/

##### 5. Compile and run using spring boot

```
mvn spring-boot:run
```
##### 6. Create a wallet using web3j
```
web3j wallet create
```

##### 7. Run the Web3j application on the developer network  @ https://github.com/zapproject/devnet
```
web3j run <HARDHAT NETWORK URI> <WALLET FILE> <WALLET PASSWORD>
```



## Running build and tests

## Packages

# Usage
### Prerequisites


##### 1. Create Personal Access Token and select the scope 'read:packages' @ https://github.com/settings/tokens

##### 2. Create or Add the following to ~/.m2/settings.xml (or whereever you set your settings directory for Maven) 

```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">

  <activeProfiles>
    <activeProfile>github</activeProfile>
  </activeProfiles>

  <profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
          <releases><enabled>true</enabled></releases>
          <snapshots><enabled>true</enabled></snapshots>
        </repository>
        <repository>
          <id>github</id>
          <name>GitHub Zap Project Apache Maven Packages</name>
          <url>https://maven.pkg.github.com/zapproject/jzap</url>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    <server>
      <id>github</id>
      <username>USERNAME</username> <!-- YOUR GITHUB USER NAME GOES HERE -->
      <password>TOKEN</password> <!-- YOUR GITHUB PERSONAL ACCESS TOKEN GOES HERE -->
    </server>
  </servers>
</settings>
```

### Installing

Add to your pom.xml

```
		<dependency>
			<groupId>io.github.zapproject</groupId>
			<artifactId>jzap</artifactId>
			<version>[0.0.0,)</version>
		</dependency>
```

##### Creating a Zap Provider oracle
```

```
**With Custom configuration**
```

```
**Some example for provider usage**



## Built With


## Contributing

Please read [CONTRIBUTING.md]() for details on our code of conduct, and the process for submitting pull requests to us.


See also the list of [contributors]()

## License


This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

