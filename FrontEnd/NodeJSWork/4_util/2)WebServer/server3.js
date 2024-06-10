const http = require('http');
const PORT = 3000;
const originalData = {name : "TOM", age : 20};

const server = http.createServer((req, resp) => {
    if(req.method === 'GET' && req.url === '/home') {
        resp.setHeader('Content-Type', 'application/json');
        resp.statusCode = 200;
        resp.end(JSON.stringify(originalData));
    }
    else if(req.method === 'POST' && req.url === '/home') {
        req.on('data', (data) => {
            const postData = data.toString();
            console.log(postData);
            Object.assign(originalData, JSON.parse(postData));
        });
        resp.end();
    }
    else if(req.url === '/about') {
        resp.writeHead(200, {'Content-Type' : 'text/html'});
        resp.write('<html><body>');
        resp.write('<h1>About Page</h1>');
        resp.write('</body></html>');
        resp.end();
    }
    else {
        resp.statusCode = 404;
        resp.end();
    }
});
server.listen(PORT, () => {
    console.log(`server is running... ${PORT}`);
});