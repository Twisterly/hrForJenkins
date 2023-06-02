package by.masha.cha.dao;

import by.masha.cha.MysqlJdbcDataSource;
import by.masha.cha.model.Employee;
import by.masha.cha.model.JobTitle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class EmployeeDao {

    public Connection connection = new MysqlJdbcDataSource().getConnection();

    public List<Employee> index() {

        List<Employee> employees = new ArrayList<>();
        try {
            Statement statement =
                    connection.createStatement();
            java.lang.String SQL = ("SELECT * FROM employees " +
                    "JOIN employees_projects ON employees.employee_id = " +
                    "employees_projects.employeeID  " +
                    "JOIN projects ON projects.project_id=employees_projects" +
                    ".projectID  " +
                    "JOIN job_title ON employees.job_title_id=job_title" +
                    ".job_id;");
//            String SQL = "SELECT *FROM employees JOIN job_title ON
//            employees.job_title_id=job_title.job_id";
//            String SQL = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Employee employee = new Employee();
                JobTitle jobTitle = new JobTitle();
                List<String> projects = new ArrayList<>();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setBirthDate(resultSet.getDate("birth_date"));
                employee.setCellPhone(resultSet.getString("cell_phone"));
                jobTitle.setId(resultSet.getInt("job_id"));
                jobTitle.setJobTitleName(resultSet.getString
                        ("job_title_name"));
                employee.setJobTitle(jobTitle);
//                projects.add(resultSet.getString("project_name"));
//                employee.setProjects(projects);


                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }

        return employees;


    }

    public void save(Employee employee) {

        try (Connection connection = new MysqlJdbcDataSource().getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO employees " +
                             "VALUES (?,?,?,?,?,?)")) {
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthDate());
            preparedStatement.setString(5, employee.getCellPhone());
//            preparedStatement.setInt(6, employee.getJobId());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement(
//                            "INSERT INTO employees VALUES (?,?,?,?,?)");
//
//            preparedStatement.setInt(1, employee.getId());
//            preparedStatement.setString(2, employee.getFirstName());
//            preparedStatement.setString(3, employee.getLastName());
//            preparedStatement.setDate(4, employee.getBirthDate());
//            preparedStatement.setString(5, employee.getCellPhone());
//            preparedStatement.setInt(6, employee.getJobId());
//
//            preparedStatement.executeUpdate();
//            connection.commit();
//            connection.close();
//
//
//        } catch (SQLException e) {
//            System.out.println("We caught it: " + e.getMessage());
//            throw new RuntimeException(e);//можно убрать
//        }


    }

    public Employee getById(Integer id) {

        Employee employee = null;
// String SQL = "SELECT *FROM employees JOIN job_title ON employees
// .job_title_id=job_title.job_id"
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "SELECT * FROM employees WHERE employee_id = ? ");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            employee = new Employee();
            employee.setId(resultSet.getInt("employee_id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setBirthDate(resultSet.getDate("birth_date"));
            employee.setCellPhone(resultSet.getString("cell_phone"));
        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }
        return employee;
    }

    public void update(Integer id, Employee updatedEmployee) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "UPDATE employees SET first_name=?, last_name=?, " +
                                    "birth_date=?, cell_phone=?, jobId=? " +
                                    "WHERE employee_id=?"
                    );

            preparedStatement.setString(1, updatedEmployee.getFirstName());
            preparedStatement.setString(2, updatedEmployee.getLastName());
            preparedStatement.setDate(3, updatedEmployee.getBirthDate());
            preparedStatement.setString(4, updatedEmployee.getCellPhone());
            //           preparedStatement.setInt(5, updatedEmployee.getJobId
            //           ());

            preparedStatement.executeUpdate();
            connection.commit();
            connection.close();

        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "DELETE FROM employees WHERE employee_id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("We caught it: " + e.getMessage());
        }
    }
}
