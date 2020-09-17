var expect  = require("chai").expect;
const { MongoClient } = require("mongodb");
var db = require("../mongodb");

describe("Test Mongo DB connection", function(){
    it("Connects successfully to MongoDB and returns a MongoClient", async function(){
        var result = await db.getDB();
        expect(result).to.not.be.null;
        expect(result).instanceOf(MongoClient)
    })
})

