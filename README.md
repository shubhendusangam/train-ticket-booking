Requirement
-
-----------
Board a train from London to France.The train ticket will cost $20.
-

Create API where you can submit a purchase for a ticket.
-
        Purchase Ticket

        Endpoint: /api/purchase-ticket 
        Method: POST 
        Description: Submits a purchase for a train ticket.
        
        Request Body
        {
            "firstName": "string",
            "lastName": "string",
            "email": "string",
            "section": "string"  // "A" or "B"
        }
 
        Response
        {
            "id": "number",
            "fromLocation": "London",
            "toLocation": "France",
            "price": 20.0,
            "section": "string",
            "user": {
                "id": "number",
                "firstName": "string",
                "lastName": "string",
                "email": "string"
            }
        }
---

Create An API that shows the details of the receipt for the user Details included in the receipt are: 
-
- From, To, User, price paid.
- User should include first and last name, email address.
- The user is allocated a seat in the train. Assume the train has only 2 sections, section A and section B. 

        Purchase Ticket

        Endpoint: /api/receipt/{ticketId} 
        Method: GET 
        Description: Retrieves the details of the receipt for the specified ticket ID.
        Path Parameter: ticketId (number): The ID of the ticket.
        
        Response
        {
          "id": "number",
          "fromLocation": "London",
          "toLocation": "France",
          "price": 20.0,
          "section": "string",
          "user": {
              "id": "number",
              "firstName": "string",
              "lastName": "string",
              "email": "string"
          }
        }

---
Create an API that lets you view the users and seat they are allocated by the requested section. 
-
    Endpoint: /api/user-by-section/{section}
    Method: GET
    Description: Retrieves the list of users and the seats they are allocated by the requested section.
    
    Path Parameter: section (string): The section of the train, either "A" or "B".
    
    Response
    [
        {
            "id": "number",
            "fromLocation": "London",
            "toLocation": "France",
            "price": 20.0,
            "section": "string",
            "user": {
                "id": "number",
                "firstName": "string",
                "lastName": "string",
                "email": "string"
            }
        },
    ...
    ]

---
Create an API to remove a user from the train.
-
    Endpoint: /api/remove-user/{ticketId} 
    Method: DELETE 
    Description: Removes the user associated with the specified ticket ID from the train.
    
    Path Parameter: ticketId (number): The ID of the ticket.

    Response : 204 No Content    
---
Create an API to modify a user's seat.
-
    Endpoint: /api/modify-seat/{ticketId} 
    Method: PUT 
    Description: Modifies the user's seat for the specified ticket ID.
    
    Path Parameter: ticketId (number): The ID of the ticket.
    
    Request Body
    {
        "newSection": "string"  // "A" or "B"
    }


    Response
    {
        "id": "number",
        "fromLocation": "London",
        "toLocation": "France",
        "price": 20.0,
        "section": "string",
        "user": {
            "id": "number",
            "firstName": "string",
            "lastName": "string",
            "email": "string"
        }
    }
---