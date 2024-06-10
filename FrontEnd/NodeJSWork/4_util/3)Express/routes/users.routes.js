const express = require("express");
const usersController = require("../controller/users.controller");
const usersRouter = express.Router();

usersRouter.get("/", usersController.getUsers);
usersRouter.get("/:userId", usersController.getUser);
usersRouter.post("/", usersController.postUser);

module.exports = usersRouter;