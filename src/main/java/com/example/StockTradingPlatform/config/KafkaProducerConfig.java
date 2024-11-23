//package com.example.StockTradingPlatform.config;
//
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaProducerConfig {
//
//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-p11xm.us-east-1.aws.confluent.cloud:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put("sasl.jaas.config",
//                "org.apache.kafka.common.security.plain.PlainLoginModule required " +
//                        "username='LSBKYC7Q25YZLRNN' password='iMIWMxL4hm0ugTIfbbFsd8mKsS1Grc/bUh/kEGIN8CNk3ZVAM6cUUAVvUTWnBl+s';");
//        configProps.put("security.protocol", "SASL_SSL");
//        configProps.put("sasl.mechanism", "PLAIN");
//        configProps.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 60000);
//        configProps.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, 300000);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}