package com.github.polyKA.kawasakiControlLibrary.commands

enum class MoveCommand(val command: String) {
    MOVE_BY_X( "MOVE;BASE;1;"),
    MOVE_BY_Y( "MOVE;BASE;2;"),
    MOVE_BY_Z( "MOVE;BASE;3;"),
    MOVE_BY_DX( "MOVE;BASE;4;"),
    MOVE_BY_DY( "MOVE;BASE;5;"),
    MOVE_BY_DZ( "MOVE;BASE;6;"),

    CLOSE_GRIPPER( "SERVICE;CLAMP;OFF"),
    OPEN_GRIPPER( "SERVICE;CLAMP;ON"),

    MOVE_TO_POINT( "MOVETO;"),
}