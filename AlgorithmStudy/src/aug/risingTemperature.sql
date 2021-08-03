##  https://leetcode.com/problems/rising-temperature/


SELECT w2.id as `id`
FROM Weather w1 JOIN Weather w2
ON
w1.recordDate = SUBDATE(w2.recordDate, INTERVAL 1 DAY) AND w2.Temperature > w1.Temperature


-- docker-compose https://hub.docker.com/_/mysql
-- EXPLAIN
SELECT w2.id as `id`
FROM Weather w1 JOIN Weather w2
ON
  w1.recordDate = SUBDATE(w2.recordDate, INTERVAL 1 DAY)
where w2.Temperature > w1.Temperature


---
Create table If Not Exists Weather (Id int, RecordDate date, Temperature int)
    Truncate table Weather
    insert into Weather (Id, RecordDate, Temperature) values ('1', '2015-01-01', '10')
    insert into Weather (Id, RecordDate, Temperature) values ('2', '2015-01-02', '25')
    insert into Weather (Id, RecordDate, Temperature) values ('3', '2015-01-03', '20')
    insert into Weather (Id, RecordDate, Temperature) values ('4', '2015-01-04', '30')
