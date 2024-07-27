# Payment Microservice [Backend]

This service demonstrates the operation of a Kafka producer. It receives an object through a REST controller, processes it, and sends a PaymentCreatedEvent object to the Kafka broker.
In this Git repository, you can find the [NotificationMicroservice](https://github.com/sakovolga/NotificationMicroservice), which is a Kafka consumer.

## Some commands for working with the Kafka message broker.

```jshelllanguage
# Generate UUID for Kafka Cluster
bin/kafka-storage.bat random-uuid

# Format Kafka storage (necessary for KRaft mode)
bin/kafka-storage.sh format -t <uuid> -c config/kraft/server.properties

# Start Kafka server
bin/kafka-server-start.sh config/server.properties

# Create a topic
bin/kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092

# List topics
bin/kafka-topics.sh --list --bootstrap-server localhost:9092

# List of topics with description
bin/kafka-topics.bat --describe --bootstrap-server localhost:9092

# Delete a topic
bin/kafka-topics.sh --delete --topic my-topic --bootstrap-server localhost:9092

# Describe the configuration of a topic
bin/kafka-configs.sh --describe --entity-type topics --entity-name my-topic --bootstrap-server localhost:9092

# Alter the configuration of a topic
bin/kafka-configs.sh --alter --entity-type topics --entity-name my-topic --add-config retention.ms=604800000 --bootstrap-server localhost:9092

# Start a Kafka producer
bin/kafka-console-producer.sh --topic my-topic --bootstrap-server localhost:9092

# Start a Kafka consumer
bin/kafka-console-consumer.sh --topic my-topic --from-beginning --bootstrap-server localhost:9092

# Check consumer groups
bin/kafka-consumer-groups.sh --list --bootstrap-server localhost:9092

# Describe a consumer group
bin/kafka-consumer-groups.sh --describe --group my-group --bootstrap-server localhost:9092

# Delete a consumer group
bin/kafka-consumer-groups.sh --delete --group my-group --bootstrap-server localhost:9092

# Alter the configuration of a broker
bin/kafka-configs.sh --alter --entity-type brokers --entity-name <broker-id> --add-config log.retention.hours=168 --bootstrap-server localhost:9092

# Describe the configuration of a broker
bin/kafka-configs.sh --describe --entity-type brokers --entity-name <broker-id> --bootstrap-server localhost:9092


