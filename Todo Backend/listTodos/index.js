
// var mongoClient = require("mongodb").MongoClient;
// mongoClient.connect("mongodb://todosapi:c7xTLMrWARyqJVWUeforL6JT8HdcH5AVQXD4q8E71TuLdOS3N95lwhzxC3TGA929R3yCTPBD1DpuaaPFn23row==@todosapi.mongo.cosmos.azure.com:10255/?ssl=true&appName=@todosapi@", function (err, db) {
//   db.close();
// });

 var MongoClient = require("mongodb").MongoClient;
module.exports = async function (context, req) {
    
    const URL = process.env.MONGODB_URL;
    //'mongodb://todosapi:c7xTLMrWARyqJVWUeforL6JT8HdcH5AVQXD4q8E71TuLdOS3N95lwhzxC3TGA929R3yCTPBD1DpuaaPFn23row%3D%3D@todosapi.mongo.cosmos.azure.com:10255/?ssl=true&replicaSet=globaldb&retrywrites=false&maxIdleTimeMS=120000&appName=@todosapi@';
    const DATABSE_NAME = process.env.MONGODB_DATABASE_NAME;
    //'serverless';
    const COLLECTION_NAME = process.env.MONGODB_COLLECTION_NAME;
    //'todos';

    const connection = await MongoClient.connect(URL, { useUnifiedTopology: true });
    const todoCollection=connection.db(DATABSE_NAME)
        .collection(COLLECTION_NAME);
    
    const results = await todoCollection
        .find({})
        .toArray();
    
    await connection.close();

   
    return {
        // status: 200, /* Defaults to 200 */
        body: JSON.stringify(results)
        .replace(/_id/g,"id")
    };
}