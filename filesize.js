const readline = require('readline');
const fs       = require('fs');
const path     = require('path');
const rl       = readline.createInterface({input: process.stdin, output: process.stdout});

const RANDOM_CHARS = 'abcdefghijklmnopqrstuvwxyz0123456789';

function askQuestion() {
  rl.question('Please enter the file size (MB:) ', (user_input) => {
    let size = parseFloat(user_input);

    if (isNaN(size) || size <= 0) {
      console.log("Please enter a valid value!\n");
      askQuestion();
    } else {
      makeFile(size, function () {
        console.log('done');
        process.exit(1);
      });
    }
  });
}

function generateDataInMB(callback) {
  let byte_to_mb = 1048576;
  let chars      = RANDOM_CHARS.split('');
  let result     = '';

  for (let i = 0; i < byte_to_mb; i++) {
    let char = chars[Math.floor(Math.random() * chars.length)];
    result   = result + char;

    if (i === (byte_to_mb - 1)) {
      callback(result);
    }
  }
}

function makeFile(size, callback) {
  let name = (size + 'MB.txt');
  fs.writeFileSync(path.join(__dirname, name), '', 'utf-8');

  for (let i = 0; i < size; i++) {
    generateDataInMB(function (data) {
      fs.appendFileSync(name, data);
    });
  }
  callback();
}

askQuestion();
