#include "collatz_conjecture.h"

int steps(int roll){
    int i=0;
    if(roll<=0) return -1;
    while (roll>1){
        if(roll%2==0){
            roll=roll/2;
            i++;
        }else{
            roll=roll*3+1;
            i++;
        }
    }
    return i;
}