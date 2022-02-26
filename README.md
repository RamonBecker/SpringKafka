# SpringKafka

## :information_source: Information 

Project developed with Spring, Kafka, Zookeeper, Schema-Registry, Rest-Proxy and Docker. Only the backend part was developed. Consumers and producers were created. In v1, only examples of consumers and products were developed. In v2, three applications were developed: consumers, producers and an application that is both producer and consumer. In these applications avro schemes were created for the consumption and sending of messages. A complete service environment was also created via docker-compose. For docker-compose there are two versions, which can be found in v1 and v2. It is recommended to use v2 with landoop.

Some explanations of the technologies that were used:

- **Schema Registry:** Provides a service layer for message metadata. It provides a RESTful interface to store and retrieve the Avro schemas that were created and it uses Apache Kafka itself as a storage layer.

- **REST Proxy**: Provides a RESTful interface to an Apache Kafka cluster, which facilitates the production and consumption of messages.

- **Apache Zookeeper**: Kafka uses Zookeeper to synchronize settings between different clusters.

- **Consumer:** Read data from any partition, allowing consumption to be scaled according to message production. They can also be organized into Consumer Groups for a given topic. Using Consumer Groups, each Consumer in the group reads from a single partition, so the group as a whole consumes messages from the entire topic.

- **Producer:** They are conceptually simpler than Consumers, as there is no need for group coordination (Consumer Groups). Its main function is to map each message to a topic partition and send a production request to the partition leader.

Example of how Kafka works:

![exemplo](https://user-images.githubusercontent.com/44611131/155854371-5fb86373-5ae8-4839-9897-d446a6f68df0.jpg)



## ⚠️ Prerequisite
[![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/br/java/technologies/javase-downloads.html) >= 17


![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

![Kafka](https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apache-kafka&logoColor=white)

![Spring Boot Badge](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)

![JSON Badge](https://img.shields.io/badge/json-5E5C5C?style=for-the-badge&logo=json&logoColor=white)

![h2-logo-2 (1)](https://user-images.githubusercontent.com/44611131/136869740-c514d30e-d529-4167-a459-4fcd647cce19.png)

![JPA-hibernate (1)](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)

![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)

![Postman Badge](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white) OR ![Insomnia Badge](https://img.shields.io/badge/Insomnia-5849be?style=for-the-badge&logo=Insomnia&logoColor=white)



##  🔧 Install 


![](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)


```
git clone https://github.com/RamonBecker/SpringKafka.git
```

![](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)
```
git clone https://github.com/RamonBecker/SpringKafka.git
or install github https://desktop.github.com/ 
```

## 🔨 Docker

Before cloning the project, you will need to install docker on your operating system.

For windows, enter the following from the link:

```
https://docs.docker.com/desktop/windows/install/
```

For linux, follow the procedure below:
- Update your existing list of packages:

```
sudo apt update
```

- Install some prerequisite packages that let apt use packages over HTTPS:

```
sudo apt install apt-transport-https ca-certificates curl software-properties-common

```

- Add the GPG key to the official Docker repository on your system:

```
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```
- Add the Docker repository to the APT sources:

```
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"

```

- Update the package database with Docker packages from the newly added repository:

```
sudo apt update
```

- Make sure you are about to install from the Docker repository instead of the default Ubuntu repository:

```
apt-cache policy docker-ce
```

- Install Docker:

```
sudo apt install docker-ce
```

- Check if it is working:

```
sudo systemctl status docker
```


After cloning the project, perform the following
Enter the services folder, then enter the v2 folder and run the following command:

```
docker-compose up   
```

## Access to Landoop
Before accessing the landoop you must run the docker container that is in the service folder in v2
To access landoop, access your browser of choice:

```
http://localhost:3030/
```

With landoop you will be able to have an overview of your topics, brokers, messages, as well as verify that the following services are working:
```
9092 : Kafka Broker
8081 : Schema Registry
8082 : Kafka REST Proxy
2181 : ZooKeeper
```

![landoop](https://user-images.githubusercontent.com/44611131/155855329-90041f16-1da5-460c-bcf5-76181e57b04b.PNG)


## 🔨 POSTMAN

To test the end points you will need to install POSTMAN or Insomnia. I recommend installing POSTMAN. I'll leave the collections on the DRIVE to facilitate testing.

Download and import collections into your POSTMAN: 
```
https://drive.google.com/drive/folders/1fJjv9oOSvx3ZhJShdG34Ok3hf_EjV5ZP?usp=sharing
```

## ⚙️ Testing the project


To test the project you will need to clone the repository on your machine. You can choose both tools: postman or insomnia.
```
To download postman go to the following link: https://www.postman.com/downloads/
```
```
To download insomnia rentre from the following link: https://insomnia.rest/download
```
Remembering that you must choose the operating system corresponding to your machine.
After you have made your registration in these tools, run them and you must type the following in the address: 


Producer endpoints:
```
localhost:8181/peoples

localhost:8181/cars
```
Rest-Proxy endpoints:

- Check broker ID 
```
localhost:8082/v3/clusters/
```
- Topic creation
- To create a topic, the broker ID must be consulted
```
http://localhost:8082/v3/clusters/{idBroker}/topics
```
- Check the topics
- To verify the topic, the broker ID must be queried
```
http://localhost:8082/v3/clusters/{idBroker}/topics
```

- Send message to topic

```
http://localhost:8082/topics/topic-01
```
- To create a group and a consumer
```
http://localhost:8082/consumers/consumer-group-01
```

- To register a consumer
```
http://localhost:8082/consumers/consumer-group-01/instances/consumidor1/subscription
```

To consume some message
```
http://localhost:8082/consumers/consumer-group-01/instances/consumidor1/records
```
## Accessing the H2 database


If you want to modify the user to access the database, modify the application.properties file.
Change the following:
```
spring.datasource.username=user
spring.datasource.password=password
```

Access in browser
```
http://localhost:8080/h2-console
```
If the JDBC URL is not configured, replace it with:
```
jdbc:h2:mem:testdb
```
![h2](https://user-images.githubusercontent.com/44611131/137225410-277de0f7-cf7c-48b1-b9e4-9be2d5b4ff43.PNG)


## :zap: Technologies	

- Java
- JPA
- Kafka
- Hibernate
- Spring Boot
- H2 Database
- Design Pattern MVC
- Design Pattern DTO
- Lombok

## :memo: Developed features

- [x] Consumer creation;
- [x] Producer creation;
- [x] Consume message;
- [x] Produce message;
- [x] Consult the topics


## :technologist:	 Author

By Ramon Becker 👋🏽 Get in touch!



[<img src='https://cdn.jsdelivr.net/npm/simple-icons@3.0.1/icons/github.svg' alt='github' height='40'>](https://github.com/RamonBecker)  [<img src='https://cdn.jsdelivr.net/npm/simple-icons@3.0.1/icons/linkedin.svg' alt='linkedin' height='40'>](https://www.linkedin.com/in/https://www.linkedin.com/in/ramon-becker-da-silva-96b81b141//)
![Gmail Badge](https://img.shields.io/badge/-ramonbecker68@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:ramonbecker68@gmail.com)
