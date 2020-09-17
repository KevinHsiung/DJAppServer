const { expect } = require('chai');
const chai = require('chai')
  , spies = require('chai-spies')
  , rewire = require('rewire')
  , chaiHttp = require('chai-http')
  , app = rewire ('../app')
  , sample_bulkupload = require('../data/sample_bulkupload.json')
  , sample_single = require('../data/sample_single.json');

chai.use(chaiHttp);
chai.use(spies);


const db = app.__get__('db');
db.saveOne = chai.spy();
db.saveMany = chai.spy();
db.search = chai.spy(() => {
    return [1,2,3,4,5,6,7,8,9,10]
});

describe("Test to see if application server starts", function(){
    it("calls the default endpoint", async function(){
        chai.request(app).get("/").end((err,res) => {
            expect(res).to.have.status(200);
        });
    })
})

describe("Test add endpoint", function(){    
    it("Attempt to add without empty data ", async function(){
        chai.request(app).post("/add").end((err,res) => {
            expect(res).to.have.status(400);
        });
    });

    it("Attempt to add with empty body", async () => {
        var body = {};
        chai.request(app).post("/add").type('json').send({}).end((err,res) => {
            expect(res).to.have.status(400);
        });
    });

    it("Attempt to add with a missing property in body", async () => {
        var body = JSON.parse(JSON.stringify(sample_single));
        delete body.quarter;
        chai.request(app).post("/add").type('json').send(body).end((err,res) => {
            expect(res).to.have.status(400);
        });
    });

    it("Attempt to add with correct property in body", async () => {
        var body = JSON.parse(JSON.stringify(sample_single));
        chai.request(app).post("/add").type('json').send(body).end((err,res) => {
            expect(res).to.have.status(200);

            //mock the db
            expect(db.saveOne).to.be.spy; 
            expect(db.saveOne).to.have.been.called();
        });
    });
})



describe("Test search endpoint", function(){    
    it("Attempt to search without ticker ", async function(){
        chai.request(app).get("/search").end((err,res) => {
            expect(res).to.have.status(400);
        });
    });
    
    it("Attempt to search with ticker", async () => {
        chai.request(app).get("/search").type('json').send({"ticker": "AA"}).end((err,res) => {
            expect(res).to.have.status(200);
            expect(res.body.length).to.equal(10);
            expect(db.search).to.be.spy; 
            expect(db.search).to.have.been.called();
        });
    });
})


describe("Test upload endpoint", function(){    
    it("Attempt to upload with empty data", async function(){
        chai.request(app).post("/upload").end((err,res) => {
            expect(res).to.have.status(400);
        });
    });
    
    it("Attempt to upload with correct data", async () => {
        chai.request(app).post("/upload").type('json').send(sample_bulkupload).end((err,res) => {
            expect(res).to.have.status(200);
            expect(db.search).to.be.spy; 
            expect(db.search).to.have.been.called();
        });
    });
})
