package chechi;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.Tool;

import java.io.IOException;

public class ToolRunTest extends Configured implements Tool, MapRunnable<Text, Text, Text, IntWritable> {


    public int run(String[] strings) throws Exception {
        return 0;
    }

    public void run(RecordReader<Text, Text> input, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

    }

    public void configure(JobConf job) {

    }
}
