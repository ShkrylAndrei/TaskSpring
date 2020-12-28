package ru.andrei.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.andrei.model.Message;

public interface MessageMongoRepository extends MongoRepository<Message,Long> {
}

//public interface EmployeeRepository extends MongoRepository<Employee, Long> { // Long: Type of Employee ID.
//
//    Employee findByEmpNo(String empNo);
//
//    List<Employee> findByFullNameLike(String fullName);
//
//    List<Employee> findByHireDateGreaterThan(Date hireDate);
//
//    // Supports native JSON query string
//    @Query("{fullName:'?0'}")
//    List<Employee> findCustomByFullName(String fullName);
//
//}
