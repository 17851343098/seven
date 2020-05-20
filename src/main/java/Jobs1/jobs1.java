package Jobs1;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.*;
import java.nio.charset.Charset;

public class jobs1 {
    public static void main(String[] args) throws IOException {
        String srcCSV = "D:\\下载的哦\\任务\\jobs1.csv";
        String targetFile = "D:\\下载的哦\\任务\\test1.csv";
        CsvReader reader = new CsvReader(srcCSV, ',', Charset.forName("GBK"));
        CsvWriter write =new CsvWriter(targetFile,',',Charset.forName("GBK"));
        //各字段以引号标记
        //write.setForceQualifier(true);
        //路过表头
        //r.readHeaders();
        //逐条读取记录，直至读完
        String[] header = {};
        StringBuilder sb = new StringBuilder();
        while (reader.readRecord()) {
//        //把头保存起来
            if (reader.getCurrentRecord() == 0) {
                header = reader.getValues();
                for(String x:header){
                    if(sb.length()>0){
                        sb.append(",");
                    }
                    sb.append(x);
                    //System.out.println(x);
                }
                System.out.print(sb.toString());
            }

//            reader.get(13)

            if (!(reader.getRawRecord().equals(sb.toString())) || reader.getCurrentRecord() == 0){
                System.out.println(reader.getRawRecord());
                write.writeRecord(reader.getRawRecord().split(","));
            }
        }
        //获取当前记录位置
        System.out.println();
        System.out.println("获取记录数："+reader.getCurrentRecord() + ".");
        reader.close();
        write.close();
    }
}