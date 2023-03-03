package task_1;

import task_1.src_code.game.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Дописать адаптеры для бассейна
// Придумать собственный тип препятствий
public class CompetitionOverride {


    public static void main(String[] args) {
        Obstacle[] obstacles = createObstacles();
        Participant[] participants = createParticipants();
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                // participant.overcome(obstacle)
                // obstacle.pass(participant)
                boolean result = obstacle.pass(participant);
                if (result) {
                    System.out.println("Участник #" + participant.getName() + " преодолел препятствие " + obstacle.getClass().getSimpleName());
                } else {
                    System.out.println("Участник #" + participant.getName() + " НЕ преодолел препятствие " + obstacle.getClass().getSimpleName());
                }
            }
        }

    }

    public static Participant[] createParticipants() {
        Participant[] oldPersons = CompetitionGameMain.createParticipants();

        ArrayList<BaseParticepentNewRules> persons = new ArrayList<>();
        for (Participant oldPerson : oldPersons) {
            BaseParticepentNewRules newPerson = new BaseParticepentNewRules(oldPerson,
                    ThreadLocalRandom.current().nextInt(5, 20));
            persons.add(newPerson);
        }


        return persons.toArray(Participant[]::new);
    }


    static class BaseParticepentNewRules extends BaseParticipant implements Participant, ParticipantNewAge {
        private final int canInsufflate;

        public BaseParticepentNewRules(String name, int jump, int run, int swim, int canInsufflate) {
            super(name, jump, run, swim);
            this.canInsufflate = canInsufflate;
        }

        public BaseParticepentNewRules(Participant participant, int canInsufflate) {
            super(participant.getName(), participant.getJump(), participant.getRun(), participant.getSwim());
            this.canInsufflate = canInsufflate;
        }

        @Override
        public int getInsufflateAbility() {
            return this.canInsufflate;
        }
    }


    private static Obstacle[] createObstacles() {
        return new Obstacle[]{
                new WallObstacleAdapter(new Wall(40)),
                new RoadObstacleAdapter(new Road(100)),
                new RoadObstacleAdapter(new Road(45)),
                new SwimmingPoolObstacleAdapter(new SwimmingPoolAdaptVersion(20)),
                new PushAirIntoTubeObstacle(10)};
    }


    static class SwimmingPoolAdaptVersion extends SwimmingPoll {
        public SwimmingPoolAdaptVersion(int distance) {
            super(distance);
        }

        public boolean pass(CanSwim canSwim) {
            return canSwim.getSwim() >= super.distance;
        }
    }

    public static class SwimmingPoolObstacleAdapter implements Obstacle {

        private final SwimmingPoolAdaptVersion swimmingPoll;

        public SwimmingPoolObstacleAdapter(SwimmingPoolAdaptVersion swimmingPoll) {
            this.swimmingPoll = swimmingPoll;
        }

        public boolean pass(Participant participant) {
            return swimmingPoll.pass((CanSwim) participant);
        }
    }


    static class PushAirIntoTubeObstacle implements Obstacle {
        protected final int secsInsufflate;

        public PushAirIntoTubeObstacle(int secsInsufflate) {
            this.secsInsufflate = secsInsufflate;
        }

        @Override
        public boolean pass(Participant participant) {
            ParticipantNewAge newRules = (ParticipantNewAge) participant;

            return newRules.getInsufflateAbility() >= secsInsufflate;
        }
    }

    interface ParticipantNewAge extends Participant, CanInsufflate {
    }

    public interface CanInsufflate {
        int getInsufflateAbility();
    }
}
