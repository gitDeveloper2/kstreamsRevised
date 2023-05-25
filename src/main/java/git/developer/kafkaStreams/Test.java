package git.developer.kafkaStreams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class Test {
@Autowired
    public void process(StreamsBuilder builder){
   KStream<String, String> kstream= builder.stream("test", Consumed.with(Serdes.String(),Serdes.String()));
   kstream.map((s, s2) -> {
       return new KeyValue<>("name","rooservelt");
           }).groupByKey(Grouped.with(Serdes.String(),Serdes.String()))
           .reduce((aggValue, newValue) ->aggValue+newValue )
           .toStream()
           .to("quickstart-topic",Produced.with(Serdes.String(),Serdes.String()));
    }
}
