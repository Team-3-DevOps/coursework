## World Population Project
- First of all, here you can generate four kind of reports which concern about City, Country, Capital and Population.
- First three reports are about rankings by descending population values and last report for accessibiltiy and language criteria. 

### Prerequisites
* IntelliJ IDEA [Get here!](https://www.jetbrains.com/)
* DOCKER [Get here!](https://hub.docker.com/)
* MYSQL [Get here!](https://dev.mysql.com/downloads/installer/)
* JAVA:latest [Get here!](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
* Git for version control [Get here!](https://git-scm.com/downloads)
* Travis for continous integration [Visit there!](https://travis-ci.com/)
* (codecov.io) for code coverage and testing [What is it?](https://codecov.io/)

### How to run? Just follow below instructions properly!
### Database Setup
* Firstly, make sure docker connected with your IntelliJ IDEA and Got to the image section of docker
* Right click on that and pull world database by name of "kevinchalmers/world"
* Once it is done downloading, right click on that downloaded image and choose 'create container' and click "Create"
* At the pop-up dialog box, put this (**-e MYSQL_ROOT_PASSWORD=t3devops -p 33060:3306**) at __run options box__. 
* Then click "Apply and Run" and wait for the database ready for connection. 

### Maven Process
* IntelliJ can detect maven plugins. You can found it at the right top conor of IDEA. if you don't, not a problem.
* So, once you have cloned the whole project, IntelliJ will ask you to enable auto-import maven module.
* Now, You can see Maven panel at this point.

### Building the project
* Run Maven Build at maven panel by clicking green arrow button. 
* Then scroll down **Lifecycle** and **compile project** and the last run **package** to packaging your app. 
* At this point, your project **jar** file should be generated at target folder within your project folder
* ({Driveletter}:\{$foldername}\coursework\target>coursework.jar) 

### Run the project 
* Open your **cmd** as an administrator  
* Change your working directory to this **{Driveletter}:\{$foldername}\{$projectname}\target\**
* Run ***coursework.jar*** file by executing this command ***java -jar coursework.jar***


***ENJOY then, BEST OF LUCK. PEACE OUT!!!***


### Software Engineering Methods

- Master Build Status [![Build Status](https://travis-ci.com/Team-3-DevOps/coursework.svg?branch=master)](https://travis-ci.com/Team-3-DevOps/coursework)
- Develop Build Status [![Build Status](https://travis-ci.com/Team-3-DevOps/coursework.svg?branch=master)](https://travis-ci.com/Team-3-DevOps/coursework)
- Code Coverage of tests for Master [![Codecov branch](https://img.shields.io/codecov/c/github/Team-3-DevOps/coursework/master?style=plastic&logo=Codecov)](https://img.shields.io/codecov/c/github/Team-3-DevOps/coursework)
- License [![LICENSE](https://img.shields.io/github/license/Team-3-DevOps/coursework.svg?)](https://github.com/Team-3-DevOps/coursework/blob/master/LICENSE)
- Release [![Releases](https://img.shields.io/github/release/Team-3-DevOps/coursework/all.svg?style=plastic)](https://github.com/Team-3-DevOps/coursework/releases)
