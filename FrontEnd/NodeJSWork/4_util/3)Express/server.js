const express = require('express');
const usersRouter = require("./routes/users.routes");
const postsRouter = require("./routes/posts.routes");
const path = require('path');

const PORT = 4000;
const HOST = "localhost";



const app = express();
app.set('view engine', 'hbs');
app.set('views', path.join(__dirname, 'views'));

app.use('/static', express.static(path.join(__dirname,'public')));

app.use(express.json());

app.use((req, res, next) => {
    const start = Date.now();
    console.log(`start : ${req.method} ${req.url}`);
    next();

    const diffTIme = Date.now() - start;
    console.log(`end : ${req.method} ${req.baseUrl} ${diffTIme}ms`);
})

app.use("/users", usersRouter);
app.use("/posts", postsRouter);

app.get("/", (req, res) => res.render('index', {imageTitle : "It is a Lighthouse"}));

app.listen(PORT, HOST);

console.log(`Running on https://${HOST}:${PORT}`);