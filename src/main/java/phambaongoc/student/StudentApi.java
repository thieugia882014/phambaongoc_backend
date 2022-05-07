package phambaongoc.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/students")
public class StudentApi {
    @Autowired
    StudentServive studentServive;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getList() {
        return ResponseEntity.ok(studentServive.findAll());
    }


    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        Optional<Student> optionalAccount = studentServive.findById(id);
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAccount.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok(studentServive.save(student));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> optionalAccount = studentServive.findById(id);
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Student existstudent = optionalAccount.get();
        existstudent.setName(existstudent.getName());
        existstudent.setGender(existstudent.getGender());
        existstudent.setEmail(existstudent.getEmail());
        existstudent.setPhonenumber(existstudent.getPhonenumber());
        existstudent.setBirthday(existstudent.getBirthday());
        existstudent.setAddress(existstudent.getAddress());
        return ResponseEntity.ok(studentServive.save(existstudent));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!studentServive.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        studentServive.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
