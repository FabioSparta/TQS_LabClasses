# Exercise 3 - Using Project from IES (RoomsScanner)

--> Project key: Projeto_IES
--> Project token name: IES
--> Project token value: c005ae7c8e7f5880a55b1b6514080a4edea13f6d

--> Run : mvn clean verify sonar:sonar  -Dsonar.projectKey=Projeto_IES -Dsonar.login=c005ae7c8e7f5880a55b1b6514080a4edea13f6d -Dsonar.host.url=http://localhost:9001 

## 3a) See SonarQube_beforeBreaking.PNG  and QualityGate.PNG 
    Based on SonarQube's first evaluation of our project we had:
        -> 1 Bug
        -> 8 Vulnerabilities
        -> 9 Security Hotspots
        -> 96 Code Smells
        -> 0 Duplicated blocks on 1.3k lines
        -> 1d 2h Debt
        
    Note - Most of the code smells were of following type:
        -> Rename this package name to match the regular expression '^[a-z_]+(\.[a-z_][a-z0-9_]*)*$'
        -> This block of commented-out lines of code should be removed
        -> Replace this use of System.out or System.err by a logger.
        -> Remove this unused import 'ies.p1.rooms_scanner.(<some class>))'.

    Quality Gate Conditions:
        ->(1)Coverage	is less than	0.0%
        ->(2)Duplicated Blocks	is greater than	0
        ->(3)Bugs	is greater than	3
        ->(4)Code Smells	is greater than	100
        ->(5)Major Issues	is greater than	40
        ->(6)Vulnerabilities	is greater than	10
        ->(7)Security Hotspots Reviewed	is less than	0.0%
    Reasons:
        ->(1) During IES Project tests were not meant to be implemented, so a coverage of 0% is acceptable given this specific project's objetives
        ->(2) Duplicated code is unnecessary and we had 0 anyway, so might has well keep the quality gate's for the new code at 0.
        ->(3) Bugs are usually not that hard to fix if the programmer periodically checks SonarQube's evaluation or even better, uses a static code analysis tool to help him in real time. So might has well keep the quantity of allowed bugs low.
        ->(4) We had 96 code smells and given the objetive of the following exercise (3b) we plan to break the quality gate by making this value rise to above 100
        ->(5) Given that this is a big project, 40 souded like a reasonable value
        ->(6) We did not implement any security measures so having around 8 to 10 vulnabilities is expected
        ->(7) Since we did not implement any security, coverage of 0.0% on this area is expected

## 3b) See SonarQube_afterBreaking.PNG
    To break the quality gate we addedd a few more System.out.println() lines that are considered Major issues.
    Such resulted in the code smells quantity reaching 101, which is higher than our established limit of 100.