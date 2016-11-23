@PackageListing
Feature: Display Listing Packages as per entered zip code	
	As a customer,
	I want to view packages offered by FSBO website based on ZIP code provided 

	Rules:
		- 97024 (Free Listing should be visible in first package column)
		- 80302 (MLS Enhanced should be visible in fourth package column)
		- 82710 (Multi-Media should be visible in third package column)
		- For outside US and Canada (7-Day Free Trial and Standard should be visible)

	Background: Navigate to zip code form for package listing
	  Given the user is on FSBO Landing Page
	  And he navigates to view listing packages 
	
	@PackageListing-Simple	
 	Scenario: View listing packages for the ZIP Code that offer Free Listing package
		When he enters "97024" as zip code
		And submits the request to view package listing
		Then he is able to view Free Listing package in first column
	
	@PackageListing-Simple
	Scenario: View listing packages for the ZIP Code that offer MLS Enhanced package
		When he enters "80302" as zip code
		And submits the request to view package listing
		Then he is able to view MLS Enhanced package in fourth column
	
	@PackageListing-Simple
	Scenario: View listing packages for the ZIP Code that offer Multi-Media package
		When he enters "82710" as zip code
		And submits the request to view package listing
		Then he is able to view Multi-Media package in third column
		
	@PackageListing-Simple
	Scenario: View listing packages for areas outside US or Canada
		When he navigates to Lising Packages Outside US or Canada
		Then he is able to view "7-DAY FREE TRIAL" Listing package in first column
		And he is able to view "STANDARD" Listing package in second column

	@PackageListing-DataDriven 
	Scenario Outline: View listing packages according to ZIP Code provided
		When he enters "<zip_code>" as zip code
		And submits the request to view package listing
		Then he is able to view "<first_package>" Listing package in first column
		And he is able to view "<second_package>" Listing package in second column
		And he is able to view "<third_package>" Listing package in third column
		And he is able to view "<fourth_package>" Listing package in fourth column
		
	Examples: Package listing details (Expecting 4 Packages)
	| zip_code | first_package			| second_package | third_package | fourth_package |  
	| 97024	   | FREE					| STANDARD 		 | DELUXE  		 | MLSENHANCED	  |
	| 80302	   | 7-DAY FREE TRIAL		| STANDARD 		 | DELUXE  		 | MLSENHANCED	  |
#	| 82710	   | 7-DAY FREE TRIAL		| STANDARD 		 | MULTI-MEDIA	 | Does Not Exist |
	#We Can Ignore the error "missing EOF at 'Examples:'" shown by IDE, this is due to a bug in plugin "Natural"
#	Examples: Package listing details (Expecting 3 Packages)
#	| zip_code | first_package			| second_package | third_package | fourth_package |  
#	| 82710	   | 7-DAY FREE TRIAL		| STANDARD 		 | MULTI-MEDIA	 | Does Not Exist |
	
	
	