# achiverjournal
AchieverJournal is an application in which a user may electronicaly journal their day and view all of their electronically recorded journal entries.

## How to run the app (frontend)
The app is hosted at the URL: http://azizaamino.com/?#/journal however, can be run localy by the following steps
1. Fork or download the app folder in the repository
2. Run the npm install command in the achiverjournal directory
3. Run the following command `serve -s build` to host the site locally (will appear at http://localhost:5000/?#/journal so long as no other programing is using the 5000 port).
## How to run the app (backend)
There are two backend components that are hosted on AWS Beanstalk. The AchieverJournal API handles retrieves all journal entries for viewing from the Postgresql database (hosted on AWS EC2) and the JournalEntry API handles retrieves specific journal entries with the specific components (http://achieverjournal-env.eba-2ezdz2u2.us-east-1.elasticbeanstalk.com for requests made to the AchieverJournal component and http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com for requests made to the Journale Entry component). Both components can be run locally in the following steps:
1. Fork or downlocad the app folder in the repository
2. Go to the backendcode directory where both components folders reside.
3. Make sure maven and jvm are installed. If maven is not installed, download maven from the following link https://maven.apache.org/download.cgi and configure the package based on the instructions here https://maven.apache.org/install.html pertaining towards your OS.
4. Both components are configured to run on port 5000 in the application.yml files in both components. This can be changed to any available port to avoid conflicts by changing the port number within the application.yml file.
5. The two components may then be run with the play/run button of the used IDE or, both can be compiled to jar files using the mvwn command and run with the commands  `java -jar executable.jar` where the executable.jar is the compiled jar file for the components.
## How to write entries
1. Click on top button of the pages saying `Being Writing Towards Your Goals!`
2. Write a Title for the entry in the text box saying `ENTRY TITLE`
3. Write the entry contents in the text box below `ENTRY TITLE` text box.
4. Click the Edit button below to submit the entry.
5. Click the `Back to Entries` button to see the entry appear on the list of journal entires on the user journal entires page.
## User Stories
 - As an *Achiever, I want to be able to write journal entries so that I may be electronicaly recorded
 - As an *Achiever, I want to be able to edit previously entered journal entries so that I may be able to revise old journal entries records 
 - As an *Achiever, I want to be able to delete prevoiusly entered journal entries so that I may be ablte to remove old journal entry records
 * an Achiever, is the actor in these scenarios
## Features
 - Write Journal Entries
  - Journal entry content (title,text,date) is sent to backend and recorded to database
 - Edit Journal Entries
  - A journal entry's title and/or text will be updated and a new date would be registered in the backend
 - View all journal entries
  -A journal entry's title, date of last of update, and link to text content are viewable from the journal page along with all other journal entries stored in the database.
  -*View journal entry tags
    - View tags created from a journal entry's text based on parts of speech on the journal entry page under the the box with the heading `WHAT'S ON YOUR MIND!`.
    *feature is commented out due to java heap space issues when hosting the backend on aws however, should working perfectly fine hosting localy.
  -Delete journal entires
    - A journal entry will be deleted from the journal entry database
## Dependencies
  -Spring boot
  -Maven
  -Node
  -Postgresql
  
