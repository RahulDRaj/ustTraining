var settings = require('../db/settings');

var LinkedInSchema = settings.mongoose.Schema(
    {
        email: {type: String, required:[true,'email is needed'],unique:true},
        name: {type: String, required:[true,'name is needed']},
        age: {type:Number,required:[true,'age is needed']},
        description: {type:String, required:true},
        phone: {type: String, required:[true,'phone Number is needed']},
        highestDegree: {type: String, required:[true,'Highest Qualification is needed']},
        picture:{type: String},
        
    }
);

exports.LinkedIn = settings.mongoose.model('linkedIn',LinkedInSchema);