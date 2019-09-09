# records-application
This is an application which stores a list of personal records. The application supports adding new records, and listing all records.

# Record Requirements

| Field Name | Required | Validation |
|-|-|-|
| Name | Yes | Max 25 characters |
| PPS Number | Yes | Unique | 
| Date of Birth | Yes | Format: dd/MM/yyyy. Cannot be a future date. Must be over 16 years old. |
| Mobile Number | No | Has "08" prefix |
