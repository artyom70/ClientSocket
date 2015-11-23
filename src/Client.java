import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("localhost"), 8606);
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			
			DataOutputStream dout = new DataOutputStream(out);
			DataInputStream din = new DataInputStream(in);
			
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while(true) {
				line = console.readLine();
				dout.writeUTF(line);
				line = din.readUTF();
				System.out.println(line);
				
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
