const DB_USER = "kannan";
const DB_PASSWORD="kannan";
const DB_NAME= "testapi";
const CLUSTER_HOST="demo.apj2x.mongodb.net";

//DB Connection String
//mongodb+srv://venkat:<password>@apidemo.xiijf.mongodb.net/<dbname>?retryWrites=true&w=majority

exports.DB_URI= `mongodb+srv://${DB_USER}:${DB_PASSWORD}@${CLUSTER_HOST}/${DB_NAME}?retryWrites=true&w=majority`;