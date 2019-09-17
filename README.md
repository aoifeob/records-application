# records-application
This is an application which stores a list of personal records. The application supports adding new records, and listing all records.

# Record Requirements

| Field Name | Required | Validation |
|-|-|-|
| Name | Yes | Max 25 characters |
| PPS Number | Yes | Unique | 
| Date of Birth | Yes | Format: dd/MM/yyyy. Cannot be a future date. Must be over 16 years old. |
| Mobile Number | No | Has "08" prefix |

# Execution Instructions (Mac)
Requirements: Java 8, Maven

1. Clone the repository to your local machine.
2. Run `mvn clean install`. Unit tests will be run with output printed to the terminal. Unit tests can also be run through IntelliJ.
3. Open the project in Intellij. Select the RecordApplication configuration and click debug. The service will start on localhost:8080.
4. Navigate to `localhost:8080` to view the index page. Navigate to `localhost:8080/add-record` (or click the link on the index page) to add a new record. Navigate to `http://localhost:8080/list-records` (or click the link on the index page) to list all records. Adding a new record successfully will also load the list all records page.
