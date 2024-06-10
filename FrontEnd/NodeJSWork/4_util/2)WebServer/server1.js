const http = require('http');
const PORT = 3000;
const server = http.createServer((req, resp) => {
    resp.writeHead(200, {'Content-Type' : 'application/json'});
    data = {name : "TOM", age : 20};
    resp.end(JSON.stringify(data));
});
server.listen(PORT, () => {
    console.log(`server is running... ${PORT}`);
});