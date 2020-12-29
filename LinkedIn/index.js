
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