package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.fasterxml.jackson.databind.JsonNode;
import model.ListRepositories;

/**
 * 
 * @author maha_
 *
 */

public class RepositoryFetching {
    ListRepositories repository;
    
    public RepositoryFetching() {
    	this.repository = new ListRepositories();
    	
    }
    /**
     * @param repository
     */
    public RepositoryFetching(ListRepositories repository) {
    	this.repository = repository;
    	
    }
   /**
    * @author maha_
    * @param data iterating the json data
    * @return the data fetched
    * @throws InterruptedException
    * @throws ExecutionException
    */
    
    public List<ListRepositories> getList(JsonNode data) throws InterruptedException, ExecutionException {
    	
    	List<ListRepositories> repos = new ArrayList<ListRepositories>();
    	
    	data.get("items").forEach(items -> {
    		String login = items.get("owner").get("login").asText();
    		String name = items.get("name").asText();
    		String user_url = items.get("url").asText().replaceAll("http.*?\\s", " ");
    		String issues_url = items.get("issues_url").asText();
    		String visibility = items.get("visibility").asText();
    		String commits_url = items.get("commits_url").asText();
    		repos.add(new ListRepositories(login,name,user_url, issues_url,visibility,commits_url));
    	});
		return repos;
    	
    }
}
