package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private final StringBuilder forwardState;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름이 5자 이하가 아닙니다.");
        }

        this.name = name;
        this.forwardState = new StringBuilder();
    }

    public void tryForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) forwardState.append('-');
    }

    public String getName() {
        return name;
    }

    public StringBuilder getForwardState() {
        return forwardState;
    }

}
