# CS440_NFL_App
Database application for NFL stats'

Instructions to set up mySql database
1. Open and execute the sql file on your local instance MySql80 server
2. Take note of your root password because you will need it for the application to connect 

Instructions to set up project:

1. Unzip Project File and Open up Project in Intellij
2. Select in the top left corner file -> project structure -> project and download and select corretto-21 as the SDK
3. It should pop up in the bottom right to load maven dependencies. Click on that
4. In the top right now click add new configuration and click Maven.
5. In the command line type in spring-boot:run and hit OK
6. Before running the project go into src/main/java/com.example.CS440_Application/util and click into te DatabaseConnectionManager
7. For the mySQL database to work, edit the password String to be your root password for local instance MySQL80.
6. Click run and go to localhost:8080/home to gain access to our website


