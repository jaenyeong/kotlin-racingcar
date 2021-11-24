package racingcar.domain

import racingcar.communication.output.Output
import racingcar.communication.output.OutputConsole
import racingcar.domain.cars.Cars
import racingcar.domain.engine.Engine
import racingcar.domain.racing.FinalLab
import racingcar.dto.RacingRecord

class RacingGame(
    private val output: Output = OutputConsole(),
) {
    fun start(
        racingCars: Cars,
        finalLab: FinalLab = FinalLab(value = 1),
        engine: Engine
    ) = runCatching {
        race(racingCars, finalLab, engine)
    }.onFailure {
        output.errorMessage(it.message ?: RACING_GAME_ERROR_MESSAGE)
    }

    fun race(cars: Cars, finalLab: FinalLab, engine: Engine) {
        repeat((finalLab.value)) {
            cars.races(engine)
            output.racingCarNameAndRecord(cars.mapCarList().map { RacingRecord(it) })
        }
    }

    companion object {
        private const val STARTING_NUMBER_OF_RACING_CARS = 1
        private const val RACING_GAME_ERROR_MESSAGE = "[ERROR] : error occurred while the racing game"
    }
}
