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
    /*
    Use case 4
    */
    public void gamblingSituationProblemUC4(){
        int NO_OF_BETS = 100;
        //margin = 50%
        double uppr_margin = 0.5*INITIAL_BET_STAKE;
        double lowr_margin = -0.5*INITIAL_BET_STAKE;
        double tot_amt_won_lost = 0;
        
        // Game played for 20 days
        for (int i=0;i<20;i++){
            double daily_amt_won_lost = 0;
            // Assume 100 bets played every day
            int bets_played = 0;
            // Everyday game stops at 50% margin
            while ((daily_amt_won_lost<uppr_margin) && (daily_amt_won_lost>lowr_margin)
                    && (bets_played < NO_OF_BETS)){
                double random_num = Math.random();
                bets_played++;
                if (random_num>0.5){
                    daily_amt_won_lost += BET_AMT;
                }else if (random_num<=0.5){
                    daily_amt_won_lost -= BET_AMT;
                }
            }
            tot_amt_won_lost += daily_amt_won_lost;   
        }
        // Print total amount won or last in 20 days
        if (tot_amt_won_lost>0){
            System.out.println("The total amount won in 20 days = "+ tot_amt_won_lost);
        }
        else if (tot_amt_won_lost==0){
            System.out.println("There is no net gain in last 20 days");
        }
        else if (tot_amt_won_lost<0){
            System.out.println("The total amount lost in last 20 days = "+ Math.abs(tot_amt_won_lost));
        }
    }
    public static void main(String []args){
        GamblingSituationProblem gsp = new GamblingSituationProblem();
        gsp.gamblingSituationProblemUC4();      
    }
}