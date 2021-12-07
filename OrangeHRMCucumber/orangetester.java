package Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features="C:\\Users\\DHVITTHA\\eclipse-workspace\\sample\\src\\test\\java\\Cucumber\\feature\\orange.feature",
glue="Cucumber",
monochrome=true)


public class orangetester {

}