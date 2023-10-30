package racingcar.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingGame {

    private final GameManager manager;

    public RacingGame() {
        this.manager = new GameManager();
    }

    public void run() {
        setUp();
        race();
        announceWinner();
    }

    private void setUp() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        manager.setCars(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        String round = Console.readLine();
        manager.setRound(round);
    }

    private void race() {
        System.out.println("실행 결과");

        while (manager.getSettingRound() >= manager.upCurrentRound()) {
            List<String> carsState = manager.raceOneRound();
            printCarsState(carsState);
        }
    }

    private void announceWinner() {
        List<String> winnerList = manager.findWinners();
        printWinners(winnerList);
    }

    private void printCarsState(List<String> racingState) {
        for (String carState : racingState) {
            System.out.println(carState);
        }
        System.out.println();
    }

    private void printWinners(List<String> winnerList) {
        String winners = String.join(", ", winnerList);
        System.out.print("최종 우승자 : " + winners);
    }
}