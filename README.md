# ExaminationsGame
A short and simple Monte Carlo simulation.
## Motivation
Several accusations have been made that students will try to cheat in the exams if given the chance.

In this little project we investigate whether these accusations hold by trying to simulate the events.

## Rules

A matrix K x L represents the examination room divided in K rows and L columns in such way
that one matrix cell will either be occupied by a Student,a Walkway or a Column.

In this game there are also some supervisors whose sole purpose is to catch the cheaters.
The number of supervisors varies according to the course's difficulty(i.e. easier courses have more students which means more supervisors).
They walk on the walkways, and they have a vision range in which they can catch the cheaters(i.e. they can't spot a person from across the room).

To try and make things as realistic as possible I've decided to include columns which hide significantly the vision of a supervisor (or a professor).
We consider a student to be visible to the supervisor if he is at least 40% visible (number TBD) given the field of view of the latter.

Among the students are some malicious Students who want to cheat their way out of the test.
Those students  do not start to cheat right away but their cheating chance increases as time goes on.

A typical examination lasts 180 minutes, and it will be divided in 360 rounds - this means 30" intervals (called ticks from now on).
In each tick a student will either cheat or do nothing and if he successfully cheats for 4 ticks (i.e. 2 minutes) we consider that he passed the test 
and will not cheat again.

The game ends if a cheater is discovered.


In the end the algorithm keeps a record of the cheaters' position and marks them accordingly if they won or not.


We will run each game approximately n times (n TBD) to see whether some statistically significant results apply.

### Contribute
Pull requests and forks are more than welcome for this one-person team!
If you have any question feel free to open an issue on Github and I'll get back as soon as possible. 

Cheers!

Thanos
