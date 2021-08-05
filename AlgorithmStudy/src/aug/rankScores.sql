# https://leetcode.com/problems/rank-scores/

Create table If Not Exists Scores (Id int, Score DECIMAL(3,2))
    Truncate table Scores
    insert into Scores (Id, Score, dept) values ('1', '3.5')
    insert into Scores (Id, Score, dept) values ('2', '3.65')
    insert into Scores (Id, Score, dept) values ('3', '4.0')
    insert into Scores (Id, Score, dept) values ('4', '3.85')
    insert into Scores (Id, Score, dept) values ('5', '4.0')
    insert into Scores (Id, Score, dept) values ('6', '3.65')


SELECT
    score, (?????) as `RANK`
FROM Scores

SELECT score, DENSE_RANK() OVER (
    PARTITION dept
    ORDER BY score desc
)
as 'Rank'
FROM Scores
==> {"headers": ["score", "Rank"], "values": [[4.00, 1], [4.00, 1], [3.85, 2], [3.65, 3], [3.65, 3], [3.50, 4]]}

SELECT score, RANK() OVER (
    ORDER BY score desc
)
as 'Rank'
FROM Scores
=> {"headers": ["score", "Rank"], "values": [[4.00, 1], [4.00, 1], [3.85, 3], [3.65, 4], [3.65, 4], [3.50, 6]]}


select Score as score,
       (select count( distinct score)+1 from Scores where score>s.score) 'Rank'
from Scores S
order by Score  desc;