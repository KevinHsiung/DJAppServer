var {MongoClient} = require('mongodb');


//connects to a MongoDB and returns a client
//TODO - figure a way to close the client after other methods calls. 
async function getDB(){
    const uri = process.env.MONGO_URL || "mongodb://localhost";
    const client = new MongoClient(uri,{useUnifiedTopology: true});    
    try {
        await client.connect();
        return client;        
 
    } catch (e) {
        console.error(e);
        //if error occurs, return a null value for other methods to handle
        return null;
    } 
}

//Save single record at a time to Mongo DB 
async function saveOne(data){
    try {
        return await getDB().then(async(client) => {
            if(client){
                var result =  await client.db('local').collection('dow_jones').insertOne(data)
                console.log(`New listing created with the following id: ${result.insertedId}`);
                return "success";
            } else {
                //getDB() returned a null value;
                var clientError = `Unable to setup DB `;
                console.log(clientError);
                return clientError;
            }
        })
    } catch (error) {
            console.log(error);
            return error;
    }
}

async function saveMany(data){
    try {
        return await getDB().then( async(client) => {
            if(client) {
                var result =  await client.db('local').collection('dow_jones').insertMany(data)
                console.log(`New entry added total: ${result.insertedCount}`);
                return result.insertedCount;
            } else {
                var clientError = `Unable to setup DB `;
                console.log(clientError);
                return clientError;
            }
        })
        } catch (error) {
            console.log(error);
            return error;
        }
}

async function search(ticker){
    try {
        return await getDB().then( async(client) => {
            if(client){
                var result =  await client.db('local').collection('dow_jones').find({
                    stock: ticker
                    })

                if (result) {
                    return await result.toArray();
                } else {
                    console.log(`No listings found with the name `);
                    return null;
                }
            }
        })
    } catch (error) {
        console.log(error);
        return null;
    }
}

//Delete any data in the collection and reseed it
async function reseedData(data){
    try {
        return await getDB().then( async(client) => {
            if(client){
                console.log("Deleting all data in collection...");
                await client.db('local').collection('dow_jones').deleteMany({})
                console.log("Done.");
                console.log("Seeding DB with initial data");
                var result =  await client.db('local').collection('dow_jones').insertMany(data)
                console.log(`DB seeded. Total Count: ${result.insertedCount}`);
                return result.insertedCount;
            } 
        })
    } catch (error) {
        console.log(error);
        return error;
    }

}


module.exports = {search, getDB, saveOne, saveMany, reseedData }