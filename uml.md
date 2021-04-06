# Toolshop Project - ENSF 607/608
UML diagram name: Avtex - 2048 Game
<br>
Created by: Patrick Linang
<br>
Date: April 5, 2021


## UML Diagram for server
![My UML](uml.png)

Note that Constants, RandomGenerators, and Move implementations have use dependencies with other models in the server

### PlantUML code
```plantuml
@startuml
skinparam classAttributeIconSize 0
hide members

package server {
    package servercontroller {
        class ServerController
        class ModelController
    }

    package servermodel {
        class Board

        class GameManager


        class Game


        abstract class Move

        class LeftMove extends Move
        class UpMove extends Move
        class RightMove extends Move
        class DownMove extends Move

        interface Constants
        class RandomGenerator
    }
}

package client {
    class SimpleClient
}

ServerController - SimpleClient
ServerController *-- ModelController
Game --o ModelController
ModelController o-- GameManager
Game o-- Board
GameManager -- Board

hide members
@enduml
```