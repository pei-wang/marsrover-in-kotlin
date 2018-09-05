package com.pei.marsrover

enum class Direction {
    NORTH, EAST, SOUTH, WEST;

    fun turnLeft(): Direction {
        return Direction.values()[(this.ordinal + 3) % 4]
    }

    fun turnRight(): Direction {
        return Direction.values()[(this.ordinal + 1) % 4]
    }
}