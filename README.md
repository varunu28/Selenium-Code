# Selenium-Java
Code for various tasks on Selenium framework using Java

## Install hub in host machine 
```
java -jar selenium-server-standalone-3.12.0.jar -role hub
```

## Set up node in another machine. Check if Java is properly configured
``` 
java -Dwebdriver.chrome.driver="<path to chrome driver>" -jar selenium-server-standalone-3.12.0.jar -role webdriver -hub http://172.17.0.1:4444/grid/register -port 5566
```