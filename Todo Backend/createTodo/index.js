
var MongoClient = require("mongodb").MongoClient;
var ObjectId= require("mongodb").ObjectID;
module.exports = async function (context, req) {
    
    const URL = process.env.MONGODB_URL;
     const DATABSE_NAME = process.env.MONGODB_DATABASE_NAME;
    const COLLECTION_NAME = process.env.MONGODB_COLLECTION_NAME;
   
    const connection = await MongoClient.connect(URL, { useUnifiedTopology: true });
    const todoCollection=connection.db(DATABSE_NAME)
        .collection(COLLECTION_NAME);
    

    let body = req.body;
    delete body.id;
    const results = await todoCollection
        .insertOne(body);
        
    await connection.close();

   
    return {
        
        body: '{"message" : "success"}'
    };
}