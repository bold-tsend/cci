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


