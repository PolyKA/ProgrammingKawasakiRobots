//package ru.art241111.programmingkawasakirobots
//
//import com.github.poluka.kControlLibrary.KRobot
//import com.github.poluka.kControlLibrary.actions.annotation.ExecutedOnTheRobot
//import com.github.poluka.kControlLibrary.actions.move.MoveToPoint
//import com.github.poluka.kControlLibrary.dsl.kProgram
//import com.github.poluka.kControlLibrary.enity.Coordinate
//import com.github.poluka.kControlLibrary.enity.TypeOfMovement
//import com.github.poluka.kControlLibrary.enity.position.Position
//
//class ThirdProblem(private val robot: KRobot) {
//    private val blockHeight = 25.0
//
//    fun move() {
//        val home = MoveToPoint(TypeOfMovement.LMOVE, robot.homePosition)
//        val takePoint = Position(-320.0,650.0,-270.0,90.0,180.0,0.0)
//        val putPoint = Position(170.0,540.0,-270.0,90.0,180.0,0.0)
//        val blockLength = 75.0
//        val d = (blockLength - 10) / 2
//
//        robot.run(kProgram {
//            for (i in 0..10){
//                add(takeAndPut(takePoint, putPoint, dx = d, dz = i*blockHeight))
//                add(takeAndPut(takePoint, putPoint, dx = -d, dz = i*blockHeight ))
//                add(takeAndPut(takePoint, putPoint, angle = 90.0, dy = d, dz = i*blockHeight))
//                add(takeAndPut(takePoint, putPoint, angle = 90.0,dy = -d, dz = i*blockHeight))
//            }
//            add(home)
//        })
//    }
//
//    @ExecutedOnTheRobot
//    private fun takeAndPut(takePosition: Position, putPosition: Position, angle: Double = 0.0,
//                           dx: Double = 0.0, dy: Double = 0.0, dz: Double = 0.0) = kProgram {
//        add(takeBlock(takePosition))
//        add(putBlock(putPosition, dx = dx,dy = dy, dz = dz, angle = angle))
//    }
//
//    @ExecutedOnTheRobot
//    private fun takeBlock(takePosition: Position) = kProgram {
//        departPoint(position = takePosition, dZ = 100.0)
//        moveByCoordinate(Coordinate.Z, -100.0)
//        closeGripper()
//        delay(2000L)
//        moveByCoordinate(Coordinate.Z, 100.0)
//    }
//
//    @ExecutedOnTheRobot
//    private fun putBlock(putPosition: Position, angle: Double = 0.0,
//                         dx: Double = 0.0, dy: Double = 0.0, dz: Double = 0.0) = kProgram {
//        departPoint(position = putPosition,dX = dx, dY = dy,  dZ = 100.0 + dz, dT = angle)
//        moveByCoordinate(Coordinate.Z, -100.0)
//        openGripper()
//        delay(2000L)
//        moveByCoordinate(Coordinate.Z, blockHeight + 5)
//        moveByCoordinate(Coordinate.X, -100.0)
//    }
//}