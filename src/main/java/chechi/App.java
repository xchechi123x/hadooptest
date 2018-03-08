package chechi;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
//        conf.set("mapred.job.tracker", "localhost:9001");

        Job job = Job.getInstance(conf, "Test");
        job.setJarByClass(App.class);
        job.setMapperClass(MapTest.class);
        job.setCombinerClass(ReduceTest.class);
        job.setReducerClass(ReduceTest.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path("hdfs://localhost:9000/test/input/"));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/test/output/"));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
