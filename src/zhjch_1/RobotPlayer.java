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

        // Here, we've separated the controls into a different method for each RobotType.
        // You can add the missing ones or rewrite this into your own control structure.
        switch (rc.getType()) {
            case ARCHON:
                //runArchon();
                break;
            case GARDENER:
                //runGardener();
                break;
            case SOLDIER:
                BotSoldier.loop(RobotPlayer.rc);
                break;
            case LUMBERJACK:
                //runLumberjack();
                break;
        }
    }

}
