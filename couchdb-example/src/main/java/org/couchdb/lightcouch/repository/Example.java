package org.couchdb.lightcouch.repository;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.couchdb.lightcouch.object.GenericModel;
import org.couchdb.lightcouch.object.Model;
import org.lightcouch.CouchDbClient;
import org.lightcouch.ReplicationResult;
import org.lightcouch.Response;

public class Example {

	public static void main(String args[]) throws IOException {
		CouchDbClient dbClient = new CouchDbClient();

		GenericModel foo = new GenericModel(null, null, null, 0); // Plain Java Object

		Response response = dbClient.save(foo);
		foo.setId(response.getId());
		foo.setRevision(response.getRev());

		//foo = dbClient.find(Foo1.class);
		//foo.setAddress("5841 Rue Anne-Courtemanche, Montreal, H1K0H6, QC");

		response = dbClient.update(foo);
		foo.setId(response.getId());
		foo.setRevision(response.getRev());
		
		System.out.println("The foo is " + ToStringBuilder.reflectionToString(foo));

		//any delete operation without providing the current revision will cause conflicts
		dbClient.remove(foo);

		boolean b = dbClient.contains("1");

		// views
		List<Model> list = dbClient.view("_all_docs").includeDocs(true).query(Model.class);
				
		System.out.println("All all docs view " + list.size());

		list.stream().forEach(t -> {System.out.println(ToStringBuilder.reflectionToString(t));});
		//long count = dbClient.view("ddoc/by_tag").key("couchdb").queryForLong();

		// attachments
		//response = dbClient.saveAttachment(inputStream, "photo.png", "image/png");
		//InputStream in = dbClient.find("1/firstName");
		//in.close();

		// replication
		ReplicationResult replication = dbClient.replication().source("testdb").target("testdb2")
				.createTarget(true).trigger();

		// changes feed
		/*Changes changes = dbClient.changes().includeDocs(true).heartBeat(30000).timeout(10000);
		
		while (changes.hasNext()) {
			ChangesResult.Row feed = changes.next();
			System.out.println("The feed is "  + ToStringBuilder.reflectionToString(feed));
		}*/
		
		//find all historical revisions
		//dbClient.
		
		//dbClient.
				
		System.out.println("Shutdown the couchdb client");
		// shutdown the client
		dbClient.shutdown();
	}

}
