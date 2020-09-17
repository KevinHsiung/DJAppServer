# Application Server Challenge


## Prerequisites :
The following needs to be installed
<ul>
  <li>NodeJS</li>
  <li>MongoDB</li>  
</ul>

## Getting Started:
Run `npm install` to install the npm packages


## Approach to solving the problem

<ol>
  <li>
    Get the initial Down Jones Dataset. <a href='http://archive.ics.uci.edu/ml/datasets/Dow+Jones+Index#'>Dow Jones Dataset</a>
    <ul>
        <li>Saved Dataset as .csv and .json to allow easier import into MongoDB</li>
        <li>Stored in NodeServer/data folder</li>
    </ul>
  </li>
  <li>Basic functionality of the application server
    <ul>
        <li>Setup NodeJS and Express</li>
        <li>Added Search Endpoint</li>
        <li>Added Add Endpoint</li>
        <li>Added Upload Endpoint</li>
    </ul>
  </li>
  <li>
    Add Database class
    <ul>
        <li>Added a getDB() class which connects to the MongoDatabase</li>
        <li>Implemented functionality for search</li>
        <li>Implemented functionality for adding a single record</li>
        <li>Implemented functionality for adding multiple records at a time</li>
    </ul>
  </li>
  <li>Added Validation for each of the endpoints. Assumption is every field is required</li>
  <li>Added Test Cases
    <ul>
        <li>Test database for connection</li>
        <li>Test search endpoint</li>
        <li>Test add endpoint</li>
        <li>Test upload endpoint</li>
    </ul>
  </li>
 </ol>

## Application server

Run `node app.js` inside the Node folder to start the application server. Application server is hosted at `http://localhost:8081/`.

Optional: Add Optional Parameter `--reseed` to reseed the collection. 

## Running tests

Run `npm test` inside the Node Folder to execute the test cases defined in the "Test" folder;

Note: The application server should be stopped before running "npm test" otherwise the port will be in use and the test will fail.

Testing technologies used
<ul>
<li>Mocha</li>
<li>chai</li>
<li>chai-http (to make http requests)</li>
<li>chai-spies (to mock db calls)</li>
<li>rewire (to modify modules to inject chai-spies) </li>
</ul>

