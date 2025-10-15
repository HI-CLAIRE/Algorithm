const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', function (line) {
    const [a, b] = line.split(' ')
    console.log(a + b)
})
//     .on('close', function () {
//     // console.log(input[0], '+', input[1], '=', Number(input[0]) + Number(input[1]));
    
// });