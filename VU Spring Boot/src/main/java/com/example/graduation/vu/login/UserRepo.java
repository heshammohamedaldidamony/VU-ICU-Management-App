package com.example.graduation.vu.login;

import com.example.graduation.vu.entity.Doctor;
import com.example.graduation.vu.entity.Nurse;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends CrudRepository<User,String > {
    @Query("select doctor.id_doctor,doctor.name,doctor.specialize,doctor.street,doctor.zone,doctor.picture,phone_doctor.phone from icu_management.doctor\n" +
            "join phone_doctor on doctor.id_doctor=phone_doctor.id_doctor\n" +
            "where phone_doctor.phone=:phone")
    public Doctor findDoctorByPhone(String phone);
    @Query("select nurse.id_nurse,nurse.name,nurse.street,nurse.zone,nurse.picture,phone_nurse.phone from icu_management.nurse\n" +
            "join phone_nurse on nurse.id_nurse=phone_nurse.id_nurse\n" +
            "where phone_nurse.phone=:phone")
    public Nurse findNurseByPhone(String phone);

}
