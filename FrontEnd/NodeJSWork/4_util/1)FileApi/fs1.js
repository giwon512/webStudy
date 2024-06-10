const fs = require("fs");

const content = "Hello World";

async function helloworld() {
    try{
        await fs.writeFile("./hello.txt", content, (err) => {
            if(err){
                console.log(err);
            }
        });

        await fs.readFile("./hello.txt", "utf-8", (err, data) => {
            if(err){
                console.error(err);
                return;
            }
            console.log(data);
        });
    }
    catch(err) {
        console.log(err);
    }
}

helloworld();