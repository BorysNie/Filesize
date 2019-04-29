const readline = require('readline');
const fs       = require('fs');

var characters = 'abcdefghijklmnopqrstuvwxyz0123456789';
var theSize    = 0;

const rl = readline.createInterface({
    input:  process.stdin,
    output: process.stdout });

rl.question('Please enter the file size (MB:) ', (fileSize) => {
  var fileName = String(fileSize) + "MB.txt";

  if (fileSize < 0) {
    console.log("Please enter a valid value!\n");
  } else {
    while (fileSize <= (theSize * 1048576)) { // bytes in 1MB
      fs.writeFile("./fileName"), characters, function(err) {
        if (err) throw err;
          return console.log("File created!\n");
        rl.close(); process.stdin.destroy();
      }
    }
  }
});
