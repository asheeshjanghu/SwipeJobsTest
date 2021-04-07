# SwipeJobsTest

Task: Expose an API which can take a worker Id and return a list of matching jobs.

Given: 
1. A workers api which provides all the workers list who are looking for jobs.
2. A jobs api which provides all the jobs available in the market.

Business Requirements: 
The jobs returned through the api must be the jobs which match closest to the requirement of the worker.

Algorithm:
Here I have used following parameters to decide whether a job is a good fit for worker or not:
1. If the job requires the driver licence or not and if the worker has licence or not.
2. Whether the job is within the preferred distance of worker.
3. Whether the worker has the required certificates asked by the job requirements.
4. Whether the skills of the worker match with the skills required in the job.

In the end we sort these matching jobs based on the billing rate,
which means we give the highest priority to the job which pays highest amongst matching jobs.

After this we take top N (3) jobs and return it to the user.

If none of the jobs match with the worker requirements we return empty list to the worker.

API endpoint
`${baseurl}/api/jobs/{workerId}` 

Sample request:
http://localhost:8080/api/jobs/10

Sample Response:

```[
{
"driverLicenseRequired": true,
"requiredCertificates": [
"Healthy Living Promoter"
],
"location": {
"longitude": "13.59357",
"latitude": "50.015609"
},
"billRate": "$17.80",
"workersRequired": 5,
"startDate": "2015-10-31T13:59:33.122Z",
"about": "Aliqua dolor sunt aliquip ad esse Lorem duis irure reprehenderit nisi in consequat excepteur esse. Elit nulla elit eiusmod incididunt consectetur aute. Magna culpa magna enim irure duis in cupidatat minim. Dolore magna dolore ullamco ex duis non aliquip ullamco amet dolore ea esse qui. Occaecat aliquip ipsum voluptate culpa excepteur adipisicing.",
"jobTitle": "Creator of opportunities",
"company": "Kyagoro",
"guid": "562f66aab8e4c3f2a1594c93",
"jobId": 21
},
{
"driverLicenseRequired": true,
"requiredCertificates": [
"Office Lunch Expert"
],
"location": {
"longitude": "14.134019",
"latitude": "49.819042"
},
"billRate": "$12.42",
"workersRequired": 3,
"startDate": "2015-10-29T15:50:29.797Z",
"about": "Ex anim et eiusmod occaecat cupidatat dolor. Occaecat mollit nisi nulla nisi aliqua sint elit fugiat pariatur incididunt laboris. Nulla minim ad eu ullamco aute minim occaecat excepteur minim quis do aliquip aliquip. Voluptate do sit proident occaecat. In aliquip quis eiusmod commodo. Veniam occaecat officia do nulla fugiat laboris adipisicing labore officia. Exercitation et cupidatat qui qui aliquip commodo nisi aliquip aliquip nulla eu do non non.",
"jobTitle": "Chief Amazement Officer",
"company": "Perkle",
"guid": "562f66aa66f3026d02651040",
"jobId": 6
},
{
"driverLicenseRequired": true,
"requiredCertificates": [
"Calm in the Eye of the Storm",
"Healthy Living Promoter",
"Outside the Box Thinker"
],
"location": {
"longitude": "15.039813",
"latitude": "49.822659"
},
"billRate": "$8.97",
"workersRequired": 4,
"startDate": "2015-11-26T14:51:01.317Z",
"about": "Sit aute ad proident aliquip qui nulla tempor minim culpa. Amet dolore cupidatat et dolore minim adipisicing non Lorem laborum velit aliqua commodo quis enim. Dolore Lorem aliqua qui ex commodo laboris ut officia consectetur. Proident ea labore labore do exercitation commodo quis sint pariatur incididunt cillum ullamco. Laborum consequat occaecat eiusmod esse Lorem.",
"jobTitle": "Chief Amazement Officer",
"company": "Digifad",
"guid": "562f66aaecad02a760fe2e55",
"jobId": 16
}
]```


