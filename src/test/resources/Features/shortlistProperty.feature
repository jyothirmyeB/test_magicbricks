Feature: Shortlist property from listing page
Background:
     Given the user is on the property listing page
#TS_MB_09,TS_MB_10     
Scenario: Verify shortlisting a property from the listing results
And clicks on sortby and selects high to low filter
When I shortlist the first property from the listing
And I view the shortlisted properties
