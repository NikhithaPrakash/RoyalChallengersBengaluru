package RCB;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

import com.sun.xml.xsom.impl.Ref.ContentType;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
	public class RoyalChallengersBengaluru {
		
		
		
		
		@Test
		public void testNumberOfForeignPlayers() {
		RequestSpecification requestSpec = given()
		.header("Content-Type", "application/json");
		Response response = requestSpec.get("/team/Royal Challengers Bangalore");

		JsonPath jsonPath = response.jsonPath();
		int numForeignPlayers = jsonPath.getList("player.findAll { it.country != 'India' }").size();

		 assertEquals(4, numForeignPlayers);
		}
		
		@Test
		public void testTeamHasAtLeastOneWicketKeeper() {
		RequestSpecification requestSpec = given()
		.header("Content-Type", "application/json");
		Response response = requestSpec.get("/team/Royal Challengers Bangalore");
		
		JsonPath jsonPath = response.jsonPath();
      List<String> wicketKeepers = jsonPath.getList("player.findAll { it.role == 'Wicket-keeper' }.name");
		assertTrue(wicketKeepers.size() >= 1);
		}
		

	}


