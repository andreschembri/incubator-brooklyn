package brooklyn.rest.commands.catalog;

import brooklyn.rest.commands.BrooklynCommand;
import com.sun.jersey.api.client.GenericType;
import com.yammer.dropwizard.client.JerseyClient;
import com.yammer.dropwizard.json.Json;
import java.util.List;
import javax.ws.rs.core.MediaType;
import org.apache.commons.cli.CommandLine;

public class ListCatalogEntitiesCommand extends BrooklynCommand {

  public ListCatalogEntitiesCommand() {
    super("catalog-entities", "List all the entities from the catalog");
  }

  @Override
  protected void run(Json json, JerseyClient client, CommandLine params) throws Exception {
    List<String> entities = client.resource(uriFor("/v1/catalog/entities"))
        .type(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<String>>() {
        });
    for (String entity : entities) {
      System.out.println(entity);
    }
  }
}