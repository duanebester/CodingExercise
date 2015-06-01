#insert into example.employees (name, supervisor, location, salary) VALUES ('James', 1, 'TN', 80000);

#delete from example.employees where empid = 2;

insert into example.bonus (bonus, employees_empid) VALUES (2800, 8);

# People who have a bonus > 1000
select * 
from example.employees
	INNER JOIN example.bonus
	ON example.employees.empid=example.bonus.employees_empid;
#where example.bonus.bonus > 1000;

select * from employees;

#SELECT MAX(b.bonus), b.employee_empid from bonus b group by ;

SELECT e.name, e.location,
	   MAX(b.bonus) AS MaxBonus
FROM   employees e 
       LEFT OUTER JOIN bonus b ON e.empid = b.employees_empid
GROUP BY e.location;

SELECT *
FROM alldata tt
INNER JOIN
	(SELECT alldata.location, MAX(alldata.bonus) AS MaxBonus
    FROM (SELECT * 
		  FROM example.employees
		  INNER JOIN example.bonus
		  ON example.employees.empid=example.bonus.employees_empid) alldata
    GROUP BY location) grouped
ON tt.home = grouped.home 
AND tt.datetime = grouped.MaxBonus;

select DISTINCT(employees.location) 
from example.employees
	INNER JOIN example.bonus
	ON example.employees.empid=example.bonus.employees_empid;

SELECT MAX(b.bonus), e.name from bonus b, employees e group by e.location;

SELECT e.location, b.bonus AS MaxBonus
    FROM bonus b, employees e
    GROUP BY e.location;

SELECT MAX(grouped.bonus), grouped.name, grouped.location
FROM (SELECT * 
	  FROM example.employees
	  INNER JOIN example.bonus
	  ON example.employees.empid=example.bonus.employees_empid) AS grouped
Group By grouped.location;

SELECT grouped.name, grouped.location, grouped.bonus
FROM (SELECT * 
	  FROM example.employees
	  INNER JOIN example.bonus
	  ON example.employees.empid=example.bonus.employees_empid) AS grouped
	INNER JOIN
		(SELECT e.location, MAX(b.bonus) AS MaxBonus
		FROM bonus b, employees e
		GROUP BY e.location) groupedtt 
ON grouped.location = groupedtt.location 
AND grouped.bonus = groupedtt.MaxBonus;