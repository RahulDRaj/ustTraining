/**
 * All database settings done in this file
 */

var mongoose = require('mongoose')

mongoose.Promise = global.Promise;


var uri = process.env.DB_URI



mongoose.connect(process.env.DB_URI, {
    
    useNewUrlParser: true,
    useUnifiedTopology: true
  });


mongoose.connection.on('error', function(err){
    console.log('Mongoose connection error')
    console.log(err)
})
// events
mongoose.connection.on('disconnected', function(){
    console.log('Mongoose disconnected')
})
mongoose.connection.on('open', function(){
    console.log('Mongoose connected')
})

// export the mongoose & db
exports.mongoose = mongoose;
exports.db = mongoose.connection;

