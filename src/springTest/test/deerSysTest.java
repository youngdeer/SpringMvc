package springTest.test;

import deerSYS.system.service.SystemService;

public class deerSysTest {

	public static void main(String[] args){
		SystemService systemService = new SystemService();
		systemService.isExistUsername("deer");
	}
}
