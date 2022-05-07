package phambaongoc.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServive {
    @Autowired
    private StudenRepository studenRepository;

    public List<Student> findAll(){return studenRepository.findAll();}

    public Optional<Student> findById(long id) {
        return studenRepository.findById((id));
    }

    public Student save(Student employe) {
        return studenRepository.save(employe);
    }

    public void deleteById(long id) {
        studenRepository.deleteById((id));
    }
}

