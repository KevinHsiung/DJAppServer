# Application Server Challenge

## NEW: Added Docker Support
You can now use docker to start the application server

Run "docker-compose up" to start the application in docker.


## Prerequisites :
The following needs to be installed
<ul>
  <li>NodeJS</li>
  <li>MongoDB</li>  
</ul>

## Getting Started:
Run `npm install` to install the npm packages

## Application server

Run `node app.js` to start the application server. Application server is hosted at `http://localhost:8081/`.

Optional: Add Optional Parameter `--reseed` to seed the collection with initial data. Example: `node app.js --reseed`


## API Endpoints

###  [HTTP GET] http://localhost:8081/search?ticker={tickername}
Example: http://localhost:8081/search?ticker=AA

###  [HTTP POST] http://localhost:8081/add
Required: All fields required in the body of the request

Check the data/sample_single.json for an example
```
{
    "quarter": 3,
    "stock": "RY.TO",
    "date": "16 September, 2020",
    "open": 98.10,
    "high": 98.42,
    "low": 97.76,
    "close": 98.13,
    "volume": "3,662,701",
    "percent_change_price": 1.63831,
    "percent_change_volume_over_last_wk": 9.355500109,
    "previous_weeks_volume": 138428495,
    "next_weeks_open": "$16.18",
    "next_weeks_close": "$17.14",
    "percent_change_next_weeks_price": 5.93325,
    "days_to_next_dividend": "10",
    "percent_return_next_dividend": "0.185989"
}
```

###  [HTTP POST] http://localhost:8081/upload
Required: Array of objects in the body of the request

Check the data/sample_bulkupload.json for an example


## Running tests

Run `npm test` inside the Node Folder to execute the test cases defined in the "Test" folder;

Note: The application server should be stopped before running "npm test" otherwise the port will be in use and the test will fail.

Testing technologies used

- [x] Mocha
- [x] chai
- [x] chai-http (to make http requests)
- [x] chai-spies (to mock db calls)
- [x] rewire (to modify modules to inject chai-spies) 


## Approach to solving the problem

<ol>
  <li>
    Get the initial Down Jones Dataset. <a href='http://archive.ics.uci.edu/ml/datasets/Dow+Jones+Index#'>Dow Jones Dataset</a>
    
   - [x] Saved Dataset as .csv and .json to allow easier import into MongoDB
   - [x] Stored in src/data folder    
  </li>
  <li>Basic functionality of the application server
  
  - [x] Setup NodeJS and Express
  - [x] Added Search Endpoint
  - [x] Added Add Endpoint
  - [x] Added Upload Endpoint
  </li>
  <li>
    Add Database class
   - [x] Added a getDB() class which connects to the MongoDatabase
   - [x] Implemented functionality for search
   - [x] Implemented functionality for adding a single record
   - [x] Implemented functionality for adding multiple records at a time
    </ul>
  </li>
  <li>Added Validation for each of the endpoints.
  
   - [x] Assumption is every field is required
   - [x] using npm package express-validator    
  </li>
  <li>Added Test Cases
  
   - [x] Test database for connection
   - [x] Test search endpoint
   - [x] Test add endpoint
   - [x] Test upload endpoint    
  </li>
 </ol>




