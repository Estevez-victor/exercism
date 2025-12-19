#ifndef RESISTOR_COLOR_H
#define RESISTOR_COLOR_H

#define COLORS \
    X(BLACK)\
    X(BROWN)\
    X(RED)\
    X(ORANGE)\
    X(YELLOW)\
    X(GREEN)\
    X(BLUE)\
    X(VIOLET)\
    X(GREY)\
    X(WHITE)

typedef enum Colors {
    #define X(color) color,
    COLORS
    #undef X
    COLOR_COUNT
} resistor_band_t;

int color_code(resistor_band_t rbt);
resistor_band_t *colors(void);

#endif