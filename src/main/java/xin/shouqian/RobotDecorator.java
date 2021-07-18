package xin.shouqian;

// abstract抽象类不能被new
public abstract class RobotDecorator implements Robot {

    private Robot target;

    public RobotDecorator(Robot robot) {
        this.target = robot;
    }

    @Override
    public void job() {
        target.job();
    }
}
