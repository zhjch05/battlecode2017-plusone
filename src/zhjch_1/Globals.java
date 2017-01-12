package zhjch_1;
import battlecode.common.*;

/**
 * Created by jinchengzhang on 1/11/17.
 */
public class Globals {

    public static final int RUNTIME_MS_QUEUE = 12;

    public static final int OUR_ARC_1_LOC_X = 0;
    public static final int OUR_ARC_1_LOC_Y = 1;
    public static final int OUR_ARC_2_LOC_X = 2;
    public static final int OUR_ARC_2_LOC_Y = 3;
    public static final int OUR_ARC_3_LOC_X = 4;
    public static final int OUR_ARC_3_LOC_Y = 5;

    public static final int THEIR_ARC_1_LOC_X = 6;
    public static final int THEIR_ARC_1_LOC_Y = 7;
    public static final int THEIR_ARC_2_LOC_X = 8;
    public static final int THEIR_ARC_2_LOC_Y = 9;
    public static final int THEIR_ARC_3_LOC_X = 10;
    public static final int THEIR_ARC_3_LOC_Y = 11;

    public static RobotController rc;
    public static MapLocation myLoc;
    public static Team us;
    public static Team enemy;
    public static int myID;
    public static RobotType myType;

    public static int roundNum;

    public static int numberOfInitialArchon;

    public static MapLocation[] ourInitialArchonLocations;
    public static MapLocation[] theirInitialArchonLocations;

    public static void init(RobotController theRC){
        rc = theRC;
        us = rc.getTeam();
        enemy = us.opponent();
        myID = rc.getID();
        myType = rc.getType();
        myLoc = rc.getLocation();
        ourInitialArchonLocations = rc.getInitialArchonLocations(us);
        theirInitialArchonLocations = rc.getInitialArchonLocations(enemy);
        numberOfInitialArchon = ourInitialArchonLocations.length;
    }














    //--------------------------------------------------------------------------------------------------------------
    //following copied from example func player




    /**
     * Returns a random Direction
     * @return a random Direction
     */
    static Direction randomDirection() {
        return new Direction((float)Math.random() * 2 * (float)Math.PI);
    }

    /**
     * Attempts to move in a given direction, while avoiding small obstacles directly in the path.
     *
     * @param dir The intended direction of movement
     * @return true if a move was performed
     * @throws GameActionException
     */
    static boolean tryMove(Direction dir) throws GameActionException {
        return tryMove(dir,20,3);
    }

    /**
     * Attempts to move in a given direction, while avoiding small obstacles direction in the path.
     *
     * @param dir The intended direction of movement
     * @param degreeOffset Spacing between checked directions (degrees)
     * @param checksPerSide Number of extra directions checked on each side, if intended direction was unavailable
     * @return true if a move was performed
     * @throws GameActionException
     */
    static boolean tryMove(Direction dir, float degreeOffset, int checksPerSide) throws GameActionException {

        // First, try intended direction
        if (rc.canMove(dir)) {
            rc.move(dir);
            return true;
        }

        // Now try a bunch of similar angles
        boolean moved = false;
        int currentCheck = 1;

        while(currentCheck<=checksPerSide) {
            // Try the offset of the left side
            if(rc.canMove(dir.rotateLeftDegrees(degreeOffset*currentCheck))) {
                rc.move(dir.rotateLeftDegrees(degreeOffset*currentCheck));
                return true;
            }
            // Try the offset on the right side
            if(rc.canMove(dir.rotateRightDegrees(degreeOffset*currentCheck))) {
                rc.move(dir.rotateRightDegrees(degreeOffset*currentCheck));
                return true;
            }
            // No move performed, try slightly further
            currentCheck++;
        }

        // A move never happened, so return false.
        return false;
    }

    /**
     * A slightly more complicated example function, this returns true if the given bullet is on a collision
     * course with the current robot. Doesn't take into account objects between the bullet and this robot.
     *
     * @param bullet The bullet in question
     * @return True if the line of the bullet's path intersects with this robot's current position.
     */
    static boolean willCollideWithMe(BulletInfo bullet) {
        MapLocation myLocation = rc.getLocation();

        // Get relevant bullet information
        Direction propagationDirection = bullet.dir;
        MapLocation bulletLocation = bullet.location;

        // Calculate bullet relations to this robot
        Direction directionToRobot = bulletLocation.directionTo(myLocation);
        float distToRobot = bulletLocation.distanceTo(myLocation);
        float theta = propagationDirection.radiansBetween(directionToRobot);

        // If theta > 90 degrees, then the bullet is traveling away from us and we can break early
        if (Math.abs(theta) > Math.PI/2) {
            return false;
        }

        // distToRobot is our hypotenuse, theta is our angle, and we want to know this length of the opposite leg.
        // This is the distance of a line that goes from myLocation and intersects perpendicularly with propagationDirection.
        // This corresponds to the smallest radius circle centered at our location that would intersect with the
        // line that is the path of the bullet.
        float perpendicularDist = (float)Math.abs(distToRobot * Math.sin(theta)); // soh cah toa :)

        return (perpendicularDist <= rc.getType().bodyRadius);
    }


}
