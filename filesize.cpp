#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
  double file_size;
  double the_size;
  string file_name;
  string characters = "abcdefghijklmnopqrstuvwxyz0123456789";
  file_size = 0;

  cout << "Enter file size in (MB): ";
  cin  >> the_size;

  file_name = to_string(the_size) + "MB.txt";

  if (the_size < 0) {
    cout << "Enter a valid number! \n";
    system("pause");
  } else {
    ofstream file;
    file.open(file_name);
    while (file_size < (the_size * 1048576)) { //bytes in 1MB
      file << characters;
      file_size += characters.length();
    }
  file.close();
  }
}
