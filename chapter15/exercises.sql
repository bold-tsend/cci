# 15.1
select * from tenants join apttenants on apttenants.TenantID = tenants.TenantID 
group by tenants.TenantID having count(*) > 1;

# 15.2
select Buildings.BuildingName, count(Buildings.BuildingName) from Requests join Apartments on Requests.AptID = Apartments.AptID
join Buildings on Buildings.BuildingID = Apartments.BuildingID group by Buildings.BuildingName;

# 15.3 (Instead of building #11 building name (Building 2) is used) 
# Select query to find affected rows for testing 
select * from Requests left join Apartments on Requests.AptID = Apartments.AptID join Buildings on 
Buildings.BuildingID = Apartments.BuildingID where Buildings.BuildingName = 'Building 1';
# Update statement that actually flips status to 'closed' if 'open'
update Requests left join Apartments on Requests.AptID = Apartments.AptID join Buildings on 
Buildings.BuildingID = Apartments.BuildingID set Requests.status = 'closed' where Buildings.BuildingName = 'Building 1'
and Requests.status = 'open';

# 15.4 (Grades are 1 best to 5 worst)

select SName, GPA from (
	select Students.StudentName as SName, AVG(CourseEnrollment.Grade) as GPA from Students join CourseEnrollment 
	on Students.StudentID = CourseEnrollment.StudentID group by students.StudentID
) as gpas
where GPA <= (
	# Hack to get last grade of best 10% of students
	select max(gpa) from (
		select *, @counter := @counter + 1 counter from 
		(select @counter := 0) initvar, 
			(
				select AVG(CourseEnrollment.Grade) as gpa
				from students join CourseEnrollment on 
				students.StudentID = CourseEnrollment.StudentID 
				group by students.StudentID order by gpa asc
			) as tmp 
		) as tmp2 
	where counter <= GREATEST(0.1 * @counter, 1)
) order by GPA asc;
