package test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.job.pojo.Job;

/**
 * 测试员工Service
 * @author Administrator
 *
 */
public class TestEmpService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private EmpService service = context.getBean(EmpService.class);
	
	@Test
	public void testInsert() throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptId(70);
		
		Job job = new Job();
		job.setJobId(4);
		
		Emp emp = new Emp("李四","lisi","666999","lisi@163.com","13012345678"
				,Date.valueOf("2005-01-01"),6000.0,dept,job,null,"无");	
		
		service.addEmp(emp);
	}
	

	@Test
	public void testInsert2() throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptId(3);
		
		Job job = new Job();
		job.setJobId(3);
		
		for (int i = 1;i <= 10; i ++) {
			Emp emp = new Emp("jack" + i,"jack" + i,"123456","lisi@163.com","13012345678"
					,Date.valueOf("2005-01-01"),8000.0 + i*10,dept,job,null,"无");	
			
			service.addEmp(emp);
		}
	}
	
	
	@Test
	public void testUpdate() throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptId(50);
		
		Job job = new Job();
		job.setJobId(2);
		
		Emp emp = new Emp(101,"张三","zhangsan","999999","zhangsan33333@163.com","13033333333"
				,Date.valueOf("2011-09-09"),7500.0,dept,job,null,"擅长大数据");	
		
		service.updateEmp(emp);
		
	}
	
	@Test
	public void testDelete() throws SQLException {
		
		service.deleteEmp(101);
	
	}
	
	@Test
	public void testQueryById() throws SQLException {
		
		System.out.println(service.queryEmpById(3));
	}
	
	
	@Test
	public void testQueryByPage() throws SQLException {
		
		Pager pager = new Pager(service.getEmpCount(), 7, 1);
		
		List<Emp> list = service.queryEmpByPage(pager);
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
	}
	
	@Test
	public void testQueryByName() throws SQLException {
		
		String empPwd = service.queryEmpPwd("rose");
		
		System.out.println(empPwd);
	}
	
	@Test
	public void testQueryEmpPic() throws SQLException {
		String empPic = service.queryEmpPic("rose");
		
		System.out.println(empPic);
	}	
	
	@Test
	public void testUpdateEmpPic() throws SQLException {
		
		service.updateEmpPic("jack8", null);
		
	}	
	
	@Test
	public void testUpdateEmpPwd() throws SQLException {
		
		service.updateEmpPwd("jack8", "666999");
		
	}
	
	@Test
	public void testGetCount() {
		int count = service.getEmpCount();
		
		System.out.println(count);
	}
	
	@Test
	public void testCheckLogin() throws SQLException {
		int result = service.checkLogin("xxxxxx", "666666");
		
		System.out.println(result);
	}
	
	
}