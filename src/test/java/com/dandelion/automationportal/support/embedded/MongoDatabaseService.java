package com.dandelion.automationportal.support.embedded;

public interface MongoDatabaseService {

    /**
     * <p>Creates database with all collections and fills it with appropriate data from .json files</p>
     */
    void createDatabase();

    /**
     * <p>Drops database</p>
     */
    void dropDatabase();

    /**
     * <p>Creates database with single collection and fills it with appropriate data from .json files</p>
     * @param collectionName  name of the collection that will be created
     */
    void createCollection(String collectionName);

    /**
     * <p>Removes single collection from database</p>
     * @param collectionName  name of the collection that will be removed
     */
    void dropCollection(String collectionName);
}
