# Dataverse Publisher

This is an Java application that uploads (publishes) a local file to
a pre-specified dataverse destination.  Before using this application, 
its user is expected to do the following dataverse(destination)-related tasks:

* create a login account on a target dataverse and generate an API-key
* create a target dataverse (and record its alias)
* create a target dataset under the above target dataverse (and record its 
persistent id such as "doi:xxxxx")

## how to use
### run the "uber" jar from command prompt

    java -jar dataverse-publisher-1.0.0.0-SNAPSHOT-jar-with-dependencies.jar dataverse_url api_key dataverse_alias dataset_id file_location



### Calling the main method within a code block in Java

    String dataverse_url = "...";
    String api_key = "...";
    String dataverse_alias = "...";

    DataverseClient dvClient = new DataverseClient(dataverse_url, api_key, dataverse_alias);
        
    String dataset_id = "...";
    String file_location = "...";

    dvClient.publishDatafile(dataset_id, file_location);

* note: A dataverse url starts from "https://" and a dataset id exclude include "doi:"