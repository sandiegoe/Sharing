package top.arexstorm.sharing.service.info;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import top.arexstorm.sharing.bean.info.CustomerInformation;
import top.arexstorm.sharing.bean.info.CustomerInformationType;
import top.arexstorm.sharing.bean.info.Information;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InformationServiceTest {

	@Autowired
	private InformationService informationService;
	
  	@Test
	public void testFindInformationById() {
  		String informationid = "2";
		CustomerInformation customerInformation = informationService.findInformationById(informationid);
		System.err.println(customerInformation);
	}

	@Test
	public void testFindAllInformation() {
		Short status = 1;
		Short important = null;
		Integer pageNum = 2;
		Integer pageSize = 2;
		List<CustomerInformation> list = informationService.findAllInformation(status, important, null, null, pageNum, pageSize);
		for (CustomerInformation customerInformation : list) {
			System.err.println(customerInformation);
		}
	}
	
	@Test
	public void testFindAllInformationByUserId() {
		Short status = 1;
		Short important = null;
		String userid = "1";
		Integer pageNum = 1;
		Integer pageSize = 3;
		List<CustomerInformation> list = informationService.findAllInformation(status, important, userid, null, pageNum, pageSize);
		for (CustomerInformation customerInformation : list) {
			System.err.println(customerInformation);
		}
	}

	@Test
	public void testFindInformationTypeByInformationId() {
		String informationid = "2";
		CustomerInformationType cit = informationService.findInformationTypeByInformationId(informationid);
		System.err.println(cit);
	}

	@Test
	public void testAddInformation() {
		Information information = new Information();
		information.setInformationid("1");
		information.setName("共享汽车");
		information.setPic("cat.png");
		information.setShortname("恭喜汽车");
		information.setStatus(Short.parseShort("1"));
		information.setSummary("这是共享汽车");
		information.setTypeid("2");
		information.setTypename("汽车");
		information.setUserid("1");
		informationService.addInformation(information);
	}

	@Test
	public void testUpdateInformationStatus() {
		String informationid = "2";
		Short status = 0;
		informationService.updateInformationStatus(informationid, status);
	}

	@Test
	public void testUpdateInformation() {
		String informationid = "2";
		Information information = new Information();
		information.setStatus(Short.parseShort("1"));
		information.setPic("/img/wine.jpg");
		informationService.updateInformation(information, informationid);
	}

	@Test
	public void testDeleteInformationByInfomationId() {
		String informationid = "2";
		informationService.deleteInformationByInfomationId(informationid);
	}

	@Test
	public void testFindAllBuyInformation() {
		String userid = "xiebo";
		Short status = 0;
		List<CustomerInformation> infoList = informationService.findAllBuyInformation(userid, status);
		for (CustomerInformation customerInformation : infoList) {
			System.err.println(customerInformation);
		}
	}
}
