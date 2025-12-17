#include "difference_of_squares.h"
unsigned int square_of_sum(unsigned int n){
    unsigned int o=0;
    for(unsigned int i=1; i<=n; i++){
        o=o+i;
    }
    return o*o;
}

unsigned int sum_of_squares(unsigned int n){
    unsigned int o=0;
    for(unsigned int i=1; i<=n; i++){
        o=i*i+o;
    }
    return o;
}

unsigned int difference_of_squares(unsigned int n){
    return square_of_sum(n)-sum_of_squares(n);
}