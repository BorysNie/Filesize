use std::io::{stdin, Write, Error};
use std::fs;

fn get_user_input() -> String {
    let mut input = String::new();
    stdin().read_line(&mut input).unwrap();
    String::from(input.trim())
}

fn create_file(user_input: String) -> Result<(), Error> {
    let mut file_size  = 0;
    let the_size   = user_input.parse::<i32>().unwrap() * 1048576; //bytes in 1MB
    let characters = "abcdefghijklmnoprstuwxyz0123456789";
    let path       = format!("{}MB.txt", user_input);
    let mut output = fs::File::create(path)?;

    if the_size <= 0 {
        println!("Please enter a valid number")
    } else {
        while file_size <= the_size {
            output.write_all(characters.as_bytes())?;
            file_size += characters.len() as i32;
        }
    };
    Ok(())
}

fn main() {
    println!("Enter a file size (MB): ");
    let user_input = get_user_input();
    create_file(user_input).unwrap();
}

