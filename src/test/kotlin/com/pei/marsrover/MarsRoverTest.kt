package com.pei.marsrover

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class MarsRoverTest {
    @Test
    fun shouldThrowValidationError_GivenInvalidCommand() {
        val marsrover = MarsRover(Position(1, 2, Direction.NORTH))
        assertThatThrownBy({ marsrover.execute("21tL") })
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("invalid commands")
    }

    @Test
    fun shouldReturn13W_givenPosition11N_whenRunCommandMMLLR() {
        val marsRover = MarsRover(Position(1, 1, Direction.NORTH))

        assertThat(marsRover.execute("MMLLR")).isEqualTo(Position(1, 3, Direction.WEST))
    }

    @Test
    fun shouldReturn15W_givenPostion11N_whenRunCommandMMMMMMLLR() {
        val marsRover = MarsRover(Position(1, 1, Direction.NORTH))

        assertThat(marsRover.execute("MMMMMMLLR")).isEqualTo(Position(1, 5, Direction.WEST))
    }

    @Test
    fun shouldReturnLiveFalse_givenPosition33N_whenDoInvestigate() {
        var mockInvestigateService = mockk<InvestigateService>()
        val marsRover = MarsRover(Position(1, 1, Direction.NORTH),
                investigateService = mockInvestigateService)
        every { mockInvestigateService.doInvestigate(any()) }.returns(InvestigateService.Result.SUCCESS)

        marsRover.investigate()

        assertThat(marsRover.live).isFalse()
    }
}
