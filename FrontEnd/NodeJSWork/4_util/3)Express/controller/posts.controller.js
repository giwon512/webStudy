const path = require('path');

function getPost(req, res) {
    // res.send('<div><h1>Post Title</h1><p>This is post...</p></div>');
    // res.sendFile(path.join(__dirname, '..', 'public', 'images', 'lighthouse.jpg'));
    res.render('posts', {templateName : "post"});
}

module.exports = {getPost};