use std::fmt;
#[derive(Debug, PartialEq)]
pub struct Clock{
    hour: i32,
    min: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        match (hours.is_negative(), minutes.is_negative(), minutes==-60) {
            (_,_,true) => Self{hour: if(hours==0){23}else{hours-1}, min:0},
            (false, false, false) => Self{hour: (hours+minutes/60)%24, 
                                   min: minutes%60},
            (true, false, false) => Self{hour: (((hours+minutes/60)%24)+24)%24, 
                                   min: minutes%60},
            _ => Self{hour: (((hours-1+minutes/60)%24)+24)%24, 
                                   min: ((minutes%60)+60)%60},
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        if (minutes>=0){
            Self {
                hour: (self.hour+(self.min+minutes)/60)%24,
                min:(self.min + minutes)%60,
            }
        }
        else{
            Self{
                hour: 
                    if(self.min+minutes<0){(((self.hour-1+(self.min+minutes)/60)%24)+24)%24}
                    else{self.hour},
                min:(((self.min + minutes)%60)+60)%60,
            }
        }
    }
}

impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(f, "{:02}:{:02}", self.hour, self.min)
    }
}