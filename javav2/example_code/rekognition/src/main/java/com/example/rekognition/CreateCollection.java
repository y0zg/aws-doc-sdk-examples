// snippet-sourcedescription:[CreateCollection.java demonstrates how to create an Amazon Rekognition collection.]
// snippet-service:[Amazon Rekognition]
// snippet-keyword:[Java]
// snippet-keyword:[Amazon Rekognition]
// snippet-keyword:[Code Sample]
// snippet-sourcetype:[full-example]
// snippet-sourcedate:[6-10-2020]
// snippet-sourceauthor:[scmacdon - AWS]

/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * This file is licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License. A copy of
 * the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.example.rekognition;

// snippet-start:[rekognition.java2.create_collection.import]
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.CreateCollectionResponse;
import software.amazon.awssdk.services.rekognition.model.CreateCollectionRequest;
import software.amazon.awssdk.services.rekognition.model.RekognitionException;
// snippet-end:[rekognition.java2.create_collection.import]

public class CreateCollection {

    public static void main(String[] args) {

        final String USAGE = "\n" +
                "CreateCollection - creates a collection\n\n" +
                "Usage: CreateCollection <collectionName> \n\n" +
                "Where:\n" +
                "  collectionName - the name of the collection \n\n";

        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String collectionId = args[0];

        Region region = Region.US_EAST_2;
        RekognitionClient rekClient = RekognitionClient.builder()
                .region(region)
                .build();

        System.out.println("Creating collection: " +
                collectionId);

        createMyCollection(rekClient, collectionId );
    }

    // snippet-start:[rekognition.java2.create_collection.main]
    public static void createMyCollection(RekognitionClient rekClient,String collectionId ) {

        try {
            CreateCollectionRequest collectionRequest = CreateCollectionRequest.builder()
                    .collectionId(collectionId)
                    .build();

            CreateCollectionResponse collectionResponse = rekClient.createCollection(collectionRequest);
            System.out.println("CollectionArn : " +
                    collectionResponse.collectionArn());
            System.out.println("Status code : " +
                    collectionResponse.statusCode().toString());

        } catch(RekognitionException e) {
                System.out.println(e.getMessage());
                System.exit(1);
        }
        // snippet-end:[rekognition.java2.create_collection.main]
    }
}
