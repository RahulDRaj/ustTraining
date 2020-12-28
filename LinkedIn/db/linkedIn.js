/**
 * All database operations related to the vacations collection will reside in this file
 */
var model = require('../models/linkedIn')
var settings = require('../db/settings')

// CREATE the vacation package
exports.save = function (data, callback) {

    new model.LinkedIn(data).save(function (err, inserted) {
        callback(err, inserted)

    })
}

// CREATE multiple vacation packages
exports.saveMany = function (rows, callback) {

    model.LinkedIn.insertMany(rows, function (err, docs) {
        callback(err, docs)
    })

}

// UPDATE the vacation packages
// http://mongoosejs.com/docs/api.html#model_Model.update
exports.update = function (criteria, doc, callback) {
    // Replaced .update() with .updateMany() as .update() is deprecated
    model.LinkedIn.updateMany(criteria, doc, function (err, data) {
        callback(err, data)

    })
}

 
}

exports.delete = function (criteria, callback) {
    model.LinkedIn.deleteOne(criteria, function(err,data){
        callback(err,data)
    })
}

exports.select = function (options, callback) {
    var lim = 0
    var off = 0
    if(options.pagination !== undefined){
        if(options.pagination.limit !== undefined)  lim = parseInt(options.pagination.limit)
        if(options.pagination.offset !== undefined)  off = parseInt(options.pagination.offset)
    }

    model.LinkedIn.find(function (err, data) {
        callback(err, data)
    }).select(options.fields).limit(lim).skip(off)
}