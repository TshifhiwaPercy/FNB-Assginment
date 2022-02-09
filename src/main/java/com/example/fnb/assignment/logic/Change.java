package com.example.fnb.assignment.logic;

//Class used for calculating change
public class Change{
    private  int V1 = 0;
    private  int V2 = 0;
    private  int V3 = 0;
    private  int V4 = 0;
    private int amount = 0;

    public Change(){}
    //Initial constructor takes in any integer amount and sets it to a local variable
    public Change(int v1, int v2, int v3, int v4, int amount){
        this.V1 = v1;
        this.V2 = v2;
        this.V3 = v3;
        this.V4 = v4;
        setAmount(amount);
    }

    //Setter method for amount
    private void setAmount(int amount){

        this.amount = amount;
    }
    //Getter method for amount
    public int getAmount(){
        return this.amount;
    }

    //The following method can be invoked externally to return how the change should be like
    //E.g amount = 13 below method will return R10 x 1, and R2 x 1, and R1 x 1; --->This is an indication to how the change should be sorted
    public String getChange(){
        //Check if the lowest amount V1 provided is greater or less than the given amount
        String combo = "";
        int v1 = 0, v2 = 0, v3 = 0,v4 = 0; //These variables count the number of occurences required for the numbers or amounts 1,2,5,10 respectively.

       if(V1>amount){
           combo = "ERROR THE (V) values PROVIDED ARE ALL GREATER THAN THE AMOUNT";
       }
       else{
           while(amount>0){
               if(amount>=V4){
                   v4 += amount/V4;
                   amount = amount-(V4*v4);
                   combo+="R"+V4+" x "+v4+", ";
               }
               else if(amount>=V3){
                   v3+=amount/V3;
                   amount=amount-(v3*V3);
                   combo+="R"+V3+" x "+v3+", ";
               }
               else if(amount>=V2){
                   v2+=amount/V2;
                   amount=amount-(v2*V2);
                   combo+="R"+V2+" x "+v2+", ";
               }
               else{
                   v1+=amount/V1;
                   amount=amount-(v1*V1);
                   combo+="R"+V1+" x "+v1+", ";
               }
           }
       }
        return combo;
    }
}
