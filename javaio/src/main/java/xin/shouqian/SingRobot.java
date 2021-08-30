package xin.shouqian;

public class SingRobot extends RobotDecorator{

    public SingRobot(Robot robot) {
        super(robot);
    }

    @Override
    public void job() {
        super.job();
        System.out.println("动态添加的机器人唱歌行为");
    }
}
