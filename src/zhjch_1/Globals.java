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
    public static MapLocation here;
    public static Team us;
    public static Team them;
    public static int myID;
    public static RobotType myType;

    public static int roundNum;

    public static int numberOfInitialArchon;

    public static MapLocation[] ourInitialArchonLocations;
    public static MapLocation[] theirInitialArchonLocations;

    public static void init(RobotController theRC){
        rc = theRC;
        us = rc.getTeam();
        them = us.opponent();
        myID = rc.getID();
        myType = rc.getType();
        here = rc.getLocation();
        ourInitialArchonLocations = rc.getInitialArchonLocations(us);
        theirInitialArchonLocations = rc.getInitialArchonLocations(them);
        numberOfInitialArchon = ourInitialArchonLocations.length;
    }
}
