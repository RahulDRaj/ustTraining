// const express = require('express');

// const app = express();

// const PORT= 3000;

// app.listen(PORT,() => {
//     console.log("Listening on "+PORT)
// });

// app.get('/', (req,res) => {
//     res.send("Hai Hello")
// });

//SEtup DB URI

process.env.DB_URI = require("./db/clouddb").DB_URI;

var express = require("express");
var bodyParser = require('body-parser');

var router = express.Router();

require('./api/v1/linkedIn')(router);

var app = express();
app.use(bodyParser.json());

app.use(router);

app.listen(3000,function(){
    console.log("Listening on 3000")
})