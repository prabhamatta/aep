package edu.berkeley.ischool.week7;

/**
 * Understands how to make Tee Groups
 * How many Tee Groups?  Rules:
 * 1) First group gets to play
 * 2) No more than 4 in a Tee group
 * 3) Don't break a 4 group
 *
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GolfGame {

    private final List<Integer> parties;

    public GolfGame(Integer[] parties){
        this.parties = new ArrayList<Integer>(Arrays.asList(parties));
    }

    public int getNumberOfGroups(){
        int ret_val = 0;
        int out_val = 0;
        int sum = 0;
        int num_groups = 0;


//        for(Integer party : parties) {
//            parties.iterator().next()
//            /*
//            if(party == 4){
//               ++num_groups;
//            }
//            else{
//
//            }*/
//        }


        for(int i =0; i<parties.size(); i++)
        {
            if (parties.get(i)<4){}

            sum += parties.get(i);

        }
        return (parties.get(0) + parties.get(1))/4;
    }

}
