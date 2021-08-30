package xin.shouqian;

public class PlayRobot extends RobotDecorator{
    public PlayRobot(Robot robot) {
        super(robot);
    }

    @Override
    public void job() {
        super.job();
        System.out.println("动态添加的机器人玩耍行为");
    }
}
