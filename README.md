Project Structure
The project is divided into several components:

**Model:**
- GuestBookEntry: This class represents a single entry in the guest book. Each entry has an ID, a name, and a message. The idSeed static variable ensures that each entry has a unique ID.

**Servlets:**
- GuestBook: The main servlet that displays all guest book entries. It initializes with some default entries and provides a user interface to view the entries.
- EditEntry: This servlet allows users to edit an existing guest book entry. It retrieves the entry by ID and displays a form for updating the name and message.
- DeleteEntry: This servlet handles the deletion of a guest book entry. It removes the entry from the list based on the ID provided in the request.
- AddComment: This servlet allows users to add a new entry to the guest book. It displays a form for the user to enter their name and message.
  
**Key Features**
- Initialization: The GuestBook servlet initializes with a couple of default entries to demonstrate functionality.
- CRUD Operations: Users can create new entries, read all entries, update existing entries, and delete entries.
- User Interface: The servlets generate HTML dynamically to provide a simple and intuitive interface for interacting with the guest book.
  
**How It Works**
- Adding an Entry: Users can navigate to the "Add Comment" page, fill out the form, and submit it to add a new entry to the guest book.
- Editing an Entry: Each entry in the guest book has an "Edit" link. Clicking this link takes the user to a form where they can update the name and message of the entry.
- Deleting an Entry: Each entry also has a "Delete" link. Clicking this link removes the entry from the guest book.
- Viewing Entries: The main guest book page displays all entries in a table format, with options to edit or delete each entry.
  
**How to Run**
- Setup: Ensure you have a Java Servlet container (e.g., Apache Tomcat) set up.
= Deployment: Deploy the application on your servlet container.
- Access: Navigate to the application URL (e.g., http://localhost:8080/GuestBook) to interact with the guest book.
This project is a straightforward example of using Java Servlets to create a web application with basic CRUD functionality, providing a foundation for more complex web applications.
