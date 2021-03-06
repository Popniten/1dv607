# Workshop 2 - Design

By Pär Eriksson (pe222gq) and Oskar Emilsson (oe222ca).

## Instructions

### Project structure

The `application` folder contains the source code for the application and the `release` folder contains the built application.

### Running the application

Download the files in the `release` folder or [this zip](MemberRegistry-1.1.tar.gz). Use a terminal or command prompt and navigate to where to stored/unzipped them and run the jar-file:

``` bash
$ java -jar MemberRegistry.jar
```

Enjoy!

## Grade 2 - Submission 1

### Diagrams

#### UML class diagram

![UML Class Diagram](WS2-ClassDiagram-FirstSubmission.png)

#### Input Sequence diagrams - Register Member

![Register Member](WS2-RegisterMember.png)

#### Output Sequence diagrams - View Member

![View Member](WS2-ViewMember.png)

## Grade 2 - Final Submission

We decided to update our Database model, as pointed out by one peer review. There was alot of duplicated SQL strings there, and the update also removed dependancies between `Database` and the `Member` and `Boat` models.

We also updated the sequence diagrams to this new `Database` API.

### Diagrams

#### UML class diagram

![UML Class Diagram](WS2-ClassDiagram-FinalSubmission.png)

#### Input Sequence diagrams - Register Member

![Register Member](WS2-RegisterMemberFinal.png)

#### Output Sequence diagrams - View Member

![View Member](WS2-ViewMemberFinal.png)


