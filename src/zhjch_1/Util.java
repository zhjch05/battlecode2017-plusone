package zhjch_1;
import battlecode.common.*;
/**
 * Created by jinchengzhang on 1/11/17.
 */
public class Util extends Globals{

    public static void broadcastWrapper(int archon, MapLocation loc, Team who) throws GameActionException{
        switch (archon){
            case 1:
                if(who == us)
                    rc.broadcast(OUR_ARC_1_LOC_X, (int)loc.x);
        }
    }
}
