# ICD10-REST

A RESTful API that can allow us to utilize an internationally recognized set of diagnosis codes. 

**This HTTP/S API provides the following:**

* All endpoints are accessible via a swagger interface 
* Creates a new diagnosis code record
* Edits an existing diagnosis code record 
* Lists diagnosis codes in batches of 20 (and paginate through the rest of the record) 
* Retrieves diagnosis codes by ID 
* Deletes a diagnosis code by ID
* Creates a login /registration system○The registration process will require email and password○Forgot password○Change password○Password should be encrypted in the db
* Generates a Basic authentication token that will be use to authenticate the user when he make a request ○Whenever a user is hitting any endpoint,the ba token needs to be added to the request
