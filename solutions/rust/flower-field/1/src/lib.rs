pub fn annotate(garden: &[&str]) -> Vec<String> {
    if garden.is_empty() {return Vec::new()}
    let h = garden.len();
    let l = garden[0].len();
    let mut result: Vec<String> = Vec::with_capacity(h);
    
    let g: Vec<&[u8]> = garden.iter().map(|s| s.as_bytes()).collect();
    let around = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)];
    for y in 0..h {
        let mut line: String = String::with_capacity(l);
        for x in 0..l {
            if g[y][x] == b'*' {
                line.push('*');
            } else {
                
                let mut count = 0;
                for (diry, dirx) in around {
                    let ny = y as isize + diry;
                    let nx = x as isize + dirx;
                    if (ny >= 0) && (ny < h as isize) && (nx >= 0) && (nx < l as isize) {
                        if g[ny as usize][nx as usize] == b'*' {
                            count+=1;
                        }
                    }
                }
                
                if count==0 {line.push((b' ') as char);}
                else{line.push(char::from_digit(count, 10).unwrap());}
            }
        }
        result.push(line);
    }
    result
}
