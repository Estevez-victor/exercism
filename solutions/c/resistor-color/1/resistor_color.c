#include "resistor_color.h"

resistor_band_t c[COLOR_COUNT] = {
    #define X(color) color,
    COLORS
    #undef X
};

int color_code(resistor_band_t color){
    return color;
}

resistor_band_t *colors(void){
    return c;
}