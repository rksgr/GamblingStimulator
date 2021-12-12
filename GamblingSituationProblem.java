package com.mycompany.workshop_dec_11;


public class GamblingSituationProblem {
    /*
    Use case 1
    */
    public static final int INITIAL_BET_STAKE = 100;
    public static final int BET_AMT = 1;
    
    /*
    Use Case 2
    */
    public void gamblingSituationProblemUC2(){
        double random_num = Math.random();
        int remg_amt = INITIAL_BET_STAKE;
        if (random_num>0.5){
            remg_amt += BET_AMT;
            System.out.println("The Gambler wins the bet and he has $"
            +remg_amt+ " with him after one bet.");
        }else if (random_num<=0.5){
            remg_amt -= BET_AMT;
            System.out.println("The Gambler loses the bet and he has $"
            +remg_amt+ " with him after one bet.");
        } 
    }
    /*
    Use case 3
    */
    public void gamblingSituationProblemUC3(int margin_perct){
        double uppr_margin = INITIAL_BET_STAKE + margin_perct*INITIAL_BET_STAKE/100;
        double lowr_margin = INITIAL_BET_STAKE - margin_perct*INITIAL_BET_STAKE/100;
        double avail_amt = INITIAL_BET_STAKE;
        while ((avail_amt<uppr_margin) && (avail_amt>lowr_margin)){
            double random_num = Math.random();
            if (random_num>0.5){
                avail_amt += BET_AMT;
            }else if (random_num<=0.5){
                avail_amt -= BET_AMT;
            }
        }
        System.out.println("The gambler resigns for the day after he has $"
        + avail_amt + " with him.");
    }
    public static void main(String []args){
        GamblingSituationProblem gsp2 = new GamblingSituationProblem();
        //gsp2.gamblingSituationProblemUC2(); 
        GamblingSituationProblem gsp3 = new GamblingSituationProblem();
        gsp3.gamblingSituationProblemUC3(50);
    }
}