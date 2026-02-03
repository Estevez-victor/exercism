use std::collections::HashSet;

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let w1s= sorted_uns(word);
    possible_anagrams.iter()
    .filter(|w2|{
         word.len()==w2.len() && word.to_lowercase()!=w2.to_lowercase() && w1s == sorted_uns(w2)
    }).copied().collect()
}

pub fn sorted_uns(word: &str) -> Vec<char>{
    let mut out: Vec<char> = word.to_lowercase().chars().collect();
    out.sort_unstable();
    out
}
