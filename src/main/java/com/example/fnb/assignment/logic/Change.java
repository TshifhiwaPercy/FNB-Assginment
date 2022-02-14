package com.example.fnb.assignment.logic;

import java.util.Arrays;
import java.util.Collections;

//Class used for calculating change
public class Change{
    private Integer[] arr;
    private int amount = 0;

    public Change(){}
    //Initial constructor takes in any integer amount and sets it to a local variable
    public Change(Integer[] arr, int amount){
        this.arr = arr;
        Arrays.sort(this.arr);
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
        String combo = "";//Will be used a storage string when calculating the different combinations required
        int counter = arr.length-1; //Variable will be used to read the array values from highest to lowest
        int total = 0; //Variable will be used to calculate the maximum combination of each integer type is required
        if(arr.length>0) //Confirm arr has at least a single value;
        {

                while (amount > 0) {
                    if (amount >= arr[counter] && arr[counter] > 0) {
                        total += amount / arr[counter]; //Arithmetic expression allows us to extract values after the comma during division eg incases of 11/10 = 1.1, such an expression allows us to extract the .1 value
                        amount = amount - (arr[counter] * total);
                        combo += "R" + arr[counter] + "x" + total + ",";
                    } else { //Statement is invoked if the current array value is smaller than 1 or greater than the current amount.
                        if (counter-1> -1) {
                            counter--; //Decrement the value of count to move to a lower value
                        }
                        total = 0;
                    }
                }

        }
        else{
            return "Change could not be calculated";
        }
        return combo;
    }

}
