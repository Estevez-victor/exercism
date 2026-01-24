#include "grains.h"
uint64_t square(uint8_t n){
    if(n<1||n>64) return 0;
    return 1ULL << (n-1);
}

uint64_t total(){
    uint64_t tot=0;
    for(unsigned i=1; i<=64;i++){
        tot=tot+square(i);
    }
    return tot;
}
   