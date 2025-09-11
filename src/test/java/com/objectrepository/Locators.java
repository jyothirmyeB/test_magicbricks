package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	 public static By homeLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/a");
	 public static By innerLoginBtn = By.xpath("//*[@id=\"commercialIndex\"]/header/section[1]/div/div[2]/div[2]/div/div[2]/a");
	 public static By googleLoginBtn = By.xpath("//*[@id=\"my-signin2\"]/div/div");
	 public static By phonenumber = By.xpath("//*[@id=\"emailOrMobile\"]");
	 public static By nextbtn = By.id("btnStep1");
	 public static By captacha = By.xpath("//*[@id=\"captchaCodeSignIn\"]");
	 public static By otp1 = By.id("verify01");
	 public static By otp2 = By.id("verify02");
	 public static By otp3 = By.id("verify03");
	 public static By otp4 = By.id("verify04");
     public static By continuebtn = By.xpath("//*[@id=\"verifyOtpDiv\"]/div[2]/div[3]/button");
     public static By closepopup = By.xpath("//*[@id=\"userOnboardingWidget\"]/div/div[1]");
    
     public static By enterlocation = By.xpath("//*[@id=\"keyword\"]");
     public static By clickPropertType = By.id("propType_buy");
     public static By selectdropdownloc =By.xpath("//*[@id=\"serachSuggest\"]/div[2]/span");
     public static By clearPropertyType = By.xpath("//*[@id=\"propType_buy\"]/div[2]/div/div/div[1]/div[2]/div[4]");
     public static By dropdownProperType = By.xpath("//*[@id=\"propType_buy\"]/div[1]");
     public static By selectPropertyType = By.id("10002_10003_10021_10022");
     public static By closePropertyType = By.xpath("//*[@id=\"buy_proertyTypeDefault\"]");
     
     public static By clickBudget = By.id("rent_budget_lbl");
     //public static By dropdownBudget = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[3]/div[1]");
     public static By minPrice = By.xpath("//*[@id=\"budgetMin\"]");
     public static By maxPrice = By.xpath("//*[@id=\"budgetMax\"]");
     public static By closeBudget = By.xpath("//*[@id=\"rent_budget_lbl\"]"); 
     public static By searchButton = By.xpath("//*[@id=\"searchFormHolderSection\"]/section/div/div[1]/div[3]/div[4]");
     
     public static By sortBy = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div[1]");
     public static By hightolow = By.xpath("//*[@id=\"body\"]/div[5]/div/div/div[1]/div[1]/div/div[2]/ul/li[3]");
     public static By shortlistButton = By.xpath("//*[@id=\"cardid80691623\"]/div/div[1]/div[2]/span[2]");
     public static By mainshortlistbtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/span");
     public static By viewShortlistBtn = By.xpath("//*[@id=\"propertysrp\"]/div[1]/div/div/div[2]/div[5]/div/div/a");
    // public static By shortlistedPropertyCard = By.xpath("//*[@id=\"cardid81306751\"]/div[2]/div[1]");
     public static By shortlistTabHeader = By.xpath("//*[@id=\"m-tab-Shortlisted\"]");
    // public static By contactagent = By.xpath("//*[@id=\"contactRightInfo\"]");
     
  // New locators for Tips & Growth page
     public static final By buyOption = By.xpath("//*[@id=\"shortlistWeb\"]/div[1]/div/div/div[1]/div[2]/span");
     public static final By tipsAndGrowthTab = By.xpath("//*[@id=\"shortlistWeb\"]/div[1]/div/div/div[1]/div[2]/div/div/div[5]/ul/li[4]/a");
     public static final By exploreLocationBox = By.xpath("//*[@id=\"locExplore\"]");
     public static final By exploreButton = By.xpath("//*[@id=\"exploreSection\"]/div/div[2]/div[2]/div[2]/input");
     public static final By tipsAndGrowthPageRating = By.xpath("//*[@id=\"idOverview\"]/div[1]/div[2]/span");
    // for compare on tips and growth
     public static final By buyButton = By.xpath("//*[@id=\"buyheading\"]");
     public static final By tipsAndGrowthTabNew = By.xpath("//*[@id=\"header-buy-drop\"]/div/div/div/div[5]/ul/li[4]/a");
     public static final By compareTab = By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a");
     public static final By firstLocationInput = By.xpath("//*[@id=\"locOne\"]");
     public static final By secondLocationInput = By.xpath("//*[@id=\"locTwo\"]");
     public static final By compareButtonNew = By.xpath("//*[@id=\"localities\"]/div/div[4]/input");
     public static final By ratingOne = By.xpath("//*[@id=\"rating_1_0\"]/div[1]/div/div[1]/span[1]");
     public static final By ratingTwo = By.xpath("//*[@id=\"rating_2_0\"]/div[1]/div/div[1]/span[1]");
     
  // New locator for invalid location error message
     public static By locationErrorMessage = By.xpath("//*[@id=\"location-error-id\"]");
     public static By crossloc =By.xpath("//*[@id=\"keyword_autoSuggestSelectedDiv\"]/div/div[2]");
     
  //new locators for invalid explore locality
     public static By Buybar = By.xpath("//*[@id=\"buyheading\"]"); 
     //public static By tipsandguidesbar = By.xpath("//*[@id=\"swiper-wrapper-3663ab210846eee45\"]/div/div[5]/ul/li[4]/a");
     public static By errormessage = By.xpath("//*[@id=\"locExploreEmpty\"]");
     public static final By tipsAndGrowthButton = By.linkText("Tips and Guides");
  //locators for invalid compare locality
     public static By errormessage1 = By.xpath("//*[@id=\"locOneValid\"]");
     public static By errormessage2 = By.xpath("//*[@id=\"locTwoValid\"]");
     public static By errorempty1 = By.xpath("//*[@id=\"locOneEmpty\"]");
     public static By errorempty2 = By.xpath("//*[@id=\"locTwoEmpty\"]");
     
}
     