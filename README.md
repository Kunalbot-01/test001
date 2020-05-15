# test001

element = driver.findElement(By.id(locatorvalue));
					if (action.equalsIgnoreCase("ENTER_TEXT")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("CLICK")) {
						element.click();
					}

					locatorType = null;
					break;
				case "xpath":
					driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
					element = driver.findElement(By.xpath(locatorvalue));

					if (action.equalsIgnoreCase("sendkeys")) {
						element.clear();
						driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("CLICK")) {
						Thread.sleep(4000);
						element.click();
					} else if (action.equalsIgnoreCase("VERIFY_TEXT")) {
						driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
						String elementtext = element.getText();
						System.out.println("Total number of mobiles are" + elementtext);
					}

					locatorType = null;
					break;

				

				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
