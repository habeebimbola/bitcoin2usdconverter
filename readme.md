# BitCoin To USD Converter Project

### This Project Provides BitCoin To USD Converter Relying On Services Provided By 3rd Party.

* To Build The Project, run the gradlew wrapper script with the build argument.
* Application Should Is Accessible at http://hostname:9000
* Run Program as follows : java -jar nameofjar.jar produced in build directory.
* /rate and /rateBetween endpoints are provided:
* /rate handler is an HTTP GET request
* /rateBetween handler is an HTTP POST request with JSON request parameters like so: {"fromDate":"2012-03-02","endDate":"2022-01-02"}