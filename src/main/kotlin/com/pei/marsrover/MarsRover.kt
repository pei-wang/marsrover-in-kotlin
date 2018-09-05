package com.pei.marsrover

data class Position(val x: Int, val y: Int, val direction: Direction)

data class Map(val x: Int, val y: Int)

class MarsRover(var position: Position, val map: Map = Map(5, 5),
                var investigateService: InvestigateService = WaterInvestigateService()) {

    var live: Boolean = true

    fun execute(commands: String): Position {
        validate(commands)
        commands.split("").forEach {
            this.position = when (it) {
                "L" -> this.turnLeft()
                "R" -> this.turnRight()
                "M" -> this.move()
                else -> {
                    this.position
                }
            }
        }
        return this.position
    }

    fun investigate() {
        live = investigateService.doInvestigate(this.position) != InvestigateService.Result.SUCCESS
    }

    private fun validate(commands: String) {
        if (!"[L|R|M]+".toRegex().matches(commands)) {
            throw IllegalArgumentException("invalid commands")
        }
    }

    private fun turnRight(): Position {
        return this.position.copy(direction = this.position.direction.turnRight())
    }

    private fun turnLeft(): Position {
        return this.position.copy(direction = this.position.direction.turnLeft())
    }

    private fun move(): Position {
        return when (position.direction) {
            Direction.NORTH -> {
                if (this.position.y + 1 > map.y)
                    return this.position
                this.position.copy(y = this.position.y + 1)
            }
            Direction.EAST -> {
                if (this.position.x + 1 > map.x)
                    return this.position
                this.position.copy(x = this.position.x + 1)
            }
            Direction.WEST -> {
                if (this.position.x - 1 < 0) {
                    return this.position
                }
                this.position.copy(x = this.position.x - 1)
            }
            Direction.SOUTH -> {
                if (this.position.y - 1 < 0) {
                    return this.position
                }
                this.position.copy(y = this.position.y - 1)
            }
        }
    }
}