### System Requirement ###
Make sure you are running this on system having JAVA and JAVA_HOME set to jdk 1.8.x
Make sure you have apache maven installed

### Build ###
Run "mvn clean install" to run tests and create jar 

### Test ###
Run "mvn test"

### Run Application ###
java -jar java -jar target\battleship-0.0.1-SNAPSHOT.jar "location to input text file"
e.g. java -jar target\battleship-0.0.1-SNAPSHOT.jar C:\Users\username\Desktop\input.txt

### Run manually ###
RUN class BattleShipGameRunner with arg "location to input text file"