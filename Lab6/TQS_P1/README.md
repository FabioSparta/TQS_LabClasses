# Evidence

## Task 1: Analyze an existing project
    To run SonarQube in Windows:
        1. Open Docker App
        2. On windowds cmd:  wsl docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9001:9000 sonarqube:latest
    Password used (reminder): tqs_lab6
    Project Key/Display Name: TQS_P1
    Token_name              : token_p1 
    Command: mvn clean verify sonar:sonar  -Dsonar.projectKey=TQS_P1 -Dsonar.login=d3d1bbe33b0f9736f36e37049ae85cf458073b8f -Dsonar.host.url=http://localhost:9001
    
    1e) Has your project passed the defined quality gate?

    According to SonarQube's evaluation:
    
        -1 Bug was found in Dip.java:
            _Problem Description : Creating a random object everytime a random number is needed is inefficient and may produce numbers that are not random depending on the JDK. 
            _How to Solve : The code should be improved to create only a single random object that can be re-used whenever random numbers are needed.)

        -24 Code Smells were found (bad practices):
            In Dip.java 2 Major code smells were found:
                _Problem Description: A 'for loop' stop condition should test the loop counter against an invariant value (i.e. one that is true at both the beginning and ending of every loop iteration). Ideally, this means that the stop condition is set to a local variable just before the loop begins.
                _How to Solve: In this case, we can change the 'for loop' to a 'while loop' that will continue until the quantity of numbers is 5 and the quantity of stars is 2. The usage of a for loop with a variable (that is incremented : i++) is unnecessary.  

            In DemoMain.java 7 Major smells were found:
                _Problem Description: a Logger should be used instead of System.out or System.err
                _How to Solve: Replace all System.out and System.err for Loggers       

        -1 Security HotSpot in Dip.java:
            The possible problem here is related to 'weak cryptography' because of the use of a pseudorandom number generater (math.Random()).
            Our objective in Dip.java is not related to cryptography, but SonarQube is warning us that if our random numbers are involved in the protection of sentitive data, we should use java.security.SecureRandom for more unpredictable, and so,  safer values.  

## Task 2: Manage Technical Debt

## Task 3: Define and apply quality gates