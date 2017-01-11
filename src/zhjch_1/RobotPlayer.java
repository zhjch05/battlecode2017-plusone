package zhjch_1;
import battlecode.common.*;

/**
 * Created by jinchengzhang on 1/11/17.
 */
public strictfp class RobotPlayer {
    static RobotController rc;

    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException{
        RobotPlayer.rc = rc;
    }

}
