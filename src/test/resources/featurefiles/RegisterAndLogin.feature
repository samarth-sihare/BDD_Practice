Feature: User should be able to register in website using any valid email address
	User should be able to register to the website as Seller, Buyer or Both
	He should be able to create a free Account using folloing information
		- Email Address
		- Password (Password must be at least 6 characters in length, and a combo of letters and numbers.)
		- User should be asked to confirm Password
		- Phone Number (Optional)
		- Option to select Seller or Buyer or Both
		- Should be able to opt for Alerts for information and services.
		
	Rules: 
		- Validation for valid email address
		- Validation for valid password and confirm password 
		- Validation for following mandatory fields
			* Email Address
			* Password and Confirm Password
			* User role option (Seller or Buyer or Both)
	
	Background: Navigate to Register Page
		Given the user is on FSBO Landing Page
		And he navigates to register page
		
	@test
	Scenario Outline: Email Validation
		When user tries to create account with email as "<Email Address>"
		And he enters the password as "<Password>" and confirms the password as "<Password>"
		And selects role as "<User Role>"
		And requests to register
		Then he should see validation message for "<Valid or Invalid>"   
		
		Examples: invalid email addresses. Users keywords for Valid or Invalid column- validEmail, invalidEmail
			| Email Address		| Password		| User Role		| Valid or Invalid	|
#			| invalidemail		| abcd123		| Seller		| invalidEmail		|
#			| invalidemail		| abcd123		| Buyer			| invalidEmail		|
			| invalidemail		| abcd123		| Both			| invalidEmail		|
			| invalid@email		| abcd123		| Seller		| invalidEmail		|
			| invalid.email		| abcd123		| Both			| invalidEmail		|
			| @email.com		| abcd123		| Buyer			| invalidEmail		|
			| invalid@email.	| abcd123		| Buyer			| invalidEmail		|
			| invalid@email@	| abcd123		| Buyer			| invalidEmail		|
			| 					| abcd123		| Buyer			| requiredEmail		|