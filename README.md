# ticketBookingCPSC304


# Steps to setup project:
1. Clone this repo
2. Create a new local instance on MySQL
3. Create a schema named "ticketBooking" in that instance.
4. Copy your MySQL instance username and password into the static member variables username and password in the utils/MySqlConnection file.
5. Run the provided SQL Dump file in your instance to prepopulate the tables.
6. Run the Main.java file.


# SQLDump
There is a sqlDump file, run this script in your MySQL manager to create the tables and prepopulate them.

# Components 
Components go inside the view package. Look at the selectPanel for an example. <br>


# Queries
New Queries go inside the MySqlConnection static class (in "utils/MySqlConnection"). Create a static method representing the query so that an object class does not have to be instantiated

# Console Element
There is a console element in our jFrame for the UI. Anything that is System.out.println() will be outputted in that console element. This is to make it easier to display query results
