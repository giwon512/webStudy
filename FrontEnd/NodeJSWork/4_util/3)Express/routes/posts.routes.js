const express = require('express');
const postsController = require("../controller/posts.controller")
const postsRouter = express.Router();

postsRouter.get("/", postsController.getPost);

module.exports = postsRouter;