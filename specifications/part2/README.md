# Project specifications, Part 2

## Introduction

At the end of the previous phase, you have reached a point where you have a simple and generic "Software-as-a-Service" platform. External developers can create an account on your platform. They can manage their applications, which have end-users. You have a web UI that allows you to browse through all these elements. Until now, you have not really had to deal with the gamification aspects of the project.

The objective of the second part of the project is to design, implement and validate the core gamification engine that you will integrate in your project. The goal of this engine is pretty simple: 

* on one side, it will receive a stream of events from all gamified applications. These events will capture what the end-users are actually doing in the applications. If you think about stackoverflow.com, the events could be "this user has asked a question" or "that user has answered a question". Depending on the application, there will be different types of events and every type of event will have its own attributes.

* the engine has to process this stream of events and, based on a number of rules, has to continuously update the state of end-users. What we mean by "state" will depend on your ideas and on the richness of the gamification platform. But if we take the common example of awarding badges when users achieve certain goals, then the state of a user could be the list of badges that have been awarded so far.

* on the other side, the gamification engine should make the state of end-users available to the application developers, so that they can fetch the information and display it in their web UI. Coming back to the example of stackoverflow.com, you see a lot of gamification widgets on their web site, but the actual data might very well be managed by your engine.



## Specification and Design Process

We will not give you a complete and detailed specification (i.e. the specification of a REST API) at the beginning of this phase. Instead, we will design it together, week by week. We want to see regular progress and we will ask for interim presentations and reports. Here is the high-level planning for the phase:

Week | Date | Goals and activities
------|------------------------------
1 | 06.11.2015 | Specification of the gamification features; first design of the domain model and of the REST APIs
2 | 13.11.2015 | Design of the event stream processing service; implementation of the REST APIs; definition of the demonstration strategy
3 | 20.11.2015 | Implementation of the event stream processing and of the REST APIs; implementation of the demonstration strategy; definition of validation strategy
4 | 27.11.2015 | Implementation of the system and of the validation strategy
5 | 04.12.2015 | Validation and documentation


## Expectations

1. We expect you to design and implement the support for **3 different gamification features**. By gamification feature, you can think about a widget that would be displayed in the gamified application UI and that would present some information. During the first week, you will think about what you could implement and make your choice. Advice: keep it simple (don't try to come up with too complex ideas; you will have an opportunity to do more advanced and original stuff in the third and last project phase).

2. We expect you to implement a **REST API**, which the developers of gamified applications will use to **report user activity**. The API keys that you have implemented in the first project phase should be used for security purposes (to make sure that only the authorized client can post events).

3. We expect you to implement a **series of REST API endpoints** to make the information managed by your engine available to gamified applications. For instance, if you decide that one of your gamification feature is the support for badges, then there should be a REST API endpoint to retrieve the badges awarded to a given end-user.

4. We expect you to implement an **event processing service**, which will analyze every incoming event and decide how the end-user state should be updated. This is certainly the most challenging part of the project, since you would like to make it flexible (allowing the application developers to dynamically add rules). But given the time constraints, you will have to design something quite simple in this first phase (the idea is that you will iterate during the 3rd project phase). 

5. We expect you to define and implement a **testing and validation strategy**. You should think about what are the most appropriate ways to validate that the engine is behaving as expected (e.g. there are no lost events, the end-user state is correctly updated, the stats are computed correctly, etc.). 

6. We expect you to define and implement a **demonstration strategy**. At the end of the phase, we will ask each group to do a demonstration of the system. You have to think about how you will do this demo (it must be interactive, so that the audience sees your gamification features in action; you must have a way to simulate the activities of end-users and to generate events; etc.).


## Evaluation

The evaluation will consider all of the previously listed expectations. We will examine both the approach you take (especially for the validation), the code that you write, the documentation that you provide and your regularity in delivering the functionality.

