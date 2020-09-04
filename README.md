# ExaminationsGame
##Motivation


##Rules

A matrix K x L represents the examination room divided in K rows and L columns in such way
that one matrix cell will be occupied by a Student or a Walkway.

In the game there are also some supervisors whose sole purpose is to catch the cheaters.
The number of supervisors varies according to the course's difficulty(i.e. easier courses have more students which means more supervisors)
They walk on the walkways, and they have a vision range in which they can catch the cheaters(i.e. they can't spot a person from across the room).
Their speed also varies according to the proffessor's instructions (now called proffessors attitude).
If they catch a cheater the game ends.

Among the students are some malicious Students who want to cheat their way out of the test.
The students have some sense and do not start to cheat right away but their cheating chance increases as time goes on.

A typical examination lasts 180 minutes and it will be divided in 360 rounds(called ticks from now on).
In each tick a student will either cheat or do nothing and if he manages to do it for at least 4 ticks (i.e. 2 minutes) we consider that he cheated his way through the test 
and will not cheat again.

In the end the algorithm keeps a record of the cheaters' position and marks them accordingly if they won or not.


We will run each game approximately k times (k TBD) to see whether some statistically results apply.
