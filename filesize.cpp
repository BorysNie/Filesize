#include <iostream>
#include <fstream>
#include <string>

using namespace std;

double fileSize = 0;
double theSize;
string fileName;
string chars = "abcdefghijklmnopqrstuvwxyz0123456789";

int generateDataInMB(string fileName, double theSize) {
  if (theSize <= 0) {
    cout << "Enter a valid number! \n";
    generateDataInMB;
  } else {
    ofstream file;
    file.open(fileName);
    while (fileSize < (theSize * 1048576)) { //bytes in 1MB
      file << chars;
      fileSize += chars.length(); }
  file.close();
  cout << "Done!" << endl;
  }
}

int main() {
  cout << "Enter file size in (MB): ";
  cin  >> theSize;

  fileName = to_string(theSize) + "MB.txt"; // Adds decimal point to fileName

  generateDataInMB(fileName, theSize);
}