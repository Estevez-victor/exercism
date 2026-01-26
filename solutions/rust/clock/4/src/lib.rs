use std::fmt;
#[derive(Debug, PartialEq)]
pub struct Clock {
	hour: i32,
	min: i32,
}

impl Clock {
	pub fn new(hours: i32, minutes: i32) -> Self {
		Clock {
			hour: (hours+minutes.div_euclid(60)).rem_euclid(24),
			min: minutes.rem_euclid(60)
		}
	}
	pub fn add_minutes(&self, minutes: i32) -> Self {
		Clock::new(self.hour, self.min+minutes)
	}
}

impl fmt::Display for Clock {
	fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
		write!(f, "{:02}:{:02}", self.hour, self.min)
	}
}
