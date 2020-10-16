# SCIT_Task
This is a HR System which includes CRUD for relevent enities(Employee,BankDetails,Departmen,Salary) with Springboot.

## Installation

Clone the project and import/open from your IDE.
Set your userName and password to h2 database in the Application.property file.

## Todo
Image upload has implemented but has an error.
Didn't complete the pay slip part and the angular part.
Didn't Dockerize image.

##  Usage

Postman request bodyies.

for employee creation
{
	"firstName":"saj",
	"lastName":"wickramasinghe",
	"address":"matara"
}

for department creation
{
	"departmentCode":"6",
	"name":"marketing",
	"phoneNumber": "0412240511"
}

for bankDetails creation
{
	"bankCode":"025",
	"bankName":"boc",
	"branchName":"matara",
	"accountNumber": "2574924"
}

for salary creation

{
	"workingHours":"25",
	"rate":"1000",
	"salary":"25000",
	"year": "2020",
  "month": "10"
}

