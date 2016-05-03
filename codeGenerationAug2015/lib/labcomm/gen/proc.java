/* 
sample struct {
  string command;
  int status;
  int extCntr;
  int sensor1;
  int sensor2;
  int sensor3;
  int sensor4;
  int sensor5;
  int sensor6;
} proc;
*/
import java.io.IOException;
import se.lth.control.labcomm2006.LabCommDecoder;
import se.lth.control.labcomm2006.LabCommDispatcher;
import se.lth.control.labcomm2006.LabCommEncoder;
import se.lth.control.labcomm2006.LabCommHandler;
import se.lth.control.labcomm2006.LabCommSample;

public class proc implements LabCommSample {

  public String command;
  public int status;
  public int extCntr;
  public int sensor1;
  public int sensor2;
  public int sensor3;
  public int sensor4;
  public int sensor5;
  public int sensor6;
  
  public interface Handler extends LabCommHandler {
    public void handle_proc(proc value) throws Exception;
  }
  
  public static void register(LabCommDecoder d, Handler h) throws IOException {
    d.register(new Dispatcher(), h);
  }
  
  public static void register(LabCommEncoder e) throws IOException {
    e.register(new Dispatcher());
  }
  
  private static class Dispatcher implements LabCommDispatcher {
    
    public Class getSampleClass() {
      return proc.class;
    }
    
    public String getName() {
      return "proc";
    }
    
    public byte[] getSignature() {
      return signature;
    }
    
    public void decodeAndHandle(LabCommDecoder d,
                                LabCommHandler h) throws Exception {
      ((Handler)h).handle_proc(proc.decode(d));
    }
    
  }
  
  public static void encode(LabCommEncoder e, proc value) throws IOException {
    e.begin(proc.class);
    e.encodeString(value.command);
    e.encodeInt(value.status);
    e.encodeInt(value.extCntr);
    e.encodeInt(value.sensor1);
    e.encodeInt(value.sensor2);
    e.encodeInt(value.sensor3);
    e.encodeInt(value.sensor4);
    e.encodeInt(value.sensor5);
    e.encodeInt(value.sensor6);
    e.end(proc.class);
  }
  
  public static proc decode(LabCommDecoder d) throws IOException {
    proc result;
    result = new proc();
    result.command = d.decodeString();
    result.status = d.decodeInt();
    result.extCntr = d.decodeInt();
    result.sensor1 = d.decodeInt();
    result.sensor2 = d.decodeInt();
    result.sensor3 = d.decodeInt();
    result.sensor4 = d.decodeInt();
    result.sensor5 = d.decodeInt();
    result.sensor6 = d.decodeInt();
    return result;
  }
  
  private static byte[] signature = new byte[] {
    // struct { 9 fields
    0, 0, 0, 17, 
      0, 0, 0, 9, 
      // string 'command'
      0, 0, 0, 7, 
      99, 111, 109, 109, 97, 110, 100, 
      0, 0, 0, 39, 
      // int 'status'
      0, 0, 0, 6, 
      115, 116, 97, 116, 117, 115, 
      0, 0, 0, 35, 
      // int 'extCntr'
      0, 0, 0, 7, 
      101, 120, 116, 67, 110, 116, 114, 
      0, 0, 0, 35, 
      // int 'sensor1'
      0, 0, 0, 7, 
      115, 101, 110, 115, 111, 114, 49, 
      0, 0, 0, 35, 
      // int 'sensor2'
      0, 0, 0, 7, 
      115, 101, 110, 115, 111, 114, 50, 
      0, 0, 0, 35, 
      // int 'sensor3'
      0, 0, 0, 7, 
      115, 101, 110, 115, 111, 114, 51, 
      0, 0, 0, 35, 
      // int 'sensor4'
      0, 0, 0, 7, 
      115, 101, 110, 115, 111, 114, 52, 
      0, 0, 0, 35, 
      // int 'sensor5'
      0, 0, 0, 7, 
      115, 101, 110, 115, 111, 114, 53, 
      0, 0, 0, 35, 
      // int 'sensor6'
      0, 0, 0, 7, 
      115, 101, 110, 115, 111, 114, 54, 
      0, 0, 0, 35, 
    // }
  };

}
