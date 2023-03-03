package task_1.src_code.game;

public class SwimmingPoll implements Obstacle {

    protected final int distance;

    public SwimmingPoll(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean pass(Participant participant) {
        return participant.getSwim() >= distance;
    }
}
