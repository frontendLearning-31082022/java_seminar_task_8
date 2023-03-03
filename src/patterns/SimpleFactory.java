package patterns;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.HashMap;

public class SimpleFactory {
    public static void main(String[] args) {
        Company.main(null);
    }
    static class Company{
        public static void main(String[] args) {
            Company company=new Company();
            company.hireNewWorker(new String[]{"Engineer","5 years experience"});
            company.hireNewWorker(new String[]{"Designer"});
            company.hireNewWorker(new String[]{"Mechanic","Ready to buisness trips"});
        }
        void hireNewWorker(String[]args){
            HeadRecrutmentAgencyFactory simpleFactory=new HeadRecrutmentAgencyFactory();
            simpleFactory.hireNewWorker(args);
        }
    }


    static class HeadRecrutmentAgencyFactory{
        HeadRecrutmentAgencyFactory(){}
        Worker hireNewWorker(String[]args){
            HashMap<String,String>reqs=analyzeRequirments(args);
            FindingDepartment findingDepartment=new FindingDepartment();
            ArrayList<Worker>collectSample=findingDepartment.getSample();
            ReviewsDepartment reviewsDepartment= new ReviewsDepartment();
            Worker niceExample=reviewsDepartment.getSample();
            return niceExample;
        }
        private HashMap<String, String> analyzeRequirments(String[] args) {return null;}
    }

    public static class ReviewsDepartment {
        ReviewsDepartment(){}
        public Worker getSample() { return null;}
    }


    public static class FindingDepartment {
        public ArrayList<Worker> getSample() { return null;}
    }

    interface Worker{
        String getName();
        int experctedSalary();
        HashMap<String,String>getSkills();
    }
}
