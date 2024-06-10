const Users = require("../model/users.model")

function getUsers(req, res) {
    res.send(Users); 
}

function getUser(req, res) {
    const idx = parseInt(req.params.userId);
    const user = Users[idx];

    if(user) {
        res.json(user);
    }
    else{
        res.sendStatus(400);
    }
}

function postUser(req, res) {
    if(!req.body.name) {
        return res.status(400).json({error : "Missing user name"});
    }

    const newUser = {
        name : req.body.name,
        id : Users.length
    }

    Users.push(newUser);
    res.json(newUser);
}




module.exports = {getUsers, getUser, postUser}