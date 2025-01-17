package racingcar.view.output

import racingcar.dto.RacingRecord

class OutputConsole : Output {
    override fun numberOfCarsNames(): Unit = println(CAR_NAMES_INPUT_MESSAGE)
    override fun numberOfCarsMessage(): Unit = println(NUMBER_OF_CARS_INPUT_MESSAGE)
    override fun finalLab(): Unit = println(TRY_TIMES_OF_RACE_INPUT_MESSAGE)
    override fun errorMessage(message: String) = println(message)
    override fun racingRecords(racingRecords: List<RacingRecord>) {
        racingRecords.forEach { racingRecord ->
            print("${racingRecord.name} : ")
            racingDistance(racingRecord.racingDistance)
        }
        println()
    }

    override fun winnersNames(gameWinnersNames: List<String>) {
        println("'${gameWinnersNames.joinToString(", ")}' 우승했습니다.")
    }

    private fun racingDistance(racingDistance: Int) {
        repeat((START_POSITION..racingDistance).count()) {
            print(CAR_POSITION_MARK)
        }
        println()
    }

    companion object {
        private const val CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분)"
        private const val NUMBER_OF_CARS_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val TRY_TIMES_OF_RACE_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val CAR_POSITION_MARK = "-"
        private const val START_POSITION = 1
    }
}
