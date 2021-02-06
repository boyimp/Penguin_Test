<-- MICROSOFT SQL SERVER SQL QUERY -->

<-- 1. List all course.name and teachers.name -->
SELECT courses.name,
	   teachers.name
FROM courses,
	 teachers
Where courses.teacher_id = teachers.id;

<-- 2.List teachers who take the highest number of courses -->
WITH temp_table AS(
	SELECT count(*) AS total , courses.teacher_id
	FROM courses
	GROUP BY courses.teacher_id
	)
	SELECT *
	FROM temp_table
	WHERE total = (
	SELECT max(total)
	FROM temp_table
	);

<-- 3. List teachers who don't take any course -->
SELECT *
    FROM teachers
    WHERE teachers.id = (
    SELECT teachers.id
    FROM teachers
    EXCEPT
    SELECT courses.teacher_id
    FROM courses
    );
