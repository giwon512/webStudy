const fs = require("fs");
const filepath = "./data.json";

function readFile() {
    try {
        const data =  fs.readFileSync(filepath, 'utf-8');
        return JSON.parse(data);
    }
    catch(err) {
        console.error('file read error : ', err);
    }
}

function read(key) {
    const data = readFile();
    return console.log(data[key]);
}

function writeFile(data) {
    try {
        fs.writeFileSync(filepath, data);
    }
    catch(err) {
        console.error('file write error : ', err);
    }
}

function create(key, value) {
    const data = readFile();
    if(data[key]) {
        console.log("key already exist");
        return;
    }

    data[key] = value;
    writeFile(JSON.stringify(data));
    console.log("data created");
}

function update(key, value) {
    const data = readFile();
    if(data[key]) {
        data[key] = value;
        writeFile(JSON.stringify(data));
        console.log('data updated');
    }
    else{
        console.log('key does not exist');
    }    
}

function remove(key){
    const data = readFile();
    if(data[key]) {
        delete data[key];
        writeFile(JSON.stringify(data));
        console.log('data deleted');
    }
    else{
        console.log('cannot find data');
    }
}


const args = process.argv.slice(2);
const command = args[0];

switch(command) {
    case 'read':
        read(args[1]);
        break;
    case 'create':
        create(args[1], args[2]);
        break;
    case 'update':
        update(args[1], args[2]);
        break;
    case 'delete':
        remove(args[1]);
        break;
    default:
        console.log('usable commands : create, read, update, delete');
        break;
}