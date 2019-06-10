import java.io.*;
import java.util.Scanner;

class Filesize {
  public static void main(String[] args) throws IOException {

    System.out.println("Enter file size (MB): ");
    Scanner x = new Scanner(System.in);
    float the_size = x.nextFloat(); // Idk why but you need to convert it...

    String file_name = new String(the_size + "MB.txt");

    makeFile(file_name, the_size);
  }

  static int makeFile(String file_name, float the_size) throws IOException {

    double file_size = 0;
    String characters = "abcdefghijklmnopqrstuvwxyz123456";

    if (the_size > 0) {
      File f = new File(file_name);
      FileWriter file_write = new FileWriter(f);

      while (file_size <= (the_size * 1048576)) { // bytes in 1MB
        file_write.write(characters);
        file_size += characters.length(); }
      file_write.close();
      System.out.println("Done!\n");

    } else {
      System.out.println("Enter a valid number!\n"); }
    return 0;
  }
}

