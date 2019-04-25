import java.io.*;
import java.util.Scanner;

class filesize {
  public static void main(String[] args) throws IOException {

    double file_size = 0;
    String characters = "abcdefghijklmnopqrstuvwxyz123456";

    System.out.println("Enter file size (MB): ");
    Scanner x = new Scanner(System.in);
    float the_size = x.nextFloat(); // Idk why but you need to convert it...

    String file_name = new String(the_size + "MB.txt");

    if (the_size > 0) {
      File f = new File(file_name);
      FileWriter file_write = new FileWriter(f);
      while (file_size <= (the_size * 1048576)) { // bytes in 1MB
        file_write.write(characters);
        file_size += characters.length(); }
      file_write.close();
    } else {
        System.out.println("Enter a valid number!\n"); }
  }
}

