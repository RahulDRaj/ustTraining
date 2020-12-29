/**
 * Contains the definition of the API endpoints for vacation packages
 * 
 */
// As a best practice keep the resource name same as the file name
var RESOURCE_NAME = 'linkedIn';
var VERSION = 'v1';
var URI = '/' + VERSION + '/' + RESOURCE_NAME; 

// Setup the vacations db
var db = require('../../db/linkedIn')
var apiErrors = require('../../util/errors')
var apiMessages = require('../../util/messages')
const MIN_AGE=18

module.exports = function(router){
    'use strict';

    // RETRIEVE all active vacation packages
    // Active = validTill >= Today's date

    //    /v1/Vacations
    router.route(URI).get(function(req, res,next){
		res.header('Cache-Control', 'public, min-age='+MIN_AGE);
        console.log("GET Details")
        var fields ={}
        if(req.query && req.query.fields !== undefined){
           fields =  createFields(req.query.fields)
        }
        var pagination = {limit:0, offset:0}
        
        if(req.query && req.query.limit !== undefined){
            pagination.limit = req.query.limit
        }
        if(req.query && req.query.offset !== undefined){
            pagination.offset = req.query.offset
        }

        var options = {fields:fields, pagination:pagination}
        console.log(options)
        

        //2. execute the query
        db.select(options, function(err,docs){
           
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                if(docs.length == 0){
                    res.status(404)
                }
                console.log("Retrieved Details = %d",docs.length)
                res.send(docs)
            }
        });
    });

    // CREATE new vacation packages
    router.route(URI).post(function(req, res,next){
		res.header('Cache-Control', 'public, min-age='+MIN_AGE);
        console.log("POST  Details")

        //1. Get the data
        var doc = req.body;

        //2. Call the insert method
        db.save(doc, function(err,saved){
            if(err){
                // The returned error need to be defined better - in this example it is being left as is
                var userError = processMongooseErrors(apiMessages.errors.API_MESSAGE_CREATE_FAILED, "POST", URI, err,{});
                res.setHeader('content-type', 'application/json')
                res.status(400).send(userError)
            } else {
                res.send(saved)
            }
        });
    });

    router.route(URI).put(function(req,res,next){
		res.header('Cache-Control', 'public, min-age='+MIN_AGE);
        console.log("UPDATE")
        var criteria = {name: 'kannan'}
        var doc = req.body;
        db.update(criteria,doc,function(err,updated){
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                console.log("updated details = %d",updated.length)
                res.send(updated)
            }
        });
    });

    router.route(URI).delete(function(req,res,next){
		res.header('Cache-Control', 'public, min-age='+MIN_AGE);
        console.log("Delete")
        var criteria = {name:"kannan1"}
        db.delete(criteria,function(err,deleted){
            if(err){
                console.log(err)
                res.status(500)
                res.send("Error connecting to db")
            } else {
                console.log("Deleted details = %d",deleted.length)
                res.send(deleted)
            }
        });
    });
}

/**
 * Converts the Mongoose validation errors to API specific errors
 */
var processMongooseErrors = function (message, method, endpoint, err,payload) {
    var errorList = []
    // Check for validation error
    if (err.name === 'ValidationError'){
        errorList = processValidationErrors(err)
    } else if(err.code == 11000){
        // it could be database error - 11000 is for duplicate key
        errorList.push(apiErrors.errors.PACKAGE_ALREADY_EXISTS)
    } else {
        var errUnknown = apiErrors.errors.UNKNOWN_ERROR
        errUnknown.payload = err
        errorList = [apiErrors.errors.UNKNOWN_ERROR]
    }
    return apiErrors.create(message, method, endpoint, errorList, payload)
}

var processValidationErrors = function (err) {
    var errorList = []
    // Check if there is an issue with the Num of Nights
    
    // Check if name of the package is missing
    if (err.errors.name) {
        if (err.errors.name.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_NAME)
        }
    }

    // Check if description of the package is missing
    if (err.errors.description) {
        if (err.errors.description.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_DESCRIPTION)
        }
    }

    if (err.errors.email) {
        if (err.errors.description.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_EMAIL)
        }
    }

    if (err.errors.age) {
        if (err.errors.description.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_AGE)
        }
    }

    if (err.errors.phone) {
        if (err.errors.description.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_PHONE)
        }
    }

    if (err.errors.highestDegree) {
        if (err.errors.description.kind === apiErrors.kinds.REQUIRED) {
            errorList.push(apiErrors.errors.MISSING_PACKAGE_HIGHESTDEGREE)
        }
    }

    return errorList;
}