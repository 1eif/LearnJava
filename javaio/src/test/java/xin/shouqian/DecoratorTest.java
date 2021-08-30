package xin.shouqian;

import org.junit.Test;

public class DecoratorTest {

    @Test
    public void test() {
        SimpleRobot simpleRobot = new SimpleRobot();
        SingRobot singRobot = new SingRobot(simpleRobot);

        singRobot.job();

        System.out.println("-----------------------------");

        PlayRobot playRobot = new PlayRobot(simpleRobot);
        playRobot.job();

        System.out.println("-----------------------------");

        PlayRobot playRobot1 = new PlayRobot(singRobot);
        playRobot1.job();
    }
}
