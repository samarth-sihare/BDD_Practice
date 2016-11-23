Feature: Display How Selling By Owner Works using steps time-line
	As a Seller I should be able to know all the steps to sell property
	I should be able to see steps before enrolling in the website
	The steps should be displayed in a sequential manner 
	
	Rules:
		Step 1: Deciding to Sell
		Step 2: Preparing & Repairing
		Step 3: Marketing
		Step 4: Negotiating Your Sale
		Step 5: Closing
		
	Background: Navigate to home page of website
		Given the user is on FSBO Landing Page
	 
	Scenario Outline: View Steps by navigating using step number in Step Time Line
		When user navigates to step number "<Step Number>" on step time line 
		Then he should be able to see details as "<Step detail Title>" for step "<Step Nnumber>"

		Examples: Checking sequentially
			| Step Number	 | Step detail Title				 |
			| 1				 | Step 1: Deciding to Sell			 |
			| 2				 | Step 2: Preparing & Repairing	 |
			| 3				 | Step 3: Marketing				 |
			| 4				 | Step 4: Negotiating Your Sale	 |
			| 5				 | Step 5: Closing					 |

	Scenario Outline: View Steps by step navigation arrow button
		When user is on step number "<Step Number>" on step time line
		And he navigates using <Arrow Navigation> arrow button 
		Then he should be able to see details as "<Step detail Title>" for step "<New Step>"
		
		Examples: Using next arrow navigation button
			| Step Number	| Arrow Navigation | New Step | Step detail Title				 |
			| 1				| next			   | 2		  | Step 2: Preparing & Repairing	 |
			| 2				| next			   | 3		  | Step 3: Marketing				 |
			| 3				| next			   | 4		  | Step 4: Negotiating Your Sale	 |
			| 4				| next			   | 5		  | Step 5: Closing					 |
	
		Examples: Using previous arrow navigation button
			| Step Number	| Arrow Navigation | New Step | Step detail Title				 |
			| 2				| previous		   | 1		  | Step 1: Deciding to Sell		 |
			| 3				| previous		   | 2		  | Step 2: Preparing & Repairing	 |
			| 4				| previous		   | 3		  | Step 3: Marketing				 |
			| 5				| previous		   | 4		  | Step 4: Negotiating Your Sale	 |
	