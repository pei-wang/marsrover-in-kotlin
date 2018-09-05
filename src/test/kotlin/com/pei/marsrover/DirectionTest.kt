package com.pei.marsrover

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DirectionTest {

    @Test
    fun turnLeft() {
        val direction = Direction.SOUTH
        assertThat(direction.turnLeft()).isEqualTo(Direction.EAST)
    }

    @Test
    fun turnRight() {
        val direction = Direction.SOUTH
        assertThat(direction.turnRight()).isEqualTo(Direction.WEST)
    }
}