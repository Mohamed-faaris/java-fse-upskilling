# Ansi Sql

ANSI SQL Using MySQL Exercises
Database Schema
1. Users
Column Name

Data Type

Constraints

Description

user_id

INT

PRIMARY KEY, AUTO_INCREMENT

Unique user identifier

full_name
email
city
registration_date

VARCHAR(100)
VARCHAR(100)
VARCHAR(100)
DATE

NOT NULL
UNIQUE, NOT NULL
NOT NULL
NOT NULL

User’s full name
User’s email
City of the user
Date when user registered

2. Events
Column
Name

Data Type

Constraints

Description

event_id

INT

PRIMARY KEY, AUTO_INCREMENT

Unique event identifier

title
description
city
start_date
end_date
status
organizer_id

VARCHAR(200)
TEXT
VARCHAR(100)
DATETIME
DATETIME
ENUM
INT

NOT NULL

Title of the event
Event description
NOT NULL
City where event is held
NOT NULL
Start date and time of event
NOT NULL
End date and time of event
('upcoming','completed','cancelled') Current status of the event
FOREIGN KEY → Users(user_id)
User who organized the
event

3. Sessions
Column Name

Data Type

Constraints

Description

session_id

INT

PRIMARY KEY, AUTO_INCREMENT

Unique session identifier

event_id
title
speaker_name
start_time
end_time

INT
VARCHAR(200)
VARCHAR(100)
DATETIME
DATETIME

FOREIGN KEY → Events(event_id)
NOT NULL
NOT NULL
NOT NULL
NOT NULL

Associated event
Title of the session
Name of speaker
Session start time
Session end time

4. Registrations

Column Name

Data Type

Constraints

Description

registration_id

INT

PRIMARY KEY, AUTO_INCREMENT

Unique registration ID

user_id
event_id
registration_date

INT
INT
DATE

FOREIGN KEY → Users(user_id)
FOREIGN KEY → Events(event_id)
NOT NULL

User who registered
Registered event
Date of registration

5. Feedback
Column Name

Data Type

Constraints

Description

feedback_id

INT

PRIMARY KEY, AUTO_INCREMENT

Unique feedback ID

user_id
event_id
rating
comments
feedback_date

INT
INT
INT
TEXT
DATE

FOREIGN KEY → Users(user_id)
FOREIGN KEY → Events(event_id)
CHECK (rating BETWEEN 1 AND 5)

User who gave feedback
Event for which feedback is given
Rating out of 5
Optional comments
Date of feedback

NOT NULL

6. Resources
Column Name

Data Type

Constraints

Description

resource_id

INT

PRIMARY KEY, AUTO_INCREMENT

Unique resource ID

event_id
resource_type
resource_url
uploaded_at

INT
ENUM
VARCHAR(255)
DATETIME

FOREIGN KEY → Events(event_id)
('pdf','image','link')
NOT NULL
NOT NULL

Associated event
Type of resource
Path or link to resource
Upload timestamp

Sample Dataset
1. Users
user_id
1
2
3
4
5
2. Events

full_name
Alice Johnson
Bob Smith
Charlie Lee
Diana King
Ethan Hunt

email
alice@example.com
bob@example.com
charlie@example.com
diana@example.com
ethan@example.com

city
New York
Los Angeles
Chicago
New York
Los Angeles

registration_date
2024-12-01
2024-12-05
2024-12-10
2025-01-15
2025-02-01

event_i
d
1

2

3

title

description

city

Tech
Innovators
Meetup
AI & ML
Conference

A meetup for
tech
enthusiasts.
Conference on
AI and ML
advancements
.
## Hands-on
training on
frontend tech.

New
York

Frontend
Developmen
t Bootcamp

Chicag
o

Los
Angele
s

start_dat
e
2025-0610
10:00:00
2025-0515
09:00:00

end_dat
e
2025-0610
16:00:00
2025-0515
17:00:00

status

complete
d

3

2025-0701
10:00:00

2025-0703
16:00:00

upcoming

2

upcoming

organizer_i
d
1

3. Sessions
session_id event_id title
1
1
Opening Keynote
2

1

3

2

Future of Web
Dev
AI in Healthcare

4

3

Intro to HTML5

speaker_name start_time
Dr. Tech
2025-06-10
10:00:00
Alice Johnson 2025-06-10
11:15:00
Charlie Lee
2025-05-15
09:30:00
Bob Smith
2025-07-01
10:00:00

end_time
2025-06-10
11:00:00
2025-06-10
12:30:00
2025-05-15
11:00:00
2025-07-01
12:00:00

4. Registrations
registration_id
1
2
3
4
5

user_id
1
2
3
4
5

event_id
1
1
2
2
3

registration_date
2025-05-01
2025-05-02
2025-04-30
2025-04-28
2025-06-15

5. Feedback
feedback_id
1
2
3

user_id
3
4
2

event_id
2
2
1

rating
4
5
3

comments
Great insights!
Very informative.
Could be better.

feedback_date
2025-05-16
2025-05-16
2025-06-11

6. Resources
resource_i
d

event_i
d

resource_ty
pe

resource_url

uploaded_
at

1

1

pdf

https://portal.com/resources/tech_meetup_agen
da.pdf

2

2

image

https://portal.com/resources/ai_poster.jpg

3

3

link

https://portal.com/resources/html5_docs

2025-0501
10:00:00
2025-0420
09:00:00
2025-0625
15:00:00

## Exercises
1. User Upcoming Events
Show a list of all upcoming events a user is registered for in their city, sorted by date.
2. Top Rated Events
Identify events with the highest average rating, considering only those that have received at
least 10 feedback submissions.
3. Inactive Users
Retrieve users who have not registered for any events in the last 90 days.
4. Peak Session Hours
Count how many sessions are scheduled between 10 AM to 12 PM for each event.
5. Most Active Cities
List the top 5 cities with the highest number of distinct user registrations.
6. Event Resource Summary
Generate a report showing the number of resources (PDFs, images, links) uploaded for each
event.
7. Low Feedback Alerts
List all users who gave feedback with a rating less than 3, along with their comments and
associated event names.
8. Sessions per Upcoming Event
Display all upcoming events with the count of sessions scheduled for them.
9. Organizer Event Summary
For each event organizer, show the number of events created and their current status
(upcoming, completed, cancelled).

10. Feedback Gap
Identify events that had registrations but received no feedback at all.
11. Daily New User Count
Find the number of users who registered each day in the last 7 days.
12. Event with Maximum Sessions
List the event(s) with the highest number of sessions.
13. Average Rating per City
Calculate the average feedback rating of events conducted in each city.
14. Most Registered Events
List top 3 events based on the total number of user registrations.
15. Event Session Time Conflict
Identify overlapping sessions within the same event (i.e., session start and end times that
conflict).
16. Unregistered Active Users
Find users who created an account in the last 30 days but haven’t registered for any events.
17. Multi-Session Speakers
Identify speakers who are handling more than one session across all events.
18. Resource Availability Check
List all events that do not have any resources uploaded.
19. Completed Events with Feedback Summary
For completed events, show total registrations and average feedback rating.
20. User Engagement Index
For each user, calculate how many events they attended and how many feedbacks they
submitted.
21. Top Feedback Providers
List top 5 users who have submitted the most feedback entries.
22. Duplicate Registrations Check
Detect if a user has been registered more than once for the same event.
23. Registration Trends
Show a month-wise registration count trend over the past 12 months.
24. Average Session Duration per Event
Compute the average duration (in minutes) of sessions in each event.

25. Events Without Sessions
List all events that currently have no sessions scheduled under them.