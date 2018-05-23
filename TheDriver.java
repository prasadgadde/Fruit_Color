

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;


import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
public class TheDriver {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Job job;
		 
		try {
			job = Job.getInstance();
	
		    job.setJarByClass(TheDriver.class);
		    job.setJobName("WordCounter");

		    FileInputFormat.addInputPath(job, new Path(args[0]));
		    FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		    
		    job.setMapperClass(TheMapper.class);
		    job.setReducerClass(TheReducer.class);
		    
		    job.setMapOutputKeyClass(Text.class);
		    job.setMapOutputValueClass(Text.class);

		    MultipleOutputs.addNamedOutput(job, "fruits", TextOutputFormat.class, NullWritable.class, Text.class);
		    MultipleOutputs.addNamedOutput(job, "colors", TextOutputFormat.class, NullWritable.class, Text.class);
		    
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}