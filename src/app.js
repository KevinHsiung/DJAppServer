const express = require('express');
const app = express();
const { body, validationResult } = require('express-validator');
const db = require('./mongodb.js');
const seedData = require('./data/dow_jones_index.json');


app.use(express.json());

app.get('/', function (req, res) {
   return res.statusCode(200);
});


//Search ndpoint for the requirement "query for data by stock ticker".
//Expects a body with '{"ticker": <name of ticker>}' json object.

app.get('/search',[ body("ticker").notEmpty()],  async (req, res) => {   
   const errors = validationResult(req);
   if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
   }

   console.log("Searching for ticker");
   var result = await db.search(req.body.ticker);
   res.send(result);
})

//Add endpoint for the requirment "add a new record".
//Expects all the datapoints from the dow_jones_index data in a single Json object format.
app.post('/add', [
   body("quarter").notEmpty(),
   body("stock").notEmpty(),
   body("date").notEmpty(),
   body("open").notEmpty(),
   body("high").notEmpty(),
   body("low").notEmpty(),
   body("close").notEmpty(),
   body("volume").notEmpty(),
   body("precent_change_price").notEmpty(),
   body("percent_change_volume_over_last_wk").notEmpty(),
   body("previous_weeks_volume").notEmpty(),
   body("next_weeks_open").notEmpty(),
   body("next_weeks_close").notEmpty(),
   body("percent_change_next_weeks_price").notEmpty(),
   body("days_to_next_dividend").notEmpty(),
   body("percent_return_next_dividend").notEmpty(),
      ], async (req, res) => {
         const errors = validationResult(req);
         if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
         }

         var result = await db.saveOne(req.body);
         res.send(result);
      })


//Bulk Upload endpoint for the requirment "//Add End point for the requirment "add a new record".
//Expects all the datapoints from the dow_jones_index data in an Array of Json Object format.
app.post('/upload', [
   body().isArray(),
   body("*.quarter").notEmpty(),
   body("*.stock").notEmpty(),
   body("*.date").notEmpty(),
   body("*.open").notEmpty(),
   body("*.high").notEmpty(),
   body("*.low").notEmpty(),
   body("*.close").notEmpty(),
   body("*.volume").notEmpty(),
   body("*.precent_change_price").notEmpty(),
   body("*.percent_change_volume_over_last_wk").notEmpty(),
   body("*.previous_weeks_volume").notEmpty(),
   body("*.next_weeks_open").notEmpty(),
   body("*.next_weeks_close").notEmpty(),
   body("*.percent_change_next_weeks_price").notEmpty(),
   body("*.days_to_next_dividend").notEmpty(),
   body("*.percent_return_next_dividend").notEmpty(),
], (req, res) =>{
   const errors = validationResult(req);
   if (!errors.isEmpty()) {
      return res.status(400).json({ errors: errors.array() });
   }
   var result = db.saveMany(req.body);
   res.send(result);
 })


var server = app.listen(8081, async () => {
   var host = server.address().address
   var port = server.address().port
   console.log("Application server listening at http://%s:%s", host, port);

//Additional parameter when running the node command to seed/reseed the entire mongodb 
   if(process.argv[2] == "--reseed"){      
      console.log("Reseeding");
      await db.reseedData(seedData);
      console.log("Done reseeding. DB is populated with seed data.");
   };
});

module.exports = server