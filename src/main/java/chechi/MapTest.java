package chechi;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class MapTest extends Mapper<Object, Text, Text, IntWritable> {

    private static IntWritable one = new IntWritable(1);

    private Text word = new Text();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer st = new StringTokenizer(value.toString());
        while (st.hasMoreTokens()) {
            word.set(st.nextToken());
            context.write(word, one);
        }
    }
}

