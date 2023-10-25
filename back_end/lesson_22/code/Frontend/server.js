const express = require('express');

const app = express();

app.use(express.static('public'));

app.listen(8081);

console.log('App started on 8081')