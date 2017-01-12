package zhjch_1;
import battlecode.common.*;

/**
 * Created by jinchengzhang on 1/12/17.
 */
public class BotSoldier extends Globals {

    public static void loop(RobotController theRC) throws GameActionException {
        System.out.println("I'm an soldier!");
        init(theRC);

        while(true){
            // Try/catch blocks stop unhandled exceptions, which cause your robot to explode
            try {
                MapLocation myLocation = rc.getLocation();

                // See if there are any nearby enemy robots
                RobotInfo[] robots = rc.senseNearbyRobots(-1, enemy);

                // If there are some...
                if (robots.length > 0) {
                    // And we have enough bullets, and haven't attacked yet this turn...
                    if (rc.canFireSingleShot()) {
                        // ...Then fire a bullet in the direction of the enemy.
                        rc.fireSingleShot(rc.getLocation().directionTo(robots[0].location));
                    }
                    tryMove(new Direction(rc.getLocation(), robots[0].location));
                    Clock.yield();
                }

                // Move randomly
                tryMove(randomDirection());

                // Clock.yield() makes the robot wait until the next turn, then it will perform this loop again
                Clock.yield();

            } catch (Exception e) {
                System.out.println("Soldier Exception");
                e.printStackTrace();
            }
        }
    }
}
