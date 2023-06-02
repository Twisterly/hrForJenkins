package by.masha.cha.controllers;

import by.masha.cha.dao.EmployeeDao;
import by.masha.cha.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDao employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDAO = employeeDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("employee", employeeDAO.index());
        return "employee/index_employee";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeDAO.getById(id));
        return "employee/show_employee";
    }


    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee) {
        return "employee/new_employee";
    }


    @PostMapping()
    public String create(@ModelAttribute("employee") Employee employee) {

        employeeDAO.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("employee", employeeDAO.getById(id));
        return "employee/edit_employee";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                         @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors())
            return "employee/edit_employee";

        employeeDAO.update(id, employee);
        return "redirect:/employee";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeDAO.delete(id);
        return "redirect:/employee";
    }
}


