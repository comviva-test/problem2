# Description:
Enhance the previous program, so that it also saves in a new record of a table using plain JDBC in a
MySQL database:

* the file path
* the result of the addition
* the timestamp at program execution

# Objective:
Evaluate JDBC library knowledge, SQL language and programming style.
# Table format: 
* FILENAME VARCHAR (128)
* FILEVALUE FLOAT
* PROCESSDATE TIMESTAMP

# Important notes: 
the program must create the table automatically if it does not exist in its
first run. The program code must use standard ANSI-SQL (not propietary SQL code) to
perform SQL operations. The connection string, user name and password to connect to
database must be configurable in an external text file (.properties or .xml ).


# Precondition
* The Server MySQL must be running.
* The DB must be created (for example comviva)


# Configuration:
* In application.properties file are setup the db configuration.
* Run App.java from java application.


