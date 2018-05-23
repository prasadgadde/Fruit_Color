

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TheMapper  extends Mapper<LongWritable, Text, Text, Text>
{

  
  

  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    

   
      context.write(new Text("abc"), value);
   
  }
}