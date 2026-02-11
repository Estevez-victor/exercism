/// Check a Luhn checksum.
pub fn is_valid(code: &str) -> bool {
    if code.chars().any(|c| !c.is_ascii_digit() && c != ' ') { 
        return false;
    }
    let code_char = code.chars().filter(|c| c.is_ascii_digit());
    if code_char.clone().collect::<String>() == "0"{
        return false;
    }
    let mut luhn: Vec<u32> = Vec::with_capacity(code.len());
    let mut flip: bool = false;
    for c in code_char.rev() {
        println!("c: {}", c);
        if flip{
            match c.to_digit(10).unwrap()*2 {
                v if v>9 => luhn.push(v-9),
                v => luhn.push(v),
            }
        }else{ luhn.push(c.to_digit(10).unwrap()); }
        flip = !flip;
    }
    luhn.into_iter().reduce(|total,x| total+x).unwrap()%10==0
}
