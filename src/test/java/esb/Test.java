package esb;

import com.zcbl.esb.EsbClient;

public class Test {
	public static void main(String[] args) {
		EsbClient.http("http://www.baidu.com").request("sdfsdfd").send();
	}
}
