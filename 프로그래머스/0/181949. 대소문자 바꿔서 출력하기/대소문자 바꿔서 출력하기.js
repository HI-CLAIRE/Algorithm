const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    
    let res = '';
    
    for(i=0; i<str.length; i++) {
        if(str[i] < 'a') {
            res += str[i].toLowerCase();
        } else {
            res += str[i].toUpperCase();
        }
    }
    
    console.log(res)
});