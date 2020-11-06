package com.github.polyKA.kawasakiControlLibrary.commands

enum class MoveCommand(val command: String) {
    MOVE_BY_COORDINATE( "MOVE;BASE;"),

    CLOSE_GRIPPER( "SERVICE;CLAMP;OFF"),
    OPEN_GRIPPER( "SERVICE;CLAMP;ON"),

    MOVE_TO_POINT( "MOVETO;"),
}