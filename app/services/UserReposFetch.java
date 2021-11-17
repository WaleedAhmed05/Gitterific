package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.fasterxml.jackson.databind.JsonNode;
import model.UserRepos;

/**
 * @author maha_
 *
 */

public class UserReposFetch {
	UserRepos users;

	public UserReposFetch() {
		this.users = new UserRepos();

	}
	
	/**
	 * @param users repositories constructor
	 */

	public UserReposFetch(UserRepos users) {
		this.users = users;

	}
	
	/**
	 * @param data passed in json node format
	 * @return list of profile details array
	 * @throws InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied
	 * @throws ExecutionException Exception thrown when attempting to retrieve the result of a taskthat aborted by throwing an exception.
	 */

	public List<UserRepos> getUsersReposList(JsonNode data) throws InterruptedException, ExecutionException {

		List<UserRepos> users = new ArrayList<UserRepos>();
		
		for(int i = 0; data.get(i)!= null; i++) {
			JsonNode item = data.get(i);
			users.add(new UserRepos(item.get("owner").get("repos_url").asText(), item.get("name").asText()));
		}
		return users;

	}
}