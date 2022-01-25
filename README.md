
![Image Banner](baner.gif)
# Iterated Prisoner's Dilemma with one-step memory

The project undertakes the analysis of the iterated prisoner's dilemma with single-step memory. The main task is to create 32 strategies and then play a tournament where each strategy will compete against each other for 10 rounds. I will then analyze the data obtained and answer three questions: how do the polite strategies (those that start with C) perform? How do strategies that respond to an opponent's betrayal in the past perform? and how do those that respond to betrayal with cooperation perform?

Author:
- [Maksymilan Jackowski](https://github.com/makjac)

## Introduction

Imagine two people being interrogated. Both interrogators are suspected of committing some crime. There comes a moment when the detective asks them a question: who did the crime? Każdy przesłuchiwany ma do wyboru 2 opcje: pierwsza (współpraca), może się nie przyznać i milczeć na zadane mu pytanie, lub drufa obcja (wada) może zrzucić winę na przeciwnika. Each interrogator does not know what decision his opponent will make.

There are four possibilities for the interrogation to end:

- The player co-opts as his opponent does. Then both will get a 2-year prison sentence,

- The player cooperates, but his opponent betrays. The player is sentenced to 10 years in prison, and the opponent goes free immediately,

- the player betrays and his opponent cooperates. Then the player immediately goes free, and his opponent is sentenced to 10 years in prison,

- both cheat. As a result, both are sentenced to 5 years in prison.

![Image 1](img1.png)

This is a single prisoner's dilemma problem. In its iterated variant, players play several such dilemmas, and their final score is the sum of years earned for all rounds played. The more years of imprisonment obtained the worse.




## One-step memory
## Screenshots
![Image 2](HitMapColors.png)
![Image 3](generationfrom0to100.gif)
![Image 4](IPD.svg)