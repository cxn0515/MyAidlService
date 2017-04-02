package com.example.aidldemo.myaidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    private MySchoolBinder mySchoolBinder;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mySchoolBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mySchoolBinder = new MySchoolBinder();
    }


    private class MySchoolBinder extends ISchool.Stub {
        @Override
        public String getSchoolName() throws RemoteException {
            return "第一高级中学";
        }

        @Override
        public int getStudentNum() throws RemoteException {
            return 3000;
        }

        @Override
        public Student getStudent() throws RemoteException {
            Student student = new Student();
            student.setName("xiaohong");
            student.setAge(18);
            return student;
        }
    }
}
