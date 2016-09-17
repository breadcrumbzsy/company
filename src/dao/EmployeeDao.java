package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Employee;
import domain.Skill;
import domain.Training;

public class EmployeeDao {
	private QueryRunner qr = new TxQueryRunner();

	public int add(int eid, String name, String gender, String email,
			String tel, Date enrollTime, String level, String department,
			int isQuit,String password) {
		try {
			String sql = "insert into employee(eid,name,gender,email,tel,enrollTime,level,department,isQuit,password) values(?,?,?,?,?,?,?,?,?,?)";
			Object[] params = { eid, name, gender, email, tel, enrollTime,
					level, department, isQuit,password };
			this.qr.update(sql, params);
			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}

	public int addSkill(int eid, String description) {
		try {
			// 是不是应该回滚
			String sql = "insert into skill(eid,description) values(?,?)";
			Object[] params = { eid, description };
			this.qr.update(sql, params);

			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}

	public int addSkills(int eid, List<String> skills) {
		try {
			for (int i = 0; i < skills.size(); i++) {
				if (!skills.get(i).equals("")&&skills.get(i)!=null) {
					String description = skills.get(i);
					// 是不是应该回滚
					String sql = "insert into skill(eid,description) values(?,?)";
					Object[] params = { eid, description };
					this.qr.update(sql, params);
				}
			}
			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteSkill(int sklid) {
		try {
			String sql = "delete from skill where sklid=? ";
			this.qr.update(sql, sklid);
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}

	public int addTraining(int eid, String description) {
		try {
			// 是不是应该回滚
			String sql = "insert into training(eid,description) values(?,?)";
			Object[] params = { eid, description };
			this.qr.update(sql, params);

			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int addTrainings(int eid, List<String> trainings) {
		try {
			for (int i = 0; i < trainings.size(); i++) {
				if (!trainings.get(i).equals("")&&trainings.get(i)!=null) {
					// 是不是应该回滚
					String sql = "insert into training(eid,description) values(?,?)";
					Object[] params = { eid, trainings.get(i) };
					this.qr.update(sql, params);
				}
			}
			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteTraining(int tid) {
		try {
			String sql = "delete from training where tid=? ";
			this.qr.update(sql, tid);
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}

	public int modifyInfo(int eid, String email, String tel, String level,
			String department, int isQuit) {
		try {
			String sql = "update employee set email=?,tel=?,level=?,department=?,isQuit=? where eid=?";
			Object[] params = { email, tel, level, department, isQuit, eid };
			this.qr.update(sql, params);
			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}
	public int modifyPassword(int eid,String newPassword) {
		try {
			String sql = "update employee set password=? where eid=?";
			Object[] params = {newPassword,eid };
			this.qr.update(sql, params);
			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}


	

	public List<Employee> findByName(String name) {
		try {
			String sql = "select * from employee where name=?"; //order by isQuit
			List<Employee> list = (List<Employee>) this.qr.query(sql,
					new BeanListHandler<Employee>(Employee.class),
					new Object[] { name });
			//List<Employee> employeeList = new ArrayList<Employee>();
			return list;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Employee> findByDepartment(String department) {
		try {
			String sql = "select * from employee where department=? ";//order by isQuit
			List<Employee> list = (List<Employee>) this.qr.query(sql,
					new BeanListHandler<Employee>(Employee.class),
					new Object[] { department });
			//List<Employee> employeeList = new ArrayList<Employee>();
			return list;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Employee> findByBoss() {
		try {
			String sql = "select * from employee  order by isQuit";//order by isQuit
			List<Employee> list = (List<Employee>) this.qr.query(sql,
					new BeanListHandler<Employee>(Employee.class));
			//List<Employee> employeeList = new ArrayList<Employee>();
			return list;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public int quit(int eid) {
		try {
			String sql = "update employee set isQuit=? where eid=?";
			Object[] params = {1,eid };
			this.qr.update(sql, params);
			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}

	public Employee findByEid(int eid) {
		try {
			String sql = "select * from employee where eid=? ";
			List<Employee> list = this.qr.query(sql, new BeanListHandler<Employee>(
					Employee.class), new Object[] { eid });
			Employee employee;

			if (list.size() == 0) {
				employee = null;
			} else {
				employee = (Employee) list.get(0);
				String sqlSkill = "select * from skill where eid=? ";
				String sqlTraining = "select * from training where eid=? ";
				List<Skill> skill = this.qr.query(sqlSkill,
						new BeanListHandler<Skill>(Skill.class),
						new Object[] { eid });
				List<Training> training = this.qr.query(sqlTraining,
						new BeanListHandler<Training>(Training.class),
						new Object[] { eid });
				employee.setSkill(skill);
				employee.setTraining(training);
				System.out.println("find by eid:" + employee);
			}
			return employee;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Employee> findDeptMng() {
		try {
			String sql = "select * from employee where level='部门经理' ";//order by isQuit
			List<Employee> list = (List<Employee>) this.qr.query(sql,
					new BeanListHandler<Employee>(Employee.class));
			//List<Employee> employeeList = new ArrayList<Employee>();
			return list;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
