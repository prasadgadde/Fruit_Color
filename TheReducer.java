
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;


import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class TheReducer 
  extends Reducer<Text, Text, NullWritable , Text > {
  
	MultipleOutputs<NullWritable , Text> mos = null;
	
	@Override
	protected void setup(Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		mos = new MultipleOutputs<NullWritable , Text>(context);
	}
	
  @Override
  public void reduce(Text key, Iterable<Text> values,
      Context context)
      throws IOException, InterruptedException {
    
	  Iterator<Text> iterator = values.iterator();
	    while (iterator.hasNext()) {
	     String data = iterator.next().toString();
	  StringTokenizer strt = new StringTokenizer(data);
	  String fruit = strt.nextToken();
	  String color = strt.nextToken();
	  mos.write("fruits", NullWritable.get(), fruit, "fruit");
	  mos.write("colors", NullWritable.get(), color, "color");
	    }
    
  }
  
  @Override
protected void cleanup(Context context)
		throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	mos.close();
}
  
}
